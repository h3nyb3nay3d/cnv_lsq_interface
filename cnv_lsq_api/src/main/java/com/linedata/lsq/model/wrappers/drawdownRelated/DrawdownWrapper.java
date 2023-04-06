package com.linedata.lsq.model.wrappers.drawdownRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.linedata.ekip.std.services.drawdown.entity.Drawdown;
import com.linedata.ekip.std.services.drawdown.entity.impl.DrawdownAdditionalMarginImpl;
import com.linedata.ekip.std.services.drawdown.entity.impl.DrawdownCalendarImpl;
import com.linedata.ekip.std.services.drawdown.entity.impl.DrawdownLenderDetailImpl;
import com.linedata.ekip.std.services.drawdown.entity.impl.DrawdownLenderPortfolioImpl;
import com.linedata.lsq.model.wrappers.feeRelated.FeeWrapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DrawdownWrapper {

    @JsonIgnore
    private Drawdown drawdown;

    private String externalId;
    private String version;
    private String statusCode;
    private Long facilityId;

    private String facilityExternalId;
    private String facilityDescription;
    private String dealDescription;
    private String freeStatusCode;
    private String description;
    private Long financialQuotationId;
    private String drawdownTypeCode;
    private Long borrowerId;
    private String indexRateCode;
    private String accountingPurposeCode;
    private Date effectiveDate;
    private Date maturityDate;
    private String renewalPeriodCode;
    private String riskPurposeCode;
    private Date renewalDate;
    private String autoTransactionFlag;
    private String endMonthRule;
    private Double nominalRate;
    private Double capIndexRate;
    private Double marginValueRate;
    private Double floorIndexRate;
    private Double globalCapRate;
    private Double globalFloorRate;
    private Double marketMarginRate;
    private Double liquidityCost;
    private Date creationDate;
    private String creationUser;
    private Date modificationDate;
    private String schedModeCode;
    private Integer schedNumber;
    private String frequencyCode;
    private Date cycleStartDate;
    private Date cycleEndDate;
    private String termCode;
    private BigDecimal drawdownAmount;
    private BigDecimal initialAmount;
    private String currencyCode;
    private String calcBasisCode;
    private Date paymentDate;
    private Long beneficiaryId;
    private Long beneficiaryThirdpartyId;
    private Long borrowerThirdpartyId;
    private List<DrawdownCalendarImpl> calendarList;
    private List<DrawdownAdditionalMarginImpl> additionalMarginList;
    private List<DrawdownLenderWrapper> lenderList;
    private List<DrawdownLenderDetailImpl> lenderDetailList;

    private List<DrawdownLenderPortfolioImpl> lenderPortfolioList;

    private List<DrawdownThirdpartyWrapper> thirdpartyList;

    private List<FeeWrapper> feeList;
    private List<InterestCycleWrapper> interestCycleList;
    private List<CapitalFinancialScheduleWrapper> capitalFinancialScheduleList;
    private Long transactionId;
    private Long admbinderId;
    private String buyerCreditFlag;
    private BigDecimal amountExclEca;
    private BigDecimal premiumAmountEca;
    private String stabilizationFlag;
    private String stabilizationTypeCode;
    private BigDecimal loanIncreaseAmt;
    private Long originId;
    private Long modifTransactionId;
    private Long renewalTransactionId;
    private String schedFrequencyCode;
    private String functionCode;
    private BigDecimal capitalAmount;
    private Date schedStartDate;
    private Date transactionValueDate;
    private String transactionComments;
    private Boolean calendarModifiedFlag;
    private Boolean scheduleRegeneratedFlag;
    private String dueDateAdjustmentRule;
    private Boolean effectiveDateModifiedFlag;
    private Boolean maturityDateModifiedFlag;
    private String dealExternalId;
    private String calculMethod;
    private Long lagDays;
    private BigDecimal cas;
    private Long nbrDecimal;
    private String roundMethod;
    private String shift;

    private BigDecimal indexFloorRate;

    public DrawdownWrapper() {
    }

    public DrawdownWrapper(Drawdown drawdown) {
        this.drawdown = drawdown;

        this.externalId = drawdown.getExternalId();
        this.version = drawdown.getVersion();
        this.statusCode = drawdown.getStatusCode();
        this.facilityId = drawdown.getFacilityId();
        this.facilityExternalId = drawdown.getFacilityExternalId();
        this.facilityDescription = drawdown.getFacilityDescription();
        this.dealDescription = drawdown.getDealDescription();
        this.freeStatusCode = drawdown.getFreeStatusCode();
        this.description = drawdown.getDescription();
        this.financialQuotationId = drawdown.getFinancialQuotationId();
        this.drawdownTypeCode = drawdown.getDrawdownTypeCode();
        this.borrowerId = drawdown.getBorrowerId();
        this.indexRateCode = drawdown.getIndexRateCode();
        this.accountingPurposeCode = drawdown.getAccountingPurposeCode();
        this.effectiveDate = drawdown.getEffectiveDate();
        this.maturityDate = drawdown.getMaturityDate();
        this.renewalPeriodCode = drawdown.getRenewalPeriodCode();
        this.riskPurposeCode = drawdown.getRiskPurposeCode();
        this.renewalDate = drawdown.getRenewalDate();
        this.autoTransactionFlag = drawdown.getAutoTransactionFlag();
        this.endMonthRule = drawdown.getEndMonthRule();
        this.nominalRate = drawdown.getNominalRate();
        this.capIndexRate = drawdown.getCapIndexRate();
        this.marginValueRate = drawdown.getMarginValueRate();
        this.floorIndexRate = drawdown.getFloorIndexRate();
        this.globalCapRate = drawdown.getGlobalCapRate();
        this.globalFloorRate = drawdown.getGlobalFloorRate();
        this.marketMarginRate = drawdown.getMarketMarginRate();
        this.liquidityCost = drawdown.getLiquidityCost();
        this.creationDate = drawdown.getCreationDate();
        this.creationUser = drawdown.getCreationUser();
        this.modificationDate = drawdown.getModificationDate();
        this.schedModeCode = drawdown.getSchedModeCode();
        this.schedNumber = drawdown.getSchedNumber();
        this.frequencyCode = drawdown.getFrequencyCode();
        this.cycleStartDate = drawdown.getCycleStartDate();
        this.cycleEndDate = drawdown.getCycleEndDate();
        this.termCode = drawdown.getTermCode();
        this.drawdownAmount = drawdown.getDrawdownAmount();
        this.initialAmount = drawdown.getInitialAmount();
        this.currencyCode = drawdown.getCurrencyCode();
        this.calcBasisCode = drawdown.getCalcBasisCode();
        this.paymentDate = drawdown.getPaymentDate();
        this.beneficiaryId = drawdown.getBeneficiaryId();
        this.beneficiaryThirdpartyId = drawdown.getBeneficiaryThirdpartyId();
        this.borrowerThirdpartyId = drawdown.getBorrowerThirdpartyId();
        this.dealExternalId = drawdown.getDealExternalId();
        this.calculMethod = drawdown.getCalculMethod();
        this.lagDays = drawdown.getLagDays();
        this.cas = drawdown.getCas();
        this.nbrDecimal = drawdown.getNbrDecimal();
        this.roundMethod = drawdown.getRoundMethod();
        this.shift = drawdown.getShift();
        this.indexFloorRate = drawdown.getIndexFloorRate();


        if (drawdown.getCalendarList() != null)
            this.calendarList = drawdown.getCalendarList().parallelStream().map(drawdownCalendar -> ((DrawdownCalendarImpl) drawdownCalendar)).collect(Collectors.toList());
        if (drawdown.getAdditionalMarginList() != null)
            this.additionalMarginList = drawdown.getAdditionalMarginList().parallelStream().map(drawdownAdditionalMargin -> ((DrawdownAdditionalMarginImpl) drawdownAdditionalMargin)).collect(Collectors.toList());
        if (drawdown.getLenderList() != null)
            this.lenderList = drawdown.getLenderList().parallelStream().map(DrawdownLenderWrapper::new).collect(Collectors.toList());
        if (drawdown.getLenderDetailList() != null)
            this.lenderDetailList = drawdown.getLenderDetailList().parallelStream().map(drawdownLenderDetail -> ((DrawdownLenderDetailImpl) drawdownLenderDetail)).collect(Collectors.toList());
        if (drawdown.getLenderPortfolioList() != null)
            this.lenderPortfolioList = drawdown.getLenderPortfolioList().parallelStream().map(drawdownLenderPortfolio -> ((DrawdownLenderPortfolioImpl) drawdownLenderPortfolio)).collect(Collectors.toList());
        if (drawdown.getThirdpartyList() != null)
            this.thirdpartyList = drawdown.getThirdpartyList().parallelStream().map(DrawdownThirdpartyWrapper::new).collect(Collectors.toList());
        if (drawdown.getFeeList() != null)
            this.feeList = drawdown.getFeeList().parallelStream().map(FeeWrapper::new).collect(Collectors.toList());

        this.transactionId = drawdown.getTransactionId();
        this.admbinderId = drawdown.getAdmbinderId();
        this.buyerCreditFlag = drawdown.getStabilizationFlag();
        this.amountExclEca = drawdown.getAmountExclEca();
        this.premiumAmountEca = drawdown.getPremiumAmountEca();
        this.stabilizationFlag = drawdown.getStabilizationFlag();
        this.stabilizationTypeCode = drawdown.getStabilizationTypeCode();
        this.loanIncreaseAmt = drawdown.getLoanIncreaseAmt();
        this.originId = drawdown.getOriginId();
        this.modifTransactionId = drawdown.getModifTransactionId();
        this.renewalTransactionId = drawdown.getRenewalTransactionId();
        this.schedFrequencyCode = drawdown.getSchedFrequencyCode();
        this.functionCode = drawdown.getFunctionCode();
        this.capitalAmount = drawdown.getCapitalAmount();
        this.schedStartDate = drawdown.getSchedStartDate();
        this.transactionValueDate = drawdown.getTransactionValueDate();
        this.transactionComments = drawdown.getTransactionComments();
        this.calendarModifiedFlag = drawdown.getCalendarModifiedFlag();
        this.scheduleRegeneratedFlag = drawdown.getScheduleRegeneratedFlag();
        this.dueDateAdjustmentRule = drawdown.getDueDateAdjustmentRule();
        this.effectiveDateModifiedFlag = drawdown.getEffectiveDateModifiedFlag();
        this.maturityDateModifiedFlag = drawdown.getMaturityDateModifiedFlag();
    }

    public String getFacilityExternalId() {
        return facilityExternalId;
    }

    public void setFacilityExternalId(String facilityExternalId) {
        this.facilityExternalId = facilityExternalId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Long getFacilityId() {
        return this.facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public String getFreeStatusCode() {
        return this.freeStatusCode;
    }

    public void setFreeStatusCode(String freeStatusCode) {
        this.freeStatusCode = freeStatusCode;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getFinancialQuotationId() {
        return this.financialQuotationId;
    }

    public void setFinancialQuotationId(Long financialQuotationId) {
        this.financialQuotationId = financialQuotationId;
    }

    public String getDrawdownTypeCode() {
        return this.drawdownTypeCode;
    }

    public void setDrawdownTypeCode(String drawdownTypeCode) {
        this.drawdownTypeCode = drawdownTypeCode;
    }

    public Long getBorrowerId() {
        return this.borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getIndexRateCode() {
        return this.indexRateCode;
    }

    public void setIndexRateCode(String indexRateCode) {
        this.indexRateCode = indexRateCode;
    }

    public String getAccountingPurposeCode() {
        return this.accountingPurposeCode;
    }

    public void setAccountingPurposeCode(String accountingPurposeCode) {
        this.accountingPurposeCode = accountingPurposeCode;
    }

    public Date getEffectiveDate() {
        return this.effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getMaturityDate() {
        return this.maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getRenewalPeriodCode() {
        return this.renewalPeriodCode;
    }

    public void setRenewalPeriodCode(String renewalPeriodCode) {
        this.renewalPeriodCode = renewalPeriodCode;
    }

    public String getRiskPurposeCode() {
        return this.riskPurposeCode;
    }

    public void setRiskPurposeCode(String riskPurposeCode) {
        this.riskPurposeCode = riskPurposeCode;
    }

    public Date getRenewalDate() {
        return this.renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }

    public String getAutoTransactionFlag() {
        return this.autoTransactionFlag;
    }

    public void setAutoTransactionFlag(String autoTransactionFlag) {
        this.autoTransactionFlag = autoTransactionFlag;
    }

    public String getEndMonthRule() {
        return this.endMonthRule;
    }

    public void setEndMonthRule(String endMonthRule) {
        this.endMonthRule = endMonthRule;
    }

    public Double getNominalRate() {
        return this.nominalRate;
    }

    public void setNominalRate(Double nominalRate) {
        this.nominalRate = nominalRate;
    }

    public Double getCapIndexRate() {
        return this.capIndexRate;
    }

    public void setCapIndexRate(Double capIndexRate) {
        this.capIndexRate = capIndexRate;
    }

    public Double getMarginValueRate() {
        return this.marginValueRate;
    }

    public void setMarginValueRate(Double marginValueRate) {
        this.marginValueRate = marginValueRate;
    }

    public Double getFloorIndexRate() {
        return this.floorIndexRate;
    }

    public void setFloorIndexRate(Double floorIndexRate) {
        this.floorIndexRate = floorIndexRate;
    }

    public Double getGlobalCapRate() {
        return this.globalCapRate;
    }

    public void setGlobalCapRate(Double globalCapRate) {
        this.globalCapRate = globalCapRate;
    }

    public Double getGlobalFloorRate() {
        return this.globalFloorRate;
    }

    public void setGlobalFloorRate(Double globalFloorRate) {
        this.globalFloorRate = globalFloorRate;
    }

    public Double getMarketMarginRate() {
        return this.marketMarginRate;
    }

    public void setMarketMarginRate(Double marketMarginRate) {
        this.marketMarginRate = marketMarginRate;
    }

    public Double getLiquidityCost() {
        return this.liquidityCost;
    }

    public void setLiquidityCost(Double liquidityCost) {
        this.liquidityCost = liquidityCost;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreationUser() {
        return this.creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public Date getModificationDate() {
        return this.modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getSchedModeCode() {
        return this.schedModeCode;
    }

    public void setSchedModeCode(String schedModeCode) {
        this.schedModeCode = schedModeCode;
    }

    public Integer getSchedNumber() {
        return this.schedNumber;
    }

    public void setSchedNumber(Integer schedNumber) {
        this.schedNumber = schedNumber;
    }

    public String getFrequencyCode() {
        return this.frequencyCode;
    }

    public void setFrequencyCode(String frequencyCode) {
        this.frequencyCode = frequencyCode;
    }

    public Date getCycleStartDate() {
        return this.cycleStartDate;
    }

    public void setCycleStartDate(Date cycleStartDate) {
        this.cycleStartDate = cycleStartDate;
    }

    public Date getCycleEndDate() {
        return this.cycleEndDate;
    }

    public void setCycleEndDate(Date cycleEndDate) {
        this.cycleEndDate = cycleEndDate;
    }

    public String getTermCode() {
        return this.termCode;
    }

    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }

    public BigDecimal getDrawdownAmount() {
        return this.drawdownAmount;
    }

    public void setDrawdownAmount(BigDecimal drawdownAmount) {
        this.drawdownAmount = drawdownAmount;
    }

    public BigDecimal getInitialAmount() {
        return this.initialAmount;
    }

    public void setInitialAmount(BigDecimal initialAmount) {
        this.initialAmount = initialAmount;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCalcBasisCode() {
        return this.calcBasisCode;
    }

    public void setCalcBasisCode(String calcBasisCode) {
        this.calcBasisCode = calcBasisCode;
    }

    public List<DrawdownCalendarImpl> getCalendarList() {
        return this.calendarList;
    }

    public void setCalendarList(List<DrawdownCalendarImpl> calendarList) {
        this.calendarList = calendarList;
    }

    public List<DrawdownAdditionalMarginImpl> getAdditionalMarginList() {
        return this.additionalMarginList;
    }

    public void setAdditionalMarginList(List<DrawdownAdditionalMarginImpl> additionalMarginList) {
        this.additionalMarginList = additionalMarginList;
    }

    public List<DrawdownLenderWrapper> getLenderList() {
        return this.lenderList;
    }

    public void setLenderList(List<DrawdownLenderWrapper> lenderList) {
        this.lenderList = lenderList;
    }

    public List<DrawdownLenderDetailImpl> getLenderDetailList() {
        return this.lenderDetailList;
    }

    public void setLenderDetailList(List<DrawdownLenderDetailImpl> lenderDetailList) {
        this.lenderDetailList = lenderDetailList;
    }

    public List<DrawdownLenderPortfolioImpl> getLenderPortfolioList() {
        return this.lenderPortfolioList;
    }

    public void setLenderPortfolioList(List<DrawdownLenderPortfolioImpl> lenderPortfolioList) {
        this.lenderPortfolioList = lenderPortfolioList;
    }

    public String getFacilityDescription() {
        return this.facilityDescription;
    }

    public void setFacilityDescription(String facilityDescription) {
        this.facilityDescription = facilityDescription;
    }

    public String getDealDescription() {
        return this.dealDescription;
    }

    public void setDealDescription(String dealDescription) {
        this.dealDescription = dealDescription;
    }

    public Date getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public List<DrawdownThirdpartyWrapper> getThirdpartyList() {
        return this.thirdpartyList;
    }

    public void setThirdpartyList(List<DrawdownThirdpartyWrapper> thirdpartyList) {
        this.thirdpartyList = thirdpartyList;
    }

    public Long getBeneficiaryId() {
        return this.beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public Long getBeneficiaryThirdpartyId() {
        return this.beneficiaryThirdpartyId;
    }

    public void setBeneficiaryThirdpartyId(Long beneficiaryThirdpartyId) {
        this.beneficiaryThirdpartyId = beneficiaryThirdpartyId;
    }

    public Long getBorrowerThirdpartyId() {
        return this.borrowerThirdpartyId;
    }

    public void setBorrowerThirdpartyId(Long borrowerThirdpartyId) {
        this.borrowerThirdpartyId = borrowerThirdpartyId;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getAdmbinderId() {
        return this.admbinderId;
    }

    public void setAdmbinderId(Long admbinderId) {
        this.admbinderId = admbinderId;
    }

    public String getBuyerCreditFlag() {
        return this.buyerCreditFlag;
    }

    public void setBuyerCreditFlag(String buyerCreditFlag) {
        this.buyerCreditFlag = buyerCreditFlag;
    }

    public BigDecimal getAmountExclEca() {
        return this.amountExclEca;
    }

    public void setAmountExclEca(BigDecimal amountExclEca) {
        this.amountExclEca = amountExclEca;
    }

    public BigDecimal getPremiumAmountEca() {
        return this.premiumAmountEca;
    }

    public void setPremiumAmountEca(BigDecimal premiumAmountEca) {
        this.premiumAmountEca = premiumAmountEca;
    }

    public String getStabilizationFlag() {
        return this.stabilizationFlag;
    }

    public void setStabilizationFlag(String stabilizationFlag) {
        this.stabilizationFlag = stabilizationFlag;
    }

    public String getStabilizationTypeCode() {
        return this.stabilizationTypeCode;
    }

    public void setStabilizationTypeCode(String stabilizationTypeCode) {
        this.stabilizationTypeCode = stabilizationTypeCode;
    }

    public String getFunctionCode() {
        return this.functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public BigDecimal getLoanIncreaseAmt() {
        return this.loanIncreaseAmt;
    }

    public void setLoanIncreaseAmt(BigDecimal loanIncreaseAmt) {
        this.loanIncreaseAmt = loanIncreaseAmt;
    }

    public Long getOriginId() {
        return this.originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public List<FeeWrapper> getFeeList() {
        return this.feeList;
    }

    public void setFeeList(List<FeeWrapper> feeList) {
        this.feeList = feeList;
    }

    public Long getRenewalTransactionId() {
        return this.renewalTransactionId;
    }

    public void setRenewalTransactionId(Long renewalTransactionId) {
        this.renewalTransactionId = renewalTransactionId;
    }

    public String getSchedFrequencyCode() {
        return this.schedFrequencyCode;
    }

    public void setSchedFrequencyCode(String schedFrequencyCode) {
        this.schedFrequencyCode = schedFrequencyCode;
    }

    public BigDecimal getCapitalAmount() {
        return this.capitalAmount;
    }

    public void setCapitalAmount(BigDecimal capitalAmount) {
        this.capitalAmount = capitalAmount;
    }

    public Date getSchedStartDate() {
        return this.schedStartDate;
    }

    public void setSchedStartDate(Date schedStartDate) {
        this.schedStartDate = schedStartDate;
    }

    public Long getModifTransactionId() {
        return this.modifTransactionId;
    }

    public void setModifTransactionId(Long modifTransactionId) {
        this.modifTransactionId = modifTransactionId;
    }

    public Date getTransactionValueDate() {
        return this.transactionValueDate;
    }

    public void setTransactionValueDate(Date transactionValueDate) {
        this.transactionValueDate = transactionValueDate;
    }

    public String getTransactionComments() {
        return this.transactionComments;
    }

    public void setTransactionComments(String transactionComments) {
        this.transactionComments = transactionComments;
    }

    public Boolean getCalendarModifiedFlag() {
        return this.calendarModifiedFlag;
    }

    public void setCalendarModifiedFlag(Boolean calendarModifiedFlag) {
        this.calendarModifiedFlag = calendarModifiedFlag;
    }

    public Boolean getScheduleRegeneratedFlag() {
        return this.scheduleRegeneratedFlag;
    }

    public void setScheduleRegeneratedFlag(Boolean scheduleRegeneratedFlag) {
        this.scheduleRegeneratedFlag = scheduleRegeneratedFlag;
    }

    public String getDueDateAdjustmentRule() {
        return this.dueDateAdjustmentRule;
    }

    public void setDueDateAdjustmentRule(String dueDateAdjustmentRule) {
        this.dueDateAdjustmentRule = dueDateAdjustmentRule;
    }

    public Boolean getEffectiveDateModifiedFlag() {
        return this.effectiveDateModifiedFlag;
    }

    public void setEffectiveDateModifiedFlag(Boolean effectiveDateModifiedFlag) {
        this.effectiveDateModifiedFlag = effectiveDateModifiedFlag;
    }

    public Boolean getMaturityDateModifiedFlag() {
        return this.maturityDateModifiedFlag;
    }

    public void setMaturityDateModifiedFlag(Boolean maturityDateModifiedFlag) {
        this.maturityDateModifiedFlag = maturityDateModifiedFlag;
    }

    public Drawdown getDrawdown() {
        return drawdown;
    }

    public void setDrawdown(Drawdown drawdown) {
        this.drawdown = drawdown;
    }

    public List<InterestCycleWrapper> getInterestCycleList() {
        return interestCycleList;
    }

    public void setInterestCycleList(List<InterestCycleWrapper> interestCycleList) {
        this.interestCycleList = interestCycleList;
    }

    public List<CapitalFinancialScheduleWrapper> getCapitalFinancialScheduleList() {
        return capitalFinancialScheduleList;
    }

    public void setCapitalFinancialScheduleList(List<CapitalFinancialScheduleWrapper> capitalFinancialScheduleList) {
        this.capitalFinancialScheduleList = capitalFinancialScheduleList;
    }

    public String getDealExternalId() {
        return dealExternalId;
    }

    public void setDealExternalId(String dealExternalId) {
        this.dealExternalId = dealExternalId;
    }

    public String getCalculMethod() {
        return calculMethod;
    }

    public void setCalculMethod(String calculMethod) {
        this.calculMethod = calculMethod;
    }

    public Long getLagDays() {
        return lagDays;
    }

    public void setLagDays(Long lagDays) {
        this.lagDays = lagDays;
    }

    public BigDecimal getCas() {
        return cas;
    }

    public void setCas(BigDecimal cas) {
        this.cas = cas;
    }

    public Long getNbrDecimal() {
        return nbrDecimal;
    }

    public void setNbrDecimal(Long nbrDecimal) {
        this.nbrDecimal = nbrDecimal;
    }

    public String getRoundMethod() {
        return roundMethod;
    }

    public void setRoundMethod(String roundMethod) {
        this.roundMethod = roundMethod;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public BigDecimal getIndexFloorRate() {
        return indexFloorRate;
    }

    public void setIndexFloorRate(BigDecimal indexFloorRate) {
        this.indexFloorRate = indexFloorRate;
    }
}
