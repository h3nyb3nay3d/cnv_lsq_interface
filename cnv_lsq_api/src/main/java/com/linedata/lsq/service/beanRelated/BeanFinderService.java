package com.linedata.lsq.service.beanRelated;

import com.linedata.ekip.std.services.deal.entity.Deal;
import com.linedata.ekip.std.services.deal.entity.DealThirdParty;
import com.linedata.ekip.std.services.drawdown.entity.Drawdown;
import com.linedata.ekip.std.services.facility.entity.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeanFinderService {

    @Autowired
    private BeanFactoryService beanFactoryService;

    public Deal getLiteDealByExternalId(String externalId) {
        Deal deal = beanFactoryService.createDealBean();
        deal.setExternalId(externalId);
        deal = beanFactoryService.dealService.find(beanFactoryService.initActionContext(), deal);
        return deal;
    }

    public List<Deal> getLiteDealsByThirdPartyTiersId(String tiersId) {
        DealThirdParty dealThirdParty = beanFactoryService.createDealThirdPartyBean();
        dealThirdParty.setTiers(tiersId);
        return beanFactoryService.dealService.findByThirdParty(beanFactoryService.initActionContext(), dealThirdParty);
    }

//    ____________________________________________________________________________________________________

    public Drawdown getLiteDrawdownByExternalId(String externalId) {
        Drawdown drawdown = beanFactoryService.createDrawdownBean();
        drawdown.setExternalId(externalId);
        drawdown = beanFactoryService.drawdownService.findByExternalId(beanFactoryService.initActionContext(), drawdown);
        return drawdown;
    }

//    ____________________________________________________________________________________________________

    public Facility getLiteFacilityByExternalId(String externalId) {
        Facility facility = beanFactoryService.createFacilityBean();
        facility.setExternalId(externalId);
        facility = beanFactoryService.facilityService.findByExternalId(beanFactoryService.initActionContext(), facility);
        return facility;
    }

    public Deal getLiteDealByFacility(Facility facility) {
        return beanFactoryService.dealService.findDealByFacility(beanFactoryService.initActionContext(), facility);
    }

}
