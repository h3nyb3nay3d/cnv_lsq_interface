package com.linedata.lsq.service.beanRelated;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.context.UserContext;
import com.linedata.ekip.party.management.address.service.AddressService;
import com.linedata.ekip.party.management.party.service.PartyService;
import com.linedata.ekip.std.services.capital.service.SyndLoanCapitalService;
import com.linedata.ekip.std.services.capitalschedule.service.PortfolioCapitalScheduleService;
import com.linedata.ekip.std.services.contact.service.ContactService;
import com.linedata.ekip.std.services.deal.entity.Deal;
import com.linedata.ekip.std.services.deal.entity.DealThirdParty;
import com.linedata.ekip.std.services.deal.service.DealService;
import com.linedata.ekip.std.services.drawdown.entity.Drawdown;
import com.linedata.ekip.std.services.drawdown.service.DrawdownService;
import com.linedata.ekip.std.services.entity.factory.DealFactory;
import com.linedata.ekip.std.services.entity.factory.DealThirdPartyFactory;
import com.linedata.ekip.std.services.entity.factory.DrawdownFactory;
import com.linedata.ekip.std.services.entity.factory.FacilityFactory;
import com.linedata.ekip.std.services.facility.entity.Facility;
import com.linedata.ekip.std.services.facility.service.FacilityService;
import com.linedata.ekip.std.services.fee.service.FeeService;
import com.linedata.ekip.std.services.interest.service.InterestCycleService;
import com.linedata.ekip.std.services.lender.service.DealLenderService;
import com.linedata.ekip.std.services.lender.service.DrawdownLenderDetailService;
import com.linedata.ekip.std.services.lender.service.FacilityLenderService;
import com.linedata.ekip.std.services.remittanceinstructions.service.RemittanceInstructionsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeanFactoryService {

    private final String[] springConfig = {"spring/mono/sql/import.spring.xml"};
    private final ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
    public final DealService dealService = context.getBean(DealService.class);
    public final PartyService partyService = context.getBean(PartyService.class);

    public final AddressService addressService = context.getBean(AddressService.class);
    public final DealLenderService dealLenderService = context.getBean(DealLenderService.class);

    public final FacilityLenderService facilityLenderService = context.getBean(FacilityLenderService.class);

    public final FacilityService facilityService = context.getBean(FacilityService.class);

    public final FeeService feeService = context.getBean(FeeService.class);

    public final ContactService contactService = context.getBean(ContactService.class);

    public final DrawdownService drawdownService = context.getBean(DrawdownService.class);

    public final InterestCycleService interestCycleService = context.getBean(InterestCycleService.class);

    public final SyndLoanCapitalService syndLoanCapitalService = context.getBean(SyndLoanCapitalService.class);

    public final RemittanceInstructionsService remittanceInstructionsService = context.getBean(RemittanceInstructionsService.class);

    public final DrawdownLenderDetailService drawdownLenderDetailService = context.getBean(DrawdownLenderDetailService.class);

    public final PortfolioCapitalScheduleService portfolioCapitalScheduleService = context.getBean(PortfolioCapitalScheduleService.class);


    public Deal createDealBean() {
        DealFactory dealFactory = context.getBean(DealFactory.class);
        return dealFactory.buildBean();
    }

    public Facility createFacilityBean() {
        FacilityFactory facilityFactory = context.getBean(FacilityFactory.class);
        return facilityFactory.buildBean();
    }

    public DealThirdParty createDealThirdPartyBean() {
        DealThirdPartyFactory dealThirdPartyFactory = context.getBean(DealThirdPartyFactory.class);
        return dealThirdPartyFactory.buildBean();
    }

    public Drawdown createDrawdownBean() {
        DrawdownFactory drawdownFactory = context.getBean(DrawdownFactory.class);
        return drawdownFactory.buildBean();
    }
    public ActionContext initActionContext() {
        ActionContext actionContext = new ActionContext();
        actionContext.setActionId("EKIP");
        UserContext userContext = new UserContext();
        userContext.setLanguageCode("2");
        userContext.setCurrentProfile("PROFILE");
        userContext.setSessionId(12345678);
        userContext.setUserId("EKIP");
        userContext.setDatePattern("dd/MM/yyyy");
        userContext.setCurrentProfile("EKIP");
        List<String> profiles = new ArrayList<String>();
        profiles.add("EKIP");
        userContext.setProfiles(profiles);
        actionContext.setUserContext(userContext);
        return actionContext;
    }

}
