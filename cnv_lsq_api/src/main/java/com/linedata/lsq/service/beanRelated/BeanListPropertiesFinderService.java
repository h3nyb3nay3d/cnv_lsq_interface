package com.linedata.lsq.service.beanRelated;

import com.linedata.ekip.party.management.address.entity.Address;
import com.linedata.ekip.party.management.party.entity.Party;
import com.linedata.ekip.std.services.capital.entity.CapitalFinancialSchedule;
import com.linedata.ekip.std.services.capital.entity.ThirdpartyCapitalSchedule;
import com.linedata.ekip.std.services.capital.entity.ThirdpartyScheduleDetail;
import com.linedata.ekip.std.services.capitalschedule.entity.PortfolioCapitalSchedule;
import com.linedata.ekip.std.services.contact.entity.Contact;
import com.linedata.ekip.std.services.deal.entity.*;
import com.linedata.ekip.std.services.drawdown.entity.*;
import com.linedata.ekip.std.services.entity.party.management.party.PartyReference;
import com.linedata.ekip.std.services.entity.party.management.party.impl.PartyReferenceImpl;
import com.linedata.ekip.std.services.facility.entity.*;
import com.linedata.ekip.std.services.fee.entity.*;
import com.linedata.ekip.std.services.interest.entity.InterestCycle;
import com.linedata.ekip.std.services.interest.entity.InterestCycleDetails;
import com.linedata.ekip.std.services.interest.entity.PortfolioInterestSchedule;
import com.linedata.ekip.std.services.interest.entity.ThirdPartyInterestCycle;
import com.linedata.ekip.std.services.lender.entity.DealLender;
import com.linedata.ekip.std.services.lender.entity.FacilityLender;
import com.linedata.ekip.std.services.lender.entity.FacilityLenderPortfolio;
import com.linedata.ekip.std.services.lender.entity.FacilityLenderRateIndex;
import com.linedata.ekip.std.services.remittanceinstructions.entity.RemittanceInstructions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeanListPropertiesFinderService {

    @Autowired
    private BeanFactoryService beanFactoryService;

//BY DEAL//
    public List<Fee> getDealFeesByDeal(Deal deal) {
        return beanFactoryService.dealService.findDealFees(beanFactoryService.initActionContext(), deal);
    }

    public List<DealLender> getDealLendersByDeal(Deal deal) {
        return beanFactoryService.dealLenderService.findPrimaryDealLender(beanFactoryService.initActionContext(), deal);
    }

    public List<DealRateIndex> getDealRateIndexesByDeal(Deal deal) {
        return beanFactoryService.dealService.findDealRateIndex(beanFactoryService.initActionContext(), deal);
    }

    public List<DealRatio> getDealRatiosByDeal(Deal deal) {
        return beanFactoryService.dealService.findDealRatio(beanFactoryService.initActionContext(), deal);
    }

    public List<DealCurrency> getDealCurrenciesByDeal(Deal deal) {
        return beanFactoryService.dealService.findDealCurrencies(beanFactoryService.initActionContext(), deal);
    }

    public List<DealCalendar> getDealCalendarsByDeal(Deal deal) {
        return beanFactoryService.dealService.findDealCalendars(beanFactoryService.initActionContext(), deal);
    }

    public List<DealThirdParty> getDealThirdPartiesByDeal(Deal deal) {
        return beanFactoryService.dealService.findDealBorrowersDetails(beanFactoryService.initActionContext(), deal);
    }

    public List<Facility> getDealFacilitiesByDeal(Deal deal) {
        return beanFactoryService.dealService.findDealFacilities(beanFactoryService.initActionContext(), deal);
    }

//BY DEAL THIRDPARTY//

    public List<RemittanceInstructions> getDealThirdPartyRemittanceInstructionsByDealThirdParty(DealThirdParty dealThirdParty, String statusCode) {
        return beanFactoryService.remittanceInstructionsService.findRemittanceInstructionsByManagementLevel(beanFactoryService.initActionContext(), "Dlen", dealThirdParty.getThirdpartyId(), statusCode);
    }

    public List<Contact> getDealThirdPartyContactsByDealThirdParty(DealThirdParty dealThirdParty, String statusCode) {
        return beanFactoryService.contactService.findContactByManagementLevel(beanFactoryService.initActionContext(), "Dlen", dealThirdParty.getThirdpartyId(), statusCode);
    }

//BY DEAL LENDER//
    public List<RemittanceInstructions> getDealLenderRemittanceInstructionsByDealLender(DealLender dealLender, String statusCode) {
        return beanFactoryService.remittanceInstructionsService.findRemittanceInstructionsByManagementLevel(beanFactoryService.initActionContext(), "Dlen", dealLender.getLenderId(), statusCode);
    }

    public List<Contact> getDealLenderContactsByDealLender(DealLender dealLender, String statusCode) {
        return beanFactoryService.contactService.findContactByManagementLevel(beanFactoryService.initActionContext(), "Dlen", dealLender.getLenderId(), statusCode);
    }

//BY FACILITY//
    public List<Fee> getFacilityFeesByFacility(Facility facility) {
        return beanFactoryService.facilityService.findFacilityFees(beanFactoryService.initActionContext(), facility);
    }

    public List<FacilityRateIndex> getFacilityRateIndexesByFacility(Facility facility) {
        return beanFactoryService.facilityService.findFacilityRateIndexes(beanFactoryService.initActionContext(), facility);
    }

    public List<FacilityCurrency> getFacilityCurrenciesByFacility(Facility facility) {
        return beanFactoryService.facilityService.findFacilityCurrencies(beanFactoryService.initActionContext(), facility);
    }

    public List<FacilityIndicator> getFacilityAccountingIndicatorsByFacility(Facility facility) {
        return beanFactoryService.facilityService.findFacilityAccountingIndicators(beanFactoryService.initActionContext(), facility);
    }

    public List<FacilityIndicator> getFacilityRiskIndicatorsByFacility(Facility facility) {
        return beanFactoryService.facilityService.findFacilityRiskIndicators(beanFactoryService.initActionContext(), facility);
    }

    public List<FacilityCalendar> getFacilityCalendarsByFacility(Facility facility) {
        return beanFactoryService.facilityService.findFacilityCalendars(beanFactoryService.initActionContext(), facility);
    }

    public List<FacilityThirdparty> getFacilityThirdPartiesByFacility(Facility facility) {
        return beanFactoryService.facilityService.findFacilityBorrowers(beanFactoryService.initActionContext(), facility);
    }

    public List<FacilityThirdparty> getFacilityCounterpartsByFacility(Facility facility) {
        return beanFactoryService.facilityService.findFacilityCounterparts(beanFactoryService.initActionContext(), facility);
    }

    public List<FacilityLender> getFacilityLendersByFacility(Facility facility) {
        return beanFactoryService.facilityLenderService.findFacilityLenderListByFacilityId(beanFactoryService.initActionContext(), facility);
    }

    public List<FacilityMatrixAmount> getFacilityMatrixAmountByFacility(Facility facility) {
        return beanFactoryService.facilityService.findFacilityMatrixAmounts(beanFactoryService.initActionContext(), facility);
    }

    public List<FacilityMatrixDate> getFacilityMatrixDateByFacility(Facility facility) {
        return beanFactoryService.facilityService.findFacilityMatrixDates(beanFactoryService.initActionContext(), facility);
    }

    public List<FacilityMatrixLine> getFacilityMatrixLineByFacility(Facility facility, String matrixTypeCode) {
        return beanFactoryService.facilityService.findFacilityMatrixLines(beanFactoryService.initActionContext(), facility, matrixTypeCode);
    }

    public List<Drawdown> getDrawdownByFacility(Facility facility) {
        return beanFactoryService.drawdownService.findDrawdownListByFacilityAndStatusCode(beanFactoryService.initActionContext(), facility);
    }

//BY DRAWDOWN LENDER//
    public List<RemittanceInstructions> getDrawdownLenderRemittanceInstructionsByDrawdownLender(DrawdownLender drawdownLender, String statusCode) {
        return beanFactoryService.remittanceInstructionsService.findRemittanceInstructionsByManagementLevel(beanFactoryService.initActionContext(), "Ilen", drawdownLender.getLenderId(), statusCode);
    }

    public List<Contact> getDrawdownLenderContactsByDrawdownLender(DrawdownLender drawdownLender, String statusCode) {
        return beanFactoryService.contactService.findContactByManagementLevel(beanFactoryService.initActionContext(), "Ilen", drawdownLender.getLenderId(), statusCode);
    }

    public List<DrawdownLenderPortfolio> getDrawdownLenderPortfolioByDrawdownLender(DrawdownLender drawdownLender) {
        return beanFactoryService.drawdownService.findDrawdownLenderPortfoliosByStatusCode(beanFactoryService.initActionContext(), drawdownLender);
    }

    public List<DrawdownLenderDetail> getDrawdownLenderDetailByDrawdownLender(DrawdownLender drawdownLender) {
        return beanFactoryService.drawdownLenderDetailService.findByDrawdownLender(beanFactoryService.initActionContext(), drawdownLender);
    }

//BY DRAWDOWN THIRDPARTY//
    public List<RemittanceInstructions> getDrawdownLenderRemittanceInstructionsByDrawdownThirdpParty(DrawdownThirdparty drawdownThirdparty, String statusCode) {
        return beanFactoryService.remittanceInstructionsService.findRemittanceInstructionsByManagementLevel(beanFactoryService.initActionContext(), "Ilen", drawdownThirdparty.getThirdpartyId(), statusCode);
    }

    public List<Contact> getDrawdownLenderContactsByDrawdownThirdParty(DrawdownThirdparty drawdownThirdparty, String statusCode) {
        return beanFactoryService.contactService.findContactByManagementLevel(beanFactoryService.initActionContext(), "Ilen", drawdownThirdparty.getThirdpartyId(), statusCode);
    }


//BY DRAWDOWN//

    public List<DrawdownCalendar> getDrawdownCalendarsByDrawdown(Drawdown drawdown) {
        return beanFactoryService.drawdownService.findDrawdownCalendars(beanFactoryService.initActionContext(), drawdown);
    }

    public List<DrawdownAdditionalMargin> getDrawdownAdditionalMarginsByDrawdown(Drawdown drawdown) {
        return beanFactoryService.drawdownService.findDrawdownAdditionalMargins(beanFactoryService.initActionContext(), drawdown);
    }

    public List<DrawdownLender> getDrawdownLendersByDrawdown(Drawdown drawdown) {
        return beanFactoryService.drawdownService.findDrawdownLenders(beanFactoryService.initActionContext(), drawdown);
    }

    public List<DrawdownThirdparty> getDrawdownThirdpartyByDrawdown(Drawdown drawdown) {
        return beanFactoryService.drawdownService.findDrawdownThirdparties(beanFactoryService.initActionContext(), drawdown);
    }

    public List<InterestCycle> getInterestCycleListByDrawdown(Drawdown drawdown) {
        List<InterestCycle> interestCycles = beanFactoryService.interestCycleService.findInterestCycleListByDrawdown(beanFactoryService.initActionContext(), drawdown);
        interestCycles.stream().forEach(interestCycle -> {
            interestCycle.setThirdpartyInterestCycleList(null);
            interestCycle.setInterestCycleDetails(null);
        });
        return interestCycles;
    }

    public List<CapitalFinancialSchedule> getCapitalFinancialScheduleByDrawdown(Drawdown drawdown) {
        return beanFactoryService.syndLoanCapitalService.findByDrawdownReference(beanFactoryService.initActionContext(), drawdown);
    }

    public List<Fee> getDrawdownFeesByDrawdown(Drawdown drawdown) {
        return beanFactoryService.drawdownService.findFees(beanFactoryService.initActionContext(), drawdown);
    }

//BY FACILITY LENDER//
    public List<Contact> getFacilityLenderContactsByFacilityLender(FacilityLender facilityLender, String statusCode) {
        return beanFactoryService.contactService.findContactByManagementLevel(beanFactoryService.initActionContext(), "Flen", facilityLender.getLenderId(), statusCode);
    }

    public List<FacilityLenderRateIndex> getFacilityLenderRateIndexByFacility(FacilityLender facilityLender) {
        return beanFactoryService.facilityLenderService.findFacilityLenderRateIndexes(beanFactoryService.initActionContext(), facilityLender);
    }

    public List<FacilityLenderPortfolio> getFacilityLenderPortfolioByFacility(FacilityLender facilityLender) {
        return beanFactoryService.facilityLenderService.findFacilityLenderPortfolios(beanFactoryService.initActionContext(), facilityLender, facilityLender.getStatusCode());
    }

    public List<RemittanceInstructions> getFacilityRemittanceInstructionsByFacilityLender(FacilityLender facilityLender, String statusCode) {
        return beanFactoryService.remittanceInstructionsService.findRemittanceInstructionsByManagementLevel(beanFactoryService.initActionContext(), "Flen", facilityLender.getLenderId(), statusCode);
    }

//BY FACILITY THIRDPARTY//
    public List<Contact> getFacilityThirdpartyContactsByFacilityThirdparty(FacilityThirdparty facilityThirdparty, String statusCode) {
        return beanFactoryService.contactService.findContactByManagementLevel(beanFactoryService.initActionContext(), "Flen", facilityThirdparty.getThirdpartyId(), statusCode);
    }

    public List<RemittanceInstructions> getFacilityRemittanceInstructionsByFacilityThirdParty(FacilityThirdparty facilityThirdparty, String statusCode) {
        return beanFactoryService.remittanceInstructionsService.findRemittanceInstructionsByManagementLevel(beanFactoryService.initActionContext(), "Flen", facilityThirdparty.getThirdpartyId(), statusCode);
    }

//BY FEE//
    public List<FeeSchedule> getFeeScheduleByFee(Fee fee) {
        return beanFactoryService.feeService.findFeeScheduleList(beanFactoryService.initActionContext(), fee);
    }

//BY FEE SCHEDULE//
    public List<ThirdPartyFeeSchedule> getThirdPartyFeeScheduleByFeeSchedule(FeeSchedule feeSchedule) {
        return beanFactoryService.feeService.findThirdPartyFeeScheduleList(beanFactoryService.initActionContext(), feeSchedule);
    }

    public List<PortfolioFeeSchedule> getPortfolioFeeScheduleListByFeeSchedule(FeeSchedule feeSchedule) {
        return beanFactoryService.feeService.findFeeSchedulePortfolios(beanFactoryService.initActionContext(), feeSchedule);
    }

//BY THIRDPARTY FEE SCHEDULE//
    public List<PortfolioFeeSchedule> getPortfolioFeeScheduleListByThirdPartyFeeSchedule(ThirdPartyFeeSchedule thirdPartyFeeSchedule) {
        return beanFactoryService.feeService.findPortfolioFeeScheduleList(beanFactoryService.initActionContext(), thirdPartyFeeSchedule);
    }

    public List<ThirdPartyFeeScheduleDet> getThirdPartyFeeScheduleDetByThirdPartyFeeSchedule(ThirdPartyFeeSchedule thirdPartyFeeSchedule) {
        return beanFactoryService.feeService.findThirdPartyFeeScheduleDetList(beanFactoryService.initActionContext(), thirdPartyFeeSchedule);
    }

//BY INTEREST CYCLE//
    public List<ThirdPartyInterestCycle> getThirdPartyInterestCycleListByInterestCycle(InterestCycle interestCycle) {
        return beanFactoryService.interestCycleService.findInterestCycleThirdpartyInterestCycles(beanFactoryService.initActionContext(), interestCycle);
    }

    public List<InterestCycleDetails> getInterestCycleDetailsListByInterestCycle(InterestCycle interestCycle) {
        return beanFactoryService.interestCycleService.findInterestCycleDetailsList(beanFactoryService.initActionContext(), interestCycle);
    }

    public List<PortfolioInterestSchedule> getPortfolioInterestScheduleListByInterestCycle(InterestCycle interestCycle) {
        return beanFactoryService.interestCycleService.findInterestCyclePortfolioList(beanFactoryService.initActionContext(), interestCycle);
    }

//BY CAPITAL FINANCIAL SCHEDULE//
    public List<ThirdpartyCapitalSchedule> getThirdpartyCapitalScheduleListByCapitalFinancialSchedule(CapitalFinancialSchedule capitalFinancialSchedule) {
        return beanFactoryService.syndLoanCapitalService.findThirdpartyRepartitions(beanFactoryService.initActionContext(), capitalFinancialSchedule);
    }

//BY THIRDPARTY CAPITAL FINANCIAL SCHEDULE//
    public List<PortfolioCapitalSchedule> getPortfolioCapitalScheduleListByCapitalFinancialSchedule(ThirdpartyCapitalSchedule thirdpartyCapitalSchedule) {
        return beanFactoryService.portfolioCapitalScheduleService.findByThirdpartyScheduleReference(beanFactoryService.initActionContext(), thirdpartyCapitalSchedule);
    }

    public List<ThirdpartyScheduleDetail> getThirdpartyScheduleDetailListByCapitalFinancialSchedule(ThirdpartyCapitalSchedule thirdpartyCapitalSchedule) {
//        CANT FIND FINDER IN ORIGINATION SERVICES
        return null;
    }

//BY PARTY REFERENCE//
    public Party getPartyByDealLender(DealLender dealLender){
        PartyReference party = new PartyReferenceImpl();
        party.setPartyId(dealLender.getLenderId());
        return beanFactoryService.partyService.findPartyBasicInformation(beanFactoryService.initActionContext(), party);
    }
    public Party getPartyByDealThirdparty(DealThirdParty dealThirdParty){
        PartyReference party = new PartyReferenceImpl();
        party.setPartyId(dealThirdParty.getThirdpartyId());
        return beanFactoryService.partyService.findPartyBasicInformation(beanFactoryService.initActionContext(), party);
    }

    public Party getPartyByDrawdownLender(DrawdownLender drawdownLender){
        PartyReference party = new PartyReferenceImpl();
        party.setPartyId(drawdownLender.getLenderId());
        return beanFactoryService.partyService.findPartyBasicInformation(beanFactoryService.initActionContext(), party);
    }
    public Party getPartyByDrawdownThirdparty(DrawdownThirdparty drawdownThirdparty){
        PartyReference party = new PartyReferenceImpl();
        party.setPartyId(drawdownThirdparty.getThirdpartyId());
        return beanFactoryService.partyService.findPartyBasicInformation(beanFactoryService.initActionContext(), party);
    }

    public Party getPartyByFacilityLender(FacilityLender facilityLender){
        PartyReference party = new PartyReferenceImpl();
        party.setPartyId(facilityLender.getLenderId());
        return beanFactoryService.partyService.findPartyBasicInformation(beanFactoryService.initActionContext(), party);
    }
    public Party getPartyByFacilityThirdparty(FacilityThirdparty facilityThirdparty){
        PartyReference party = new PartyReferenceImpl();
        party.setPartyId(facilityThirdparty.getThirdpartyId());
        return beanFactoryService.partyService.findPartyBasicInformation(beanFactoryService.initActionContext(), party);
    }

    public Address getAddressByParty(Party party){
        return beanFactoryService.addressService.getMainAddress(beanFactoryService.initActionContext(), party);
    }
}
