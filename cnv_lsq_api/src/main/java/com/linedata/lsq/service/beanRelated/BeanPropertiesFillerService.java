package com.linedata.lsq.service.beanRelated;

import com.linedata.ekip.party.management.address.entity.FrenchAddress;
import com.linedata.ekip.party.management.address.entity.impl.AddressImpl;
import com.linedata.ekip.party.management.party.entity.Party;
import com.linedata.ekip.party.management.party.entity.impl.PartyImpl;
import com.linedata.ekip.std.services.capitalschedule.entity.impl.PortfolioCapitalScheduleImpl;
import com.linedata.ekip.std.services.contact.entity.impl.ContactImpl;
import com.linedata.ekip.std.services.deal.entity.Deal;
import com.linedata.ekip.std.services.drawdown.entity.impl.DrawdownAdditionalMarginImpl;
import com.linedata.ekip.std.services.drawdown.entity.impl.DrawdownCalendarImpl;
import com.linedata.ekip.std.services.drawdown.entity.impl.DrawdownLenderPortfolioImpl;
import com.linedata.ekip.std.services.facility.entity.impl.*;
import com.linedata.ekip.std.services.fee.entity.impl.PortfolioFeeScheduleImpl;
import com.linedata.ekip.std.services.fee.entity.impl.ThirdPartyFeeScheduleDetImpl;
import com.linedata.ekip.std.services.interest.entity.impl.InterestCycleDetailsImpl;
import com.linedata.ekip.std.services.interest.entity.impl.PortfolioInterestScheduleImpl;
import com.linedata.ekip.std.services.lender.entity.impl.DealLenderImpl;
import com.linedata.ekip.std.services.lender.entity.impl.FacilityLenderPortfolioImpl;
import com.linedata.ekip.std.services.lender.entity.impl.FacilityLenderRateIndexImpl;
import com.linedata.ekip.std.services.remittanceinstructions.entity.impl.RemittanceInstructionsImpl;
import com.linedata.lsq.model.wrappers.dealRelated.DealLenderWrapper;
import com.linedata.lsq.model.wrappers.dealRelated.DealThirdPartyWrapper;
import com.linedata.lsq.model.wrappers.drawdownRelated.*;
import com.linedata.lsq.model.wrappers.facilityRelated.FacilityLenderWrapper;
import com.linedata.lsq.model.wrappers.facilityRelated.FacilityThirdpartyWrapper;
import com.linedata.lsq.model.wrappers.facilityRelated.FacilityWrapper;
import com.linedata.lsq.model.wrappers.feeRelated.FeeScheduleWrapper;
import com.linedata.lsq.model.wrappers.feeRelated.FeeWrapper;
import com.linedata.lsq.model.wrappers.feeRelated.ThirdPartyFeeScheduleWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeanPropertiesFillerService {

    @Autowired
    private BeanListPropertiesFinderService beanListPropertiesFinderService;

    public void dealPropertiesFiller(Deal deal) {

        List<Thread> dealPropertiesFillerThreads = new ArrayList<>(Arrays.asList(
                new Thread(() -> deal.setFeeList(beanListPropertiesFinderService.getDealFeesByDeal(deal))),
                new Thread(() -> deal.setDealLenderList(beanListPropertiesFinderService.getDealLendersByDeal(deal))),
                new Thread(() -> deal.setRatioList(beanListPropertiesFinderService.getDealRatiosByDeal(deal))),
                new Thread(() -> deal.setCurrencyList(beanListPropertiesFinderService.getDealCurrenciesByDeal(deal))),
                new Thread(() -> deal.setCalendarList(beanListPropertiesFinderService.getDealCalendarsByDeal(deal))),
                new Thread(() -> deal.setThirdPartyList(beanListPropertiesFinderService.getDealThirdPartiesByDeal(deal))),
                new Thread(() -> deal.setRateIndexList(beanListPropertiesFinderService.getDealRateIndexesByDeal(deal)))
        ));

        dealPropertiesFillerThreads.forEach(
                Thread::start);
        dealPropertiesFillerThreads.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

////////////////////////////////////////////////////////////////////////////////////////

    public void dealLenderPropertiesFiller(DealLenderWrapper dealLenderWrapper, String statusCode) {

        List<Thread> dealLenderPropertiesFillerThreads = new ArrayList<>(Arrays.asList(
                new Thread(() -> dealLenderWrapper.setContactList(beanListPropertiesFinderService.getDealLenderContactsByDealLender(dealLenderWrapper.getDealLender(), statusCode).stream().map(contact -> ((ContactImpl) contact)).collect(Collectors.toList()))),
                new Thread(() -> dealLenderWrapper.setRemittanceInstructionsList(beanListPropertiesFinderService.getDealLenderRemittanceInstructionsByDealLender(dealLenderWrapper.getDealLender(), statusCode).stream().map(remittanceInstructions -> ((RemittanceInstructionsImpl) remittanceInstructions)).collect(Collectors.toList()))),
                new Thread(() -> {
                    dealLenderWrapper.setParty(beanListPropertiesFinderService.getPartyByDealLender((dealLenderWrapper.getDealLender())));
                    dealLenderWrapper.setAddress(beanListPropertiesFinderService.getAddressByParty(dealLenderWrapper.getParty()));
                })
        ));
        dealLenderPropertiesFillerThreads.forEach(
                Thread::start);
        dealLenderPropertiesFillerThreads.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

/////////////////////////////////////////////////////////////////////r///////////////////

    public void dealThirdPartyPropertiesFiller(DealThirdPartyWrapper dealThirdPartyWrapper, String statusCode) {

        List<Thread> dealThirdPartyPropertiesFillerThreads = new ArrayList<>(Arrays.asList(
                new Thread(() -> dealThirdPartyWrapper.setContactList(beanListPropertiesFinderService.getDealThirdPartyContactsByDealThirdParty(dealThirdPartyWrapper.getDealThirdParty(), statusCode).stream().map(contact -> ((ContactImpl) contact)).collect(Collectors.toList()))),
                new Thread(() -> dealThirdPartyWrapper.setRemittanceInstructionsList(beanListPropertiesFinderService.getDealThirdPartyRemittanceInstructionsByDealThirdParty(dealThirdPartyWrapper.getDealThirdParty(), statusCode).stream().map(remittanceInstructions -> ((RemittanceInstructionsImpl) remittanceInstructions)).collect(Collectors.toList()))),
                new Thread(() -> {
                    dealThirdPartyWrapper.setParty(beanListPropertiesFinderService.getPartyByDealThirdparty((dealThirdPartyWrapper.getDealThirdParty())));
                    dealThirdPartyWrapper.setAddress(beanListPropertiesFinderService.getAddressByParty(dealThirdPartyWrapper.getParty()));
                })

        ));

        dealThirdPartyPropertiesFillerThreads.forEach(
                Thread::start);
        dealThirdPartyPropertiesFillerThreads.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

////////////////////////////////////////////////////////////////////////////////////////


    public void facilityPropertiesFiller(FacilityWrapper facilityWrapper) {

        List<Thread> facilityPropertiesFillerThreads = new ArrayList<>(Arrays.asList(
                new Thread(() -> facilityWrapper.setDrawdownList(beanListPropertiesFinderService.getDrawdownByFacility(facilityWrapper.getFacility()).stream().map(DrawdownWrapper::new).collect(Collectors.toList()))),
                new Thread(() -> facilityWrapper.setCalendarList(beanListPropertiesFinderService.getFacilityCalendarsByFacility(facilityWrapper.getFacility()).stream().map(facilityCalendar -> ((FacilityCalendarImpl) facilityCalendar)).collect(Collectors.toList()))),
                new Thread(() -> facilityWrapper.setCurrencyList(beanListPropertiesFinderService.getFacilityCurrenciesByFacility(facilityWrapper.getFacility()).stream().map(facilityCurrency -> ((FacilityCurrencyImpl) facilityCurrency)).collect(Collectors.toList()))),
                new Thread(() -> facilityWrapper.setRiskIndicatorList(beanListPropertiesFinderService.getFacilityRiskIndicatorsByFacility(facilityWrapper.getFacility()).stream().map(facilityIndicator -> ((FacilityIndicatorImpl) facilityIndicator)).collect(Collectors.toList()))),
                new Thread(() -> facilityWrapper.setAccountingIndicatorList(beanListPropertiesFinderService.getFacilityAccountingIndicatorsByFacility(facilityWrapper.getFacility()).stream().map(facilityIndicator -> ((FacilityIndicatorImpl) facilityIndicator)).collect(Collectors.toList()))),
                new Thread(() -> facilityWrapper.setFeeList(beanListPropertiesFinderService.getFacilityFeesByFacility(facilityWrapper.getFacility()).stream().map(FeeWrapper::new).collect(Collectors.toList()))),
                new Thread(() -> facilityWrapper.setCounterpartsList(beanListPropertiesFinderService.getFacilityCounterpartsByFacility(facilityWrapper.getFacility()).stream().map(FacilityThirdpartyWrapper::new).collect(Collectors.toList()))),
                new Thread(() -> facilityWrapper.setBorrowersList(beanListPropertiesFinderService.getFacilityThirdPartiesByFacility(facilityWrapper.getFacility()).stream().map(FacilityThirdpartyWrapper::new).collect(Collectors.toList()))),
                new Thread(() -> facilityWrapper.setRateIndexList(beanListPropertiesFinderService.getFacilityRateIndexesByFacility(facilityWrapper.getFacility()).stream().map(facilityRateIndex -> ((FacilityRateIndexImpl) facilityRateIndex)).collect(Collectors.toList()))),
                new Thread(() -> facilityWrapper.setFacilityLenderList(beanListPropertiesFinderService.getFacilityLendersByFacility(facilityWrapper.getFacility()).stream().map(FacilityLenderWrapper::new).collect(Collectors.toList()))),
                new Thread(() -> facilityWrapper.setMatrixDateList(beanListPropertiesFinderService.getFacilityMatrixDateByFacility(facilityWrapper.getFacility()).stream().map(facilityMatrixDate -> ((FacilityMatrixDateImpl) facilityMatrixDate)).collect(Collectors.toList()))),
                new Thread(() -> facilityWrapper.setMatrixAmountList(beanListPropertiesFinderService.getFacilityMatrixAmountByFacility(facilityWrapper.getFacility()).stream().map(facilityMatrixAmount -> ((FacilityMatrixAmountImpl) facilityMatrixAmount)).collect(Collectors.toList()))),
                new Thread(() -> facilityWrapper.setMatrixLineList(beanListPropertiesFinderService.getFacilityMatrixLineByFacility(facilityWrapper.getFacility(), null).stream().map(facilityMatrixLine -> ((FacilityMatrixLineImpl) facilityMatrixLine)).collect(Collectors.toList()))),
                new Thread(() -> facilityWrapper.setDrawdownList(beanListPropertiesFinderService.getDrawdownByFacility(facilityWrapper.getFacility()).stream().map(DrawdownWrapper::new).collect(Collectors.toList()))),
                new Thread(() -> facilityWrapper.setMatrixLineList(beanListPropertiesFinderService.getFacilityMatrixLineByFacility(facilityWrapper.getFacility(), null).stream().map(facilityMatrixLine -> ((FacilityMatrixLineImpl) facilityMatrixLine)).collect(Collectors.toList())))
        ));

        facilityPropertiesFillerThreads.forEach(
                Thread::start);
        facilityPropertiesFillerThreads.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

/////////////////////////////////////////////////////////////////////////

    public void facilityLenderPropertiesFiller(FacilityLenderWrapper facilityLenderWrapper, String statusCode) {

        List<Thread> facilityLenderPropertiesFillerThreads = new ArrayList<>(Arrays.asList(
                new Thread(() -> facilityLenderWrapper.setFacilityLenderRateIndexList(beanListPropertiesFinderService.getFacilityLenderRateIndexByFacility(facilityLenderWrapper.getFacilityLender()).stream().map(facilityLenderRateIndex -> ((FacilityLenderRateIndexImpl) facilityLenderRateIndex)).collect(Collectors.toList()))),
                new Thread(() -> facilityLenderWrapper.setFacilityLenderPortfolioList(beanListPropertiesFinderService.getFacilityLenderPortfolioByFacility(facilityLenderWrapper.getFacilityLender()).stream().map(facilityLenderPortfolio -> ((FacilityLenderPortfolioImpl) facilityLenderPortfolio)).collect(Collectors.toList()))),
                new Thread(() -> facilityLenderWrapper.setRemittanceInstructionsList(beanListPropertiesFinderService.getFacilityRemittanceInstructionsByFacilityLender(facilityLenderWrapper.getFacilityLender(), statusCode).stream().map(remittanceInstructions -> ((RemittanceInstructionsImpl) remittanceInstructions)).collect(Collectors.toList()))),
                new Thread(() -> facilityLenderWrapper.setContactList(beanListPropertiesFinderService.getFacilityLenderContactsByFacilityLender(facilityLenderWrapper.getFacilityLender(), statusCode).stream().map(contact -> ((ContactImpl) contact)).collect(Collectors.toList()))),
                new Thread(() -> {
                    facilityLenderWrapper.setParty(beanListPropertiesFinderService.getPartyByFacilityLender((facilityLenderWrapper.getFacilityLender())));
                    facilityLenderWrapper.setAddress(beanListPropertiesFinderService.getAddressByParty(facilityLenderWrapper.getParty()));
                })
        ));

        facilityLenderPropertiesFillerThreads.forEach(
                Thread::start);
        facilityLenderPropertiesFillerThreads.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

    ////////////////////////////////////////////
    public void facilityThirdPartyPropertiesFiller(FacilityThirdpartyWrapper facilityThirdpartyWrapper, String statusCode) {

        List<Thread> facilityThirdPartyPropertiesFillerThreads = new ArrayList<>(Arrays.asList(
                new Thread(() -> facilityThirdpartyWrapper.setContactList(beanListPropertiesFinderService.getFacilityThirdpartyContactsByFacilityThirdparty(facilityThirdpartyWrapper.getFacilityThirdparty(), statusCode).stream().map(contact -> ((ContactImpl) contact)).collect(Collectors.toList()))),
                new Thread(() -> facilityThirdpartyWrapper.setRemittanceInstructionsList(beanListPropertiesFinderService.getFacilityRemittanceInstructionsByFacilityThirdParty(facilityThirdpartyWrapper.getFacilityThirdparty(), statusCode).stream().map(remittanceInstructions -> ((RemittanceInstructionsImpl) remittanceInstructions)).collect(Collectors.toList()))),
                new Thread(() -> {
                    facilityThirdpartyWrapper.setParty(beanListPropertiesFinderService.getPartyByFacilityThirdparty((facilityThirdpartyWrapper.getFacilityThirdparty())));
                    facilityThirdpartyWrapper.setAddress(beanListPropertiesFinderService.getAddressByParty(facilityThirdpartyWrapper.getParty()));
                })
        ));

        facilityThirdPartyPropertiesFillerThreads.forEach(
                Thread::start);
        facilityThirdPartyPropertiesFillerThreads.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }
    ////////////////////////////////////////////

    public void drawdownPropertiesFiller(DrawdownWrapper drawdownWrapper) {

        List<Thread> drawdownPropertiesFillerThreads = new ArrayList<>(Arrays.asList(
                new Thread(() -> drawdownWrapper.setCalendarList(beanListPropertiesFinderService.getDrawdownCalendarsByDrawdown(drawdownWrapper.getDrawdown()).stream().map(drawdownCalendar -> ((DrawdownCalendarImpl) drawdownCalendar)).collect(Collectors.toList()))),
                new Thread(() -> drawdownWrapper.setAdditionalMarginList(beanListPropertiesFinderService.getDrawdownAdditionalMarginsByDrawdown(drawdownWrapper.getDrawdown()).stream().map(drawdownAdditionalMargin -> ((DrawdownAdditionalMarginImpl) drawdownAdditionalMargin)).collect(Collectors.toList()))),
                new Thread(() -> {
                    drawdownWrapper.setLenderList(beanListPropertiesFinderService.getDrawdownLendersByDrawdown(drawdownWrapper.getDrawdown()).stream().map(DrawdownLenderWrapper::new).collect(Collectors.toList()));

                    drawdownWrapper.setLenderPortfolioList(new ArrayList<>());
                    drawdownWrapper.getLenderList().forEach(drawdownLenderWrapper -> drawdownWrapper.getLenderPortfolioList().addAll(beanListPropertiesFinderService.getDrawdownLenderPortfolioByDrawdownLender(drawdownLenderWrapper.getDrawdownLender()).stream().map(drawdownLenderPortfolio -> ((DrawdownLenderPortfolioImpl) drawdownLenderPortfolio)).collect(Collectors.toList())));

                    drawdownWrapper.setLenderDetailList(new ArrayList<>());
//                    DOESNT WORK .<INIT> EXCEPTION → DRAWDOWNLENDERDETAIL DEFAULT CONSTRUCTOR ISSUE ????
//                    drawdownWrapper.getLenderList().forEach(drawdownLenderWrapper -> drawdownWrapper.getLenderDetailList().addAll(beanListPropertiesFinderService.getDrawdownLenderDetailByDrawdownLender(drawdownLenderWrapper.getDrawdownLender()).stream().map(drawdownLenderDetail -> ((DrawdownLenderDetailImpl) drawdownLenderDetail)).collect(Collectors.toList())));
                }),
                new Thread(() -> drawdownWrapper.setThirdpartyList(beanListPropertiesFinderService.getDrawdownThirdpartyByDrawdown(drawdownWrapper.getDrawdown()).stream().map(DrawdownThirdpartyWrapper::new).collect(Collectors.toList()))),
                new Thread(() -> drawdownWrapper.setFeeList(beanListPropertiesFinderService.getDrawdownFeesByDrawdown(drawdownWrapper.getDrawdown()).stream().map(FeeWrapper::new).collect(Collectors.toList()))),
                new Thread(() -> drawdownWrapper.setInterestCycleList(beanListPropertiesFinderService.getInterestCycleListByDrawdown(drawdownWrapper.getDrawdown()).stream().map(InterestCycleWrapper::new).collect(Collectors.toList()))),
                new Thread(() -> drawdownWrapper.setCapitalFinancialScheduleList(beanListPropertiesFinderService.getCapitalFinancialScheduleByDrawdown(drawdownWrapper.getDrawdown()).stream().map(CapitalFinancialScheduleWrapper::new).collect(Collectors.toList())))
        ));

        drawdownPropertiesFillerThreads.forEach(
                Thread::start);
        drawdownPropertiesFillerThreads.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }
    ////////////////////////////////////////////

    public void drawdownThirdPartyPropertiesFiller(DrawdownThirdpartyWrapper drawdownThirdpartyWrapper, String statusCode) {

        List<Thread> drawdownThirdPartyPropertiesFillerThreads = new ArrayList<>(Arrays.asList(
                new Thread(() -> drawdownThirdpartyWrapper.setContactList(beanListPropertiesFinderService.getDrawdownLenderContactsByDrawdownThirdParty(drawdownThirdpartyWrapper.getDrawdownThirdparty(), statusCode).stream().map(contact -> ((ContactImpl) contact)).collect(Collectors.toList()))),
                new Thread(() -> drawdownThirdpartyWrapper.setRemittanceInstructionsList(beanListPropertiesFinderService.getDrawdownLenderRemittanceInstructionsByDrawdownThirdpParty(drawdownThirdpartyWrapper.getDrawdownThirdparty(), statusCode).stream().map(remittanceInstructions -> ((RemittanceInstructionsImpl) remittanceInstructions)).collect(Collectors.toList()))),
                new Thread(() -> {
                    drawdownThirdpartyWrapper.setParty(beanListPropertiesFinderService.getPartyByDrawdownThirdparty((drawdownThirdpartyWrapper.getDrawdownThirdparty())));
                    drawdownThirdpartyWrapper.setAddress(beanListPropertiesFinderService.getAddressByParty(drawdownThirdpartyWrapper.getParty()));
                })

        ));

        drawdownThirdPartyPropertiesFillerThreads.forEach(
                Thread::start);
        drawdownThirdPartyPropertiesFillerThreads.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

    ////////////////////////////////////////////

    public void drawdownLenderPropertiesFiller(DrawdownLenderWrapper drawdownLenderWrapper, String statusCode) {

        List<Thread> drawdownLenderPropertiesFillerThreads = new ArrayList<>(Arrays.asList(
                new Thread(() -> drawdownLenderWrapper.setContactList(beanListPropertiesFinderService.getDrawdownLenderContactsByDrawdownLender(drawdownLenderWrapper.getDrawdownLender(), statusCode).stream().map(contact -> ((ContactImpl) contact)).collect(Collectors.toList()))),
                new Thread(() -> drawdownLenderWrapper.setRemittanceInstructionsList(beanListPropertiesFinderService.getDrawdownLenderRemittanceInstructionsByDrawdownLender(drawdownLenderWrapper.getDrawdownLender(), statusCode).stream().map(remittanceInstructions -> ((RemittanceInstructionsImpl) remittanceInstructions)).collect(Collectors.toList()))),
                new Thread(() -> {
                    drawdownLenderWrapper.setParty(beanListPropertiesFinderService.getPartyByDrawdownLender((drawdownLenderWrapper.getDrawdownLender())));
                    drawdownLenderWrapper.setAddress(beanListPropertiesFinderService.getAddressByParty(drawdownLenderWrapper.getParty()));
                })
        ));

        drawdownLenderPropertiesFillerThreads.forEach(
                Thread::start);
        drawdownLenderPropertiesFillerThreads.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

////////////////////////////////////////////////////////////////////////////////////////

    public void feePropertiesFiller(FeeWrapper feeWrapper) throws InterruptedException {

        Thread feePropertiesFillerThread = new Thread(() -> feeWrapper.setFeeScheduleList(beanListPropertiesFinderService.getFeeScheduleByFee(feeWrapper.getFee()).stream().map(FeeScheduleWrapper::new).collect(Collectors.toList())));
        feePropertiesFillerThread.start();
        feePropertiesFillerThread.join();
    }

////////////////////////////////////////////////////////////////////////////////////////

    public void feeSchedulePropertiesFiller(FeeScheduleWrapper feeScheduleWrapper) throws InterruptedException {

        Thread feeSchedulePropertiesFillerThread = new Thread(() -> feeScheduleWrapper.setThirdPartyFeeScheduleList(beanListPropertiesFinderService.getThirdPartyFeeScheduleByFeeSchedule(feeScheduleWrapper.getFeeSchedule()).stream().map(ThirdPartyFeeScheduleWrapper::new).collect(Collectors.toList())));
        feeSchedulePropertiesFillerThread.start();
        feeSchedulePropertiesFillerThread.join();
    }
////////////////////////////////////////////////////////////////////////////////////////

    public void thirdPartyFeeSchedulePropertiesFiller(ThirdPartyFeeScheduleWrapper thirdPartyFeeScheduleWrapper) {

        List<Thread> thirdPartyFeeSchedulePropertiesFillerThreads = new ArrayList<>(Arrays.asList(
                new Thread(() -> thirdPartyFeeScheduleWrapper.setPortfolioFeeScheduleList(beanListPropertiesFinderService.getPortfolioFeeScheduleListByThirdPartyFeeSchedule(thirdPartyFeeScheduleWrapper.getThirdPartyFeeSchedule()).stream().map(portfolioFeeSchedule -> ((PortfolioFeeScheduleImpl) portfolioFeeSchedule)).collect(Collectors.toList()))),
                new Thread(() -> thirdPartyFeeScheduleWrapper.setThirdPartyFeeScheduleDetList(beanListPropertiesFinderService.getThirdPartyFeeScheduleDetByThirdPartyFeeSchedule(thirdPartyFeeScheduleWrapper.getThirdPartyFeeSchedule()).stream().map(thirdPartyFeeScheduleDet -> ((ThirdPartyFeeScheduleDetImpl) thirdPartyFeeScheduleDet)).collect(Collectors.toList())))
        ));

        thirdPartyFeeSchedulePropertiesFillerThreads.forEach(
                Thread::start);
        thirdPartyFeeSchedulePropertiesFillerThreads.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }


////////////////////////////////////////////////////////////////////////////

    public void interestCyclePropertiesFiller(InterestCycleWrapper interestCycleWrapper) {

        List<Thread> interestCyclePropertiesFillerThreads = new ArrayList<>(Arrays.asList(
                new Thread(() -> interestCycleWrapper.setThirdpartyInterestCycleList(beanListPropertiesFinderService.getThirdPartyInterestCycleListByInterestCycle(interestCycleWrapper.getInterestCycle()).stream().map(ThirdPartyInterestCycleWrapper::new).collect(Collectors.toList()))),
                new Thread(() -> interestCycleWrapper.setInterestCycleDetailsList(beanListPropertiesFinderService.getInterestCycleDetailsListByInterestCycle(interestCycleWrapper.getInterestCycle()).stream().map(interestCycleDetails -> ((InterestCycleDetailsImpl) interestCycleDetails)).collect(Collectors.toList())))
        ));

        interestCyclePropertiesFillerThreads.forEach(
                Thread::start);
        interestCyclePropertiesFillerThreads.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

////////////////////////////////////////////////////////////////////////////

    public void capitalFinancialSchedulePropertiesFiller(CapitalFinancialScheduleWrapper capitalFinancialScheduleWrapper) {

        List<Thread> capitalFinancialSchedulePropertiesFillerThreads = new ArrayList<>(Arrays.asList(
                new Thread(() -> capitalFinancialScheduleWrapper.setThirdpartyCapitalScheduleList(beanListPropertiesFinderService.getThirdpartyCapitalScheduleListByCapitalFinancialSchedule(capitalFinancialScheduleWrapper.getCapitalFinancialSchedule()).stream().map(ThirdpartyCapitalScheduleWrapper::new).collect(Collectors.toList())))
        ));

        capitalFinancialSchedulePropertiesFillerThreads.forEach(
                Thread::start);
        capitalFinancialSchedulePropertiesFillerThreads.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

    public void thirdpartyCapitalSchedulePropertiesFiller(ThirdpartyCapitalScheduleWrapper thirdpartyCapitalScheduleWrapper) {
        List<Thread> thirdpartyCapitalSchedulePropertiesFillerThreads = new ArrayList<>(Arrays.asList(
                new Thread(() -> thirdpartyCapitalScheduleWrapper.setPortfolioCapitalScheduleList(beanListPropertiesFinderService.getPortfolioCapitalScheduleListByCapitalFinancialSchedule(thirdpartyCapitalScheduleWrapper.getThirdpartyCapitalSchedule()).stream().map(portfolioCapitalSchedule -> ((PortfolioCapitalScheduleImpl) portfolioCapitalSchedule)).collect(Collectors.toList())))
//                    DOESNT WORK NULL POINTER EXCEPTION → FINDER DOESNT EXIST ????
//                new Thread(() -> thirdpartyCapitalScheduleWrapper.setThirdPartyScheduleDetailList(beanListPropertiesFinderService.getThirdpartyScheduleDetailListByCapitalFinancialSchedule(thirdpartyCapitalScheduleWrapper.getThirdpartyCapitalSchedule()).stream().map(thirdpartyScheduleDetail -> ((ThirdpartyScheduleDetailImpl) thirdpartyScheduleDetail)).collect(Collectors.toList())))
        ));

        thirdpartyCapitalSchedulePropertiesFillerThreads.forEach(
                Thread::start);
        thirdpartyCapitalSchedulePropertiesFillerThreads.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

    public void thirdPartyInterestCyclePropertiesFiller(InterestCycleWrapper interestCycleWrapper) {

        List<Thread> interestCyclePropertiesFillerThreads = new ArrayList<>(Arrays.asList(
                new Thread(() -> interestCycleWrapper.getThirdpartyInterestCycleList().stream().forEach(thirdPartyInterestCycle -> thirdPartyInterestCycle.setPortfolioInterestSchedule(beanListPropertiesFinderService.getPortfolioInterestScheduleListByInterestCycle(interestCycleWrapper.getInterestCycle()).stream().map(portfolioInterestSchedule -> ((PortfolioInterestScheduleImpl) portfolioInterestSchedule)).collect(Collectors.toList()))))
        ));

        interestCyclePropertiesFillerThreads.forEach(
                Thread::start);
        interestCyclePropertiesFillerThreads.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }
}
////////////////////////////////////////////////////////////////////////////
