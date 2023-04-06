package com.linedata.lsq.controller.loanRelated;

import com.linedata.ekip.std.dao.core.exception.EkipApiException;
import com.linedata.ekip.std.services.deal.entity.Deal;
import com.linedata.ekip.std.services.drawdown.entity.Drawdown;
import com.linedata.ekip.std.services.drawdown.entity.impl.DrawdownImpl;
import com.linedata.ekip.std.services.facility.entity.Facility;
import com.linedata.lsq.service.beanRelated.BeanFactoryService;
import com.linedata.lsq.service.beanRelated.BeanFinderService;
import com.linedata.lsq.service.beanRelated.DrawdownCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;


@RestController
@RequestMapping("api/blocking/loan")
public class LoanBlockingController {

    @Autowired
    DrawdownCreatorService drawdownCreatorService;

    @Autowired
    BeanFactoryService beanFactoryService;

    @Autowired
    private BeanFinderService beanFinderService;

    private void drawdownInheritedPropertiesSetter(Drawdown drawdown, Facility facility, Deal deal) {
        drawdown.setStatusCode("CREE");
        drawdown.setFacilityId(Long.parseLong(facility.getId()));
        drawdown.setFacilityDescription(facility.getDescription());
        drawdown.setDealExternalId(deal.getExternalId());
        drawdown.setDealDescription(deal.getDescription());
        drawdown.setAdmbinderId(deal.getAdmbinderId());
    }

    @PostMapping(value = "/createWithJson")
    public ResponseEntity<?> createLoan(@RequestBody DrawdownImpl drawdown) {
        Facility facility = beanFinderService.getLiteFacilityByExternalId(drawdown.getFacilityExternalId());

        if (!(facility.getExternalId() == null)) {

            Deal deal = beanFinderService.getLiteDealByFacility(facility);

            drawdownInheritedPropertiesSetter(drawdown, facility, deal);

            try {
                drawdownCreatorService.createDrawdown(drawdown);
            } catch (EkipApiException e) {
                System.out.println(e.getMessage());
            }
            return new ResponseEntity<>(drawdown, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Facility Must Have Its Status as VALID To Be Able To Add A New Drawdown To It. ", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping(value = "/createWithParams")
    public ResponseEntity<?> createLoan(
            @RequestParam(name = "facilityExternalId") String facilityExternalId,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "borrowerExternalId") Long borrowerExternalId,
            @RequestParam(name = "effectiveDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date effectiveDate,
            @RequestParam(name = "currencyCode") String currencyCode,
            @RequestParam(name = "initialAmount") BigDecimal initialAmount
    ) {
        Facility facility = beanFinderService.getLiteFacilityByExternalId(facilityExternalId);

        if (!(facility.getExternalId() == null)) {

            Drawdown drawdown = beanFactoryService.createDrawdownBean();
            Deal deal = beanFinderService.getLiteDealByFacility(facility);

            drawdown.setFacilityExternalId(facilityExternalId);
            drawdown.setDescription(description);
            drawdown.setBorrowerThirdpartyId(borrowerExternalId);
            drawdown.setEffectiveDate(effectiveDate);
            drawdown.setCurrencyCode(currencyCode);
            drawdown.setInitialAmount(initialAmount);

            drawdownInheritedPropertiesSetter(drawdown, facility, deal);

//            Thirdparty thirdparty = beanFinderService.getLiteThirdpartyByExternalId(borrowerExternalId);
//            drawdown.setBorrowerId(thirdparty.getBorrowerId());

            try {
                drawdownCreatorService.createDrawdown(drawdown);
            } catch (EkipApiException e) {
                System.out.println(e.getMessage());
            }

            return new ResponseEntity<>(drawdown, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Facility Must Have Its Status as VALID To Be Able To Add A New Drawdown To It. ", HttpStatus.FORBIDDEN);
        }
    }

//    ____________________________________________________________________________________________________

    @GetMapping(value = "get/drawdown/byDrawdownExternalId")
    public Drawdown getDrawdownByExternalId(@RequestParam(name = "drawdownExternalId") String drawdownExternalId) {
        return beanFinderService.getLiteDrawdownByExternalId(drawdownExternalId);
    }

    @GetMapping(value = "get/facility/byFacilityExternalId")
    public Facility getFacilityByExternalId(@RequestParam(name = "facilityExternalId") String facilityExternalId) {
        return beanFinderService.getLiteFacilityByExternalId(facilityExternalId);
    }
}
