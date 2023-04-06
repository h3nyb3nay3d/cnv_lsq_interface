package com.linedata.lsq.model.wrappers.facilityRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.linedata.lsq.model.wrappers.drawdownRelated.DrawdownWrapper;
import com.linedata.lsq.model.wrappers.feeRelated.FeeWrapper;
import com.linedata.ekip.std.services.facility.entity.Facility;
import com.linedata.ekip.std.services.facility.entity.impl.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FacilityWrapper {

    @JsonIgnore
    private Facility facility;
    private String externalId;
    private String statusCode;
    private Long contractId;
    private Long dealVersionId;
    private String dealDescription;
    private String freeStatusCode;
    private String description;
    private String facilityTypeCode;
    private String facilityCurrencyMain;
    private String processingAreaCode;
    private Date signatureDate;
    private Date effectiveDate;
    private Date expiryDate;
    private Date maturityDate;
    private String schedModeCode;
    private Date schedStartDate;
    private Integer schedNumber;
    private String schedFrequencyCode;
    private Long adminAgentId;
    private BigDecimal grossUnderManagAmt;
    private BigDecimal netUnderManagAmt;
    private BigDecimal facilityAmount;
    private String autoTransactionFlag;
    private List<FacilityCalendarImpl> calendarList;
    private List<FacilityCurrencyImpl> currencyList;
    private List<FacilityIndicatorImpl> accountingIndicatorList;
    private List<FacilityIndicatorImpl> riskIndicatorList;
    private List<FeeWrapper> feeList;
    private List<FacilityThirdpartyWrapper> borrowersList;
    private List<FacilityThirdpartyWrapper> counterpartsList;
    private List<FacilityRateIndexImpl> rateIndexList;
    private List<FacilityLenderWrapper> facilityLenderList;
    private List<FacilityMatrixDateImpl> matrixDateList;
    private List<FacilityMatrixAmountImpl> matrixAmountList;
    private List<FacilityMatrixLineImpl> matrixLineList;

    private List<DrawdownWrapper> drawdownList;

    private String primaryBorrowerId;
    private String primaryBorrowerName;
    private Long transactionId;
    private Long admbinderId;
    private String fuctionCode;
    private Long originId;
    private Double minThreshold;
    private BigDecimal minThresholdAmount;
    private String captureMode;
    private Long fatherTransactionId;
    private Long modifTransactionId;
    private BigDecimal commitmentAmount;
    private BigDecimal drawnAmount;
    private BigDecimal undrawnAmount;
    private String endMonthRule;

    public FacilityWrapper() {
    }

    public FacilityWrapper(Facility facility) {
        this.facility = facility;

        this.externalId = facility.getExternalId();
        this.statusCode = facility.getStatusCode();
        this.contractId = facility.getContractId();
        this.dealVersionId = facility.getDealVersionId();
        this.dealDescription = facility.getDealDescription();
        this.freeStatusCode = facility.getStatusCode();
        this.description = facility.getDescription();
        this.facilityTypeCode = facility.getFacilityTypeCode();
        this.facilityCurrencyMain = facility.getFacilityCurrencyMain();
        this.processingAreaCode = facility.getProcessingAreaCode();
        this.signatureDate = facility.getSignatureDate();
        this.effectiveDate = facility.getEffectiveDate();
        this.expiryDate = facility.getExpiryDate();
        this.maturityDate = facility.getMaturityDate();
        this.schedModeCode = facility.getSchedModeCode();
        this.schedStartDate = facility.getSchedStartDate();
        this.schedNumber = facility.getSchedNumber();
        this.schedFrequencyCode = facility.getSchedFrequencyCode();
        this.adminAgentId = facility.getAdminAgentId();
        this.grossUnderManagAmt = facility.getGrossUnderManagAmt();
        this.netUnderManagAmt = facility.getNetUnderManagAmt();
        this.facilityAmount = facility.getFacilityAmount();
        this.autoTransactionFlag = facility.getAutoTransactionFlag();

        if (facility.getCalendarList() != null)
            this.calendarList = facility.getCalendarList().parallelStream().map(facilityCalendar -> ((FacilityCalendarImpl) facilityCalendar)).collect(Collectors.toList());
        if (facility.getCurrencyList() != null)
            this.currencyList = facility.getCurrencyList().parallelStream().map(facilityCurrency -> ((FacilityCurrencyImpl) facilityCurrency)).collect(Collectors.toList());
        if (facility.getAccountingIndicatorList() != null)
            this.accountingIndicatorList = facility.getAccountingIndicatorList().parallelStream().map(facilityIndicator -> ((FacilityIndicatorImpl) facilityIndicator)).collect(Collectors.toList());
        if (facility.getRiskIndicatorList() != null)
            this.riskIndicatorList = facility.getRiskIndicatorList().parallelStream().map(facilityIndicator -> ((FacilityIndicatorImpl) facilityIndicator)).collect(Collectors.toList());
        if (facility.getBorrowersList() != null)
            this.borrowersList = facility.getBorrowersList().parallelStream().map(FacilityThirdpartyWrapper::new).collect(Collectors.toList());
        if (facility.getCounterpartsList() != null)
            this.counterpartsList = facility.getCounterpartsList().parallelStream().map(FacilityThirdpartyWrapper::new).collect(Collectors.toList());
        if (facility.getRateIndexList() != null)
            this.rateIndexList = facility.getRateIndexList().parallelStream().map(facilityRateIndex -> ((FacilityRateIndexImpl) facilityRateIndex)).collect(Collectors.toList());
        if (facility.getMatrixDateList() != null)
            this.matrixDateList = facility.getMatrixDateList().parallelStream().map(facilityMatrixDate -> ((FacilityMatrixDateImpl) facilityMatrixDate)).collect(Collectors.toList());
        if (facility.getMatrixAmountList() != null)
            this.matrixAmountList = facility.getMatrixAmountList().parallelStream().map(facilityMatrixAmount -> ((FacilityMatrixAmountImpl) facilityMatrixAmount)).collect(Collectors.toList());
        if (facility.getMatrixLineList() != null)
            this.matrixLineList = facility.getMatrixLineList().parallelStream().map(facilityMatrixLine -> ((FacilityMatrixLineImpl) facilityMatrixLine)).collect(Collectors.toList());
        if (facility.getFacilityLenderList() != null)
            this.facilityLenderList = facility.getFacilityLenderList().parallelStream().map(FacilityLenderWrapper::new).collect(Collectors.toList());

        this.primaryBorrowerId = facility.getPrimaryBorrowerId();
        this.primaryBorrowerName = facility.getPrimaryBorrowerName();
        this.transactionId = facility.getTransactionId();
        this.admbinderId = facility.getAdmbinderId();
        this.fuctionCode = facility.getFuctionCode();
        this.originId = facility.getOriginId();
        this.minThreshold = facility.getMinThreshold();
        this.minThresholdAmount = facility.getMinThresholdAmount();
        this.captureMode = facility.getCaptureMode();
        this.fatherTransactionId = facility.getFatherTransactionId();
        this.modifTransactionId = facility.getModifTransactionId();
        this.commitmentAmount = facility.getCommitmentAmount();
        this.drawnAmount = facility.getDrawnAmount();
        this.undrawnAmount = facility.getUndrawnAmount();
        this.endMonthRule = facility.getEndMonthRule();
    }

    public List<DrawdownWrapper> getDrawdownList() {
        return drawdownList;
    }

    public void setDrawdownList(List<DrawdownWrapper> drawdownList) {
        this.drawdownList = drawdownList;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getDealDescription() {
        return this.dealDescription;
    }

    public void setDealDescription(String dealDescription) {
        this.dealDescription = dealDescription;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Long getContractId() {
        return this.contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getDealVersionId() {
        return this.dealVersionId;
    }

    public void setDealVersionId(Long dealVersionId) {
        this.dealVersionId = dealVersionId;
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

    public String getFacilityTypeCode() {
        return this.facilityTypeCode;
    }

    public void setFacilityTypeCode(String facilityTypeCode) {
        this.facilityTypeCode = facilityTypeCode;
    }

    public String getFacilityCurrencyMain() {
        return this.facilityCurrencyMain;
    }

    public void setFacilityCurrencyMain(String facilityCurrencyMain) {
        this.facilityCurrencyMain = facilityCurrencyMain;
    }

    public String getProcessingAreaCode() {
        return this.processingAreaCode;
    }

    public void setProcessingAreaCode(String processingAreaCode) {
        this.processingAreaCode = processingAreaCode;
    }

    public Date getSignatureDate() {
        return this.signatureDate;
    }

    public void setSignatureDate(Date signatureDate) {
        this.signatureDate = signatureDate;
    }

    public Date getEffectiveDate() {
        return this.effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getMaturityDate() {
        return this.maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getSchedModeCode() {
        return this.schedModeCode;
    }

    public void setSchedModeCode(String schedModeCode) {
        this.schedModeCode = schedModeCode;
    }

    public Date getSchedStartDate() {
        return this.schedStartDate;
    }

    public void setSchedStartDate(Date schedStartDate) {
        this.schedStartDate = schedStartDate;
    }

    public Integer getSchedNumber() {
        return this.schedNumber;
    }

    public void setSchedNumber(Integer schedNumber) {
        this.schedNumber = schedNumber;
    }

    public String getSchedFrequencyCode() {
        return this.schedFrequencyCode;
    }

    public void setSchedFrequencyCode(String schedFrequencyCode) {
        this.schedFrequencyCode = schedFrequencyCode;
    }

    public Long getAdminAgentId() {
        return this.adminAgentId;
    }

    public void setAdminAgentId(Long adminAgentId) {
        this.adminAgentId = adminAgentId;
    }

    public BigDecimal getGrossUnderManagAmt() {
        return this.grossUnderManagAmt;
    }

    public void setGrossUnderManagAmt(BigDecimal grossUnderManagAmt) {
        this.grossUnderManagAmt = grossUnderManagAmt;
    }

    public BigDecimal getNetUnderManagAmt() {
        return this.netUnderManagAmt;
    }

    public void setNetUnderManagAmt(BigDecimal netUnderManagAmt) {
        this.netUnderManagAmt = netUnderManagAmt;
    }

    public BigDecimal getFacilityAmount() {
        return this.facilityAmount;
    }

    public void setFacilityAmount(BigDecimal facilityAmount) {
        this.facilityAmount = facilityAmount;
    }

    public String getAutoTransactionFlag() {
        return this.autoTransactionFlag;
    }

    public void setAutoTransactionFlag(String autoTransactionFlag) {
        this.autoTransactionFlag = autoTransactionFlag;
    }

    public List<FacilityCalendarImpl> getCalendarList() {
        return this.calendarList;
    }

    public void setCalendarList(List<FacilityCalendarImpl> calendarList) {
        this.calendarList = calendarList;
    }

    public List<FacilityCurrencyImpl> getCurrencyList() {
        return this.currencyList;
    }

    public void setCurrencyList(List<FacilityCurrencyImpl> currencyList) {
        this.currencyList = currencyList;
    }

    public List<FacilityIndicatorImpl> getAccountingIndicatorList() {
        return this.accountingIndicatorList;
    }

    public void setAccountingIndicatorList(List<FacilityIndicatorImpl> accountingIndicatorList) {
        this.accountingIndicatorList = accountingIndicatorList;
    }

    public List<FacilityIndicatorImpl> getRiskIndicatorList() {
        return this.riskIndicatorList;
    }

    public void setRiskIndicatorList(List<FacilityIndicatorImpl> riskIndicatorList) {
        this.riskIndicatorList = riskIndicatorList;
    }

    public List<FeeWrapper> getFeeList() {
        return this.feeList;
    }

    public void setFeeList(List<FeeWrapper> feeList) {
        this.feeList = feeList;
    }

    public List<FacilityThirdpartyWrapper> getBorrowersList() {
        return this.borrowersList;
    }

    public void setBorrowersList(List<FacilityThirdpartyWrapper> borrowersList) {
        this.borrowersList = borrowersList;
    }

    public List<FacilityThirdpartyWrapper> getCounterpartsList() {
        return this.counterpartsList;
    }

    public void setCounterpartsList(List<FacilityThirdpartyWrapper> counterpartsList) {
        this.counterpartsList = counterpartsList;
    }

    public List<FacilityRateIndexImpl> getRateIndexList() {
        return this.rateIndexList;
    }

    public void setRateIndexList(List<FacilityRateIndexImpl> rateIndexList) {
        this.rateIndexList = rateIndexList;
    }

    public String getPrimaryBorrowerId() {
        return this.primaryBorrowerId;
    }

    public void setPrimaryBorrowerId(String primaryBorrowerId) {
        this.primaryBorrowerId = primaryBorrowerId;
    }

    public String getPrimaryBorrowerName() {
        return this.primaryBorrowerName;
    }

    public void setPrimaryBorrowerName(String primaryBorrowerName) {
        this.primaryBorrowerName = primaryBorrowerName;
    }

    public List<FacilityLenderWrapper> getFacilityLenderList() {
        return this.facilityLenderList;
    }

    public void setFacilityLenderList(List<FacilityLenderWrapper> facilityLenderList) {
        this.facilityLenderList = facilityLenderList;
    }

    public List<FacilityMatrixDateImpl> getMatrixDateList() {
        return this.matrixDateList;
    }

    public void setMatrixDateList(List<FacilityMatrixDateImpl> matrixDateList) {
        this.matrixDateList = matrixDateList;
    }

    public List<FacilityMatrixAmountImpl> getMatrixAmountList() {
        return this.matrixAmountList;
    }

    public void setMatrixAmountList(List<FacilityMatrixAmountImpl> matrixAmountList) {
        this.matrixAmountList = matrixAmountList;
    }

    public List<FacilityMatrixLineImpl> getMatrixLineList() {
        return this.matrixLineList;
    }

    public void setMatrixLineList(List<FacilityMatrixLineImpl> matrixLineList) {
        this.matrixLineList = matrixLineList;
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

    public String getFuctionCode() {
        return this.fuctionCode;
    }

    public void setFuctionCode(String fuctionCode) {
        this.fuctionCode = fuctionCode;
    }

    public Long getOriginId() {
        return this.originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public Double getMinThreshold() {
        return this.minThreshold;
    }

    public void setMinThreshold(Double minThreshold) {
        this.minThreshold = minThreshold;
    }

    public BigDecimal getMinThresholdAmount() {
        return this.minThresholdAmount;
    }

    public void setMinThresholdAmount(BigDecimal minThresholdAmount) {
        this.minThresholdAmount = minThresholdAmount;
    }

    public String getCaptureMode() {
        return this.captureMode;
    }

    public void setCaptureMode(String captureMode) {
        this.captureMode = captureMode;
    }

    public Long getFatherTransactionId() {
        return this.fatherTransactionId;
    }

    public void setFatherTransactionId(Long fatherTransactionId) {
        this.fatherTransactionId = fatherTransactionId;
    }

    public Long getModifTransactionId() {
        return this.modifTransactionId;
    }

    public void setModifTransactionId(Long modifTransactionId) {
        this.modifTransactionId = modifTransactionId;
    }

    public String getEndMonthRule() {
        return this.endMonthRule;
    }

    public void setEndMonthRule(String endMonthRule) {
        this.endMonthRule = endMonthRule;
    }

    public BigDecimal getCommitmentAmount() {
        return this.commitmentAmount;
    }

    public void setCommitmentAmount(BigDecimal commitmentAmount) {
        this.commitmentAmount = commitmentAmount;
    }

    public BigDecimal getDrawnAmount() {
        return this.drawnAmount;
    }

    public void setDrawnAmount(BigDecimal drawnAmount) {
        this.drawnAmount = drawnAmount;
    }

    public BigDecimal getUndrawnAmount() {
        return this.undrawnAmount;
    }

    public void setUndrawnAmount(BigDecimal undrawnAmount) {
        this.undrawnAmount = undrawnAmount;
    }

    public FacilityWrapper update(Facility facility) {
        return new FacilityWrapper(facility);
    }

    @Override
    public String toString() {
        return "FacilityDetailsMapper{" +
                "externalId='" + externalId + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", contractId=" + contractId +
                ", dealVersionId=" + dealVersionId +
                ", dealDescription='" + dealDescription + '\'' +
                ", freeStatusCode='" + freeStatusCode + '\'' +
                ", description='" + description + '\'' +
                ", facilityTypeCode='" + facilityTypeCode + '\'' +
                ", facilityCurrencyMain='" + facilityCurrencyMain + '\'' +
                ", processingAreaCode='" + processingAreaCode + '\'' +
                ", signatureDate=" + signatureDate +
                ", effectiveDate=" + effectiveDate +
                ", expiryDate=" + expiryDate +
                ", maturityDate=" + maturityDate +
                ", schedModeCode='" + schedModeCode + '\'' +
                ", schedStartDate=" + schedStartDate +
                ", schedNumber=" + schedNumber +
                ", schedFrequencyCode='" + schedFrequencyCode + '\'' +
                ", adminAgentId=" + adminAgentId +
                ", grossUnderManagAmt=" + grossUnderManagAmt +
                ", netUnderManagAmt=" + netUnderManagAmt +
                ", facilityAmount=" + facilityAmount +
                ", autoTransactionFlag='" + autoTransactionFlag + '\'' +
                ", calendarList=" + calendarList +
                ", currencyList=" + currencyList +
                ", accountingIndicatorList=" + accountingIndicatorList +
                ", riskIndicatorList=" + riskIndicatorList +
                ", feeList=" + feeList +
                ", borrowersList=" + borrowersList +
                ", counterpartsList=" + counterpartsList +
                ", rateIndexList=" + rateIndexList +
                ", facilityLenderList=" + facilityLenderList +
                ", matrixDateList=" + matrixDateList +
                ", matrixAmountList=" + matrixAmountList +
                ", matrixLineList=" + matrixLineList +
                ", primaryBorrowerId='" + primaryBorrowerId + '\'' +
                ", primaryBorrowerName='" + primaryBorrowerName + '\'' +
                ", transactionId=" + transactionId +
                ", admbinderId=" + admbinderId +
                ", fuctionCode='" + fuctionCode + '\'' +
                ", originId=" + originId +
                ", minThreshold=" + minThreshold +
                ", minThresholdAmount=" + minThresholdAmount +
                ", captureMode='" + captureMode + '\'' +
                ", fatherTransactionId=" + fatherTransactionId +
                ", modifTransactionId=" + modifTransactionId +
                ", commitmentAmount=" + commitmentAmount +
                ", drawnAmount=" + drawnAmount +
                ", undrawnAmount=" + undrawnAmount +
                ", endMonthRule='" + endMonthRule + '\'' +
                '}';
    }
}
