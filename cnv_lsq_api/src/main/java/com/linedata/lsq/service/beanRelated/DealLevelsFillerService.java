package com.linedata.lsq.service.beanRelated;

import com.linedata.ekip.std.services.deal.entity.Deal;
import com.linedata.lsq.model.wrappers.dealRelated.DealWrapper;
import com.linedata.lsq.model.wrappers.facilityRelated.FacilityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DealLevelsFillerService {

    @Autowired
    private BeanPropertiesFillerService beanPropertiesFillerService;

    @Autowired
    private BeanListPropertiesFinderService beanListPropertiesFinderService;

    public DealWrapper deal1LevelFiller(Deal deal) {
        beanPropertiesFillerService.dealPropertiesFiller(deal);
        DealWrapper dealWrapper = new DealWrapper(deal);
        dealWrapper.setFacilityList(beanListPropertiesFinderService.getDealFacilitiesByDeal(deal).stream().map(FacilityWrapper::new).collect(Collectors.toList()));
        return dealWrapper;
    }

    public DealWrapper deal2LevelFiller(Deal deal) {
        DealWrapper dealWrapper = deal1LevelFiller(deal);
        List<Thread> deal2LevelFillerThreadList = new ArrayList<>();

        dealWrapper.getDealLenderList().forEach(
                dealLenderWrapper -> deal2LevelFillerThreadList.add(new Thread(() -> beanPropertiesFillerService.dealLenderPropertiesFiller(dealLenderWrapper, dealLenderWrapper.getStatusCode())))
        );

        dealWrapper.getThirdPartyList().forEach(
                dealThirdPartyWrapper -> deal2LevelFillerThreadList.add(new Thread(() -> beanPropertiesFillerService.dealThirdPartyPropertiesFiller(dealThirdPartyWrapper, dealThirdPartyWrapper.getRoleCode())))
        );

        dealWrapper.getFacilityList().forEach(
                facilityWrapper -> deal2LevelFillerThreadList.add(new Thread(() -> beanPropertiesFillerService.facilityPropertiesFiller(facilityWrapper)))
        );

        dealWrapper.getFeeList().forEach(
                feeWrapper -> deal2LevelFillerThreadList.add(new Thread(() -> {
                    try {
                        beanPropertiesFillerService.feePropertiesFiller(feeWrapper);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }))
        );

        deal2LevelFillerThreadList.forEach(Thread::start);
        deal2LevelFillerThreadList.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        return dealWrapper;
    }

    public DealWrapper deal3LevelFiller(Deal deal) {
        DealWrapper dealWrapper = deal2LevelFiller(deal);
        List<Thread> deal3LevelFillerThreadList = new ArrayList<>();

        dealWrapper.getFacilityList().forEach(
                facilityWrapper -> {
                    facilityWrapper.getFacilityLenderList().forEach(
                            facilityLenderWrapper -> deal3LevelFillerThreadList.add(new Thread(() -> beanPropertiesFillerService.facilityLenderPropertiesFiller(facilityLenderWrapper, facilityLenderWrapper.getStatusCode())))
                    );

                    facilityWrapper.getBorrowersList().forEach(
                            facilityThirdpartyWrapper -> deal3LevelFillerThreadList.add(new Thread(() -> beanPropertiesFillerService.facilityThirdPartyPropertiesFiller(facilityThirdpartyWrapper, facilityThirdpartyWrapper.getStatusCode())))
                    );

                    facilityWrapper.getCounterpartsList().forEach(
                            facilityThirdpartyWrapper -> deal3LevelFillerThreadList.add(new Thread(() -> beanPropertiesFillerService.facilityThirdPartyPropertiesFiller(facilityThirdpartyWrapper, facilityThirdpartyWrapper.getStatusCode())))
                    );

                    facilityWrapper.getDrawdownList().forEach(
                            drawdownWrapper -> deal3LevelFillerThreadList.add(new Thread(() -> beanPropertiesFillerService.drawdownPropertiesFiller(drawdownWrapper)))
                    );

                    facilityWrapper.getFeeList().forEach(
                            feeWrapper -> deal3LevelFillerThreadList.add(new Thread(() -> {
                                try {
                                    beanPropertiesFillerService.feePropertiesFiller(feeWrapper);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }))
                    );
                }
        );

        dealWrapper.getFeeList().forEach(
                feeWrapper -> feeWrapper.getFeeScheduleList().forEach(
                        feeScheduleWrapper -> deal3LevelFillerThreadList.add(new Thread(() -> {
                            try {
                                beanPropertiesFillerService.feeSchedulePropertiesFiller(feeScheduleWrapper);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }))
                )
        );

        deal3LevelFillerThreadList.forEach(
                Thread::start);
        deal3LevelFillerThreadList.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        return dealWrapper;
    }

    public DealWrapper deal4LevelFiller(Deal deal) {
        DealWrapper dealWrapper = deal3LevelFiller(deal);
        List<Thread> deal4LevelFillerThreadList = new ArrayList<>();

        dealWrapper.getFacilityList().forEach(
                facilityWrapper -> {
                    facilityWrapper.getDrawdownList().forEach(
                            drawdownWrapper -> {
                                drawdownWrapper.getLenderList().forEach(
                                        drawdownLenderWrapper -> deal4LevelFillerThreadList.add(new Thread(() -> beanPropertiesFillerService.drawdownLenderPropertiesFiller(drawdownLenderWrapper, drawdownLenderWrapper.getStatusCode())))
                                );

                                drawdownWrapper.getThirdpartyList().forEach(
                                        drawdownThirdpartyWrapper -> deal4LevelFillerThreadList.add(new Thread(() -> beanPropertiesFillerService.drawdownThirdPartyPropertiesFiller(drawdownThirdpartyWrapper, drawdownThirdpartyWrapper.getStatusCode())))
                                );

                                drawdownWrapper.getFeeList().forEach(feeWrapper -> deal4LevelFillerThreadList.add(new Thread(() -> {
                                    try {
                                        beanPropertiesFillerService.feePropertiesFiller(feeWrapper);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                })));

                                drawdownWrapper.getInterestCycleList().forEach(interestCycleWrapper -> deal4LevelFillerThreadList.add(new Thread(() -> beanPropertiesFillerService.interestCyclePropertiesFiller(interestCycleWrapper))));
                                drawdownWrapper.getCapitalFinancialScheduleList().forEach(capitalFinancialScheduleWrapper -> deal4LevelFillerThreadList.add(new Thread(() -> beanPropertiesFillerService.capitalFinancialSchedulePropertiesFiller(capitalFinancialScheduleWrapper))));
                                drawdownWrapper.getFeeList().forEach(feeWrapper -> deal4LevelFillerThreadList.add(new Thread(() -> {
                                    try {
                                        beanPropertiesFillerService.feePropertiesFiller(feeWrapper);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                })));
                            });

                    facilityWrapper.getFeeList().forEach(
                            feeWrapper -> feeWrapper.getFeeScheduleList().forEach(feeScheduleWrapper -> deal4LevelFillerThreadList.add(new Thread(() -> {
                                try {
                                    beanPropertiesFillerService.feeSchedulePropertiesFiller(feeScheduleWrapper);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }))));
                }
        );

        dealWrapper.getFeeList().forEach(
                feeWrapper -> feeWrapper.getFeeScheduleList().forEach(
                        feeScheduleWrapper -> feeScheduleWrapper.getThirdPartyFeeScheduleList().forEach(thirdPartyFeeScheduleWrapper -> deal4LevelFillerThreadList.add(new Thread(() -> beanPropertiesFillerService.thirdPartyFeeSchedulePropertiesFiller(thirdPartyFeeScheduleWrapper))))));


        deal4LevelFillerThreadList.forEach(
                Thread::start);
        deal4LevelFillerThreadList.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        return dealWrapper;
    }


    public DealWrapper deal5LevelFiller(Deal deal) {

        DealWrapper dealWrapper = deal4LevelFiller(deal);
        List<Thread> deal5LevelFillerThreadList = new ArrayList<>();

        dealWrapper.getFacilityList().forEach(
                facilityWrapper -> {
                    facilityWrapper.getFeeList().forEach(
                            feeDetailsMapper -> feeDetailsMapper.getFeeScheduleList().forEach(
                                    feeScheduleWrapper -> feeScheduleWrapper.getThirdPartyFeeScheduleList().forEach(
                                            thirdPartyFeeScheduleWrapper -> deal5LevelFillerThreadList.add(new Thread(() -> beanPropertiesFillerService.thirdPartyFeeSchedulePropertiesFiller(thirdPartyFeeScheduleWrapper)))
                                    )
                            )
                    );

                    facilityWrapper.getDrawdownList().forEach(
                            drawdownWrapper -> {
                                drawdownWrapper.getFeeList().forEach(
                                        feeWrapper -> feeWrapper.getFeeScheduleList().forEach(feeScheduleWrapper -> deal5LevelFillerThreadList.add(new Thread(() -> {
                                                    try {
                                                        beanPropertiesFillerService.feeSchedulePropertiesFiller(feeScheduleWrapper);
                                                    } catch (InterruptedException e) {
                                                        e.printStackTrace();
                                                    }
                                                }))
                                        )
                                );

                                drawdownWrapper.getInterestCycleList().forEach(
                                        interestCycleWrapper -> interestCycleWrapper.getThirdpartyInterestCycleList().forEach(
                                                thirdPartyInterestCycleWrapper -> deal5LevelFillerThreadList.add(new Thread(() -> beanPropertiesFillerService.thirdPartyInterestCyclePropertiesFiller(interestCycleWrapper)))
                                        )
                                );

                                drawdownWrapper.getCapitalFinancialScheduleList().forEach(
                                        capitalFinancialScheduleWrapper -> capitalFinancialScheduleWrapper.getThirdpartyCapitalScheduleList().forEach(
                                                thirdpartyCapitalScheduleWrapper -> deal5LevelFillerThreadList.add(new Thread(() -> beanPropertiesFillerService.thirdpartyCapitalSchedulePropertiesFiller(thirdpartyCapitalScheduleWrapper)))
                                        )
                                );
                            });
                });

        deal5LevelFillerThreadList.forEach(
                Thread::start);
        deal5LevelFillerThreadList.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        return dealWrapper;
    }

    public DealWrapper deal6LevelFiller(Deal deal) {

        DealWrapper dealWrapper = deal5LevelFiller(deal);
        List<Thread> deal6LevelFillerThreadList = new ArrayList<>();

        dealWrapper.getFacilityList().forEach(
                facilityWrapper -> facilityWrapper.getDrawdownList().forEach(
                        drawdownWrapper -> drawdownWrapper.getFeeList().forEach(
                                feeWrapper -> feeWrapper.getFeeScheduleList().forEach(
                                        feeScheduleWrapper -> feeScheduleWrapper.getThirdPartyFeeScheduleList().forEach(
                                                thirdPartyFeeScheduleWrapper -> deal6LevelFillerThreadList.add(new Thread(() -> beanPropertiesFillerService.thirdPartyFeeSchedulePropertiesFiller(thirdPartyFeeScheduleWrapper)))
                                        )
                                )
                        )
                )
        );

        deal6LevelFillerThreadList.forEach(
                Thread::start);
        deal6LevelFillerThreadList.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        return dealWrapper;
    }

}
