package com.linedata.lsq.model.wrappers.feeRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.linedata.ekip.std.services.fee.entity.Fee;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FeeWrapper {

    @JsonIgnore
    private Fee fee;

    private String externalId;
    private String version;
    private String statusCode;
    private Long managementLevelId;
    private String managementLevelCode;
    private String feeTypeCode;
    private String calcBasisCode;
    private String matrixFlag;
    private Long matrixLineId;
    private BigDecimal grossAmount;
    private BigDecimal minimumAmount;
    private BigDecimal currentCycleMinimumAmount;
    private BigDecimal netAmount;
    private BigDecimal percentage;
    private String feeCode;
    private String currencyCode;
    private String taxCode;
    private Long agentId;
    private Date startDate;
    private Date endDate;
    private String calendarCode;
    private String frequencyCode;
    private String termCode;
    private String nbdRule;
    private Long pmtCounterpartId;
    private boolean flagDelete;
    private boolean flagUpdate;
    private boolean flagInsert;
    private boolean isSelected;
    private boolean isPeriodique;
    private String senseCode;
    private Long transactionId;
    private Long beneficiaryId;
    private String beneficiaryRoleCode;
    private String taxeCode;
    private String agentCode;
    private Long dealVersionId;
    private String facilityId;
    private String externalTransactionId;
    private String scheduleFlag;
    private List<FeeScheduleWrapper> feeScheduleList;
    private String percentageModeFlag;
    private BigDecimal remainingAmount;
    private String declarationId;
    private String lendingFlag;
    private Long exigibleHeaderId;
    private Long originId;
    private Long modifTransactionId;
    private String dueDateAdjustmentRule;
    private String impactAfterModif;

    public FeeWrapper() {
    }

    public FeeWrapper(Fee fee) {
        this.fee = fee;

        this.externalId = fee.getExternalId();
        this.version = fee.getVersion();
        this.statusCode = fee.getStatusCode();
        this.managementLevelId = fee.getManagementLevelId();
        this.managementLevelCode = fee.getManagementLevelCode();
        this.feeTypeCode = fee.getFeeTypeCode();
        this.calcBasisCode = fee.getCalcBasisCode();
        this.matrixFlag = fee.getMatrixFlag();
        this.matrixLineId = fee.getMatrixLineId();
        this.grossAmount = fee.getGrossAmount();
        this.minimumAmount = fee.getMinimumAmount();
        this.currentCycleMinimumAmount = fee.getCurrentCycleMinimumAmount();
        this.netAmount = fee.getNetAmount();
        this.percentage = fee.getPercentage();
        this.feeCode = fee.getFeeCode();
        this.currencyCode = fee.getCurrencyCode();
        this.taxCode = fee.getTaxCode();
        this.agentId = fee.getAgentId();
        this.startDate = fee.getStartDate();
        this.endDate = fee.getEndDate();
        this.calendarCode = fee.getCalendarCode();
        this.frequencyCode = fee.getFrequencyCode();
        this.termCode = fee.getTermCode();
        this.nbdRule = fee.getNbdRule();
        this.pmtCounterpartId = fee.getPmtCounterpartId();
        this.flagDelete = fee.isFlagDelete();
        this.flagUpdate = fee.isFlagUpdate();
        this.flagInsert = fee.isFlagInsert();
        this.isSelected = fee.isSelected();
        this.isPeriodique = fee.isPeriodique();
        this.senseCode = fee.getSenseCode();
        this.transactionId = fee.getTransactionId();
        this.beneficiaryId = fee.getBeneficiaryId();
        this.beneficiaryRoleCode = fee.getBeneficiaryRoleCode();
        this.taxeCode = fee.getTaxeCode();
        this.agentCode = fee.getAgentCode();
        this.dealVersionId = fee.getDealVersionId();
        this.facilityId = fee.getFacilityId();
        this.externalTransactionId = fee.getExternalTransactionId();
        this.scheduleFlag = fee.getScheduleFlag();

        if (fee.getFeeScheduleList() != null)
            this.feeScheduleList = fee.getFeeScheduleList().parallelStream().map(feeSchedule -> new FeeScheduleWrapper(feeSchedule)).collect(Collectors.toList());

        this.percentageModeFlag = fee.getPercentageModeFlag();
        this.remainingAmount = fee.getRemainingAmount();
        this.declarationId = fee.getDeclarationId();
        this.lendingFlag = fee.getLendingFlag();
        this.exigibleHeaderId = fee.getExigibleHeaderId();
        this.originId = fee.getOriginId();
        this.modifTransactionId = fee.getModifTransactionId();
        this.dueDateAdjustmentRule = fee.getDueDateAdjustmentRule();
        this.impactAfterModif = fee.getImpactAfterModif();
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
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

    public Long getManagementLevelId() {
        return this.managementLevelId;
    }

    public void setManagementLevelId(Long managementLevelId) {
        this.managementLevelId = managementLevelId;
    }

    public String getManagementLevelCode() {
        return this.managementLevelCode;
    }

    public void setManagementLevelCode(String managementLevelCode) {
        this.managementLevelCode = managementLevelCode;
    }

    public String getFeeTypeCode() {
        return this.feeTypeCode;
    }

    public void setFeeTypeCode(String feeTypeCode) {
        this.feeTypeCode = feeTypeCode;
    }

    public String getCalcBasisCode() {
        return this.calcBasisCode;
    }

    public void setCalcBasisCode(String calcBasisCode) {
        this.calcBasisCode = calcBasisCode;
    }

    public String getMatrixFlag() {
        return this.matrixFlag;
    }

    public void setMatrixFlag(String matrixFlag) {
        this.matrixFlag = matrixFlag;
    }

    public Long getMatrixLineId() {
        return this.matrixLineId;
    }

    public void setMatrixLineId(Long matrixLineId) {
        this.matrixLineId = matrixLineId;
    }

    public BigDecimal getGrossAmount() {
        return this.grossAmount;
    }

    public void setGrossAmount(BigDecimal grossAmount) {
        this.grossAmount = grossAmount;
    }

    public BigDecimal getNetAmount() {
        return this.netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getPercentage() {
        return this.percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public String getFeeCode() {
        return this.feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getTaxCode() {
        return this.taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public Long getAgentId() {
        return this.agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCalendarCode() {
        return this.calendarCode;
    }

    public void setCalendarCode(String calendarCode) {
        this.calendarCode = calendarCode;
    }

    public String getFrequencyCode() {
        return this.frequencyCode;
    }

    public void setFrequencyCode(String frequencyCode) {
        this.frequencyCode = frequencyCode;
    }

    public String getTermCode() {
        return this.termCode;
    }

    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }

    public String getNbdRule() {
        return this.nbdRule;
    }

    public void setNbdRule(String nbdRule) {
        this.nbdRule = nbdRule;
    }

    public Long getPmtCounterpartId() {
        return this.pmtCounterpartId;
    }

    public void setPmtCounterpartId(Long pmtCounterpartId) {
        this.pmtCounterpartId = pmtCounterpartId;
    }

    public boolean isFlagDelete() {
        return this.flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public boolean isFlagUpdate() {
        return this.flagUpdate;
    }

    public void setFlagUpdate(boolean flagUpdate) {
        this.flagUpdate = flagUpdate;
    }

    public boolean isFlagInsert() {
        return this.flagInsert;
    }

    public void setFlagInsert(boolean flagInsert) {
        this.flagInsert = flagInsert;
    }

    public String getSenseCode() {
        return this.senseCode;
    }

    public void setSenseCode(String senseCode) {
        this.senseCode = senseCode;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getBeneficiaryId() {
        return this.beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public String getBeneficiaryRoleCode() {
        return this.beneficiaryRoleCode;
    }

    public void setBeneficiaryRoleCode(String beneficiaryRoleCode) {
        this.beneficiaryRoleCode = beneficiaryRoleCode;
    }

    public String getTaxeCode() {
        return this.taxeCode;
    }

    public void setTaxeCode(String taxeCode) {
        this.taxeCode = taxeCode;
    }

    public String getAgentCode() {
        return this.agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public Long getDealVersionId() {
        return this.dealVersionId;
    }

    public void setDealVersionId(Long dealVersionId) {
        this.dealVersionId = dealVersionId;
    }

    public String getFacilityId() {
        return this.facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getExternalTransactionId() {
        return this.externalTransactionId;
    }

    public void setExternalTransactionId(String externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
    }

    public String getScheduleFlag() {
        return this.scheduleFlag;
    }

    public void setScheduleFlag(String scheduleFlag) {
        this.scheduleFlag = scheduleFlag;
    }

    public List<FeeScheduleWrapper> getFeeScheduleList() {
        return this.feeScheduleList;
    }

    public void setFeeScheduleList(List<FeeScheduleWrapper> feeScheduleList) {
        this.feeScheduleList = feeScheduleList;
    }

    public String getPercentageModeFlag() {
        return this.percentageModeFlag;
    }

    public void setPercentageModeFlag(String percentageModeFlag) {
        this.percentageModeFlag = percentageModeFlag;
    }

    public BigDecimal getRemainingAmount() {
        return this.remainingAmount;
    }

    public void setRemainingAmount(BigDecimal remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public String getDeclarationId() {
        return this.declarationId;
    }

    public void setDeclarationId(String declarationId) {
        this.declarationId = declarationId;
    }

    public String getLendingFlag() {
        return this.lendingFlag == null ? "O" : this.lendingFlag;
    }

    public void setLendingFlag(String lendingFlag) {
        this.lendingFlag = lendingFlag;
    }

    public Long getExigibleHeaderId() {
        return this.exigibleHeaderId;
    }

    public void setExigibleHeaderId(Long exigibleHeaderId) {
        this.exigibleHeaderId = exigibleHeaderId;
    }

    public Long getOriginId() {
        return this.originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public Long getModifTransactionId() {
        return this.modifTransactionId;
    }

    public void setModifTransactionId(Long modifTransactionId) {
        this.modifTransactionId = modifTransactionId;
    }

    public String getDueDateAdjustmentRule() {
        return this.dueDateAdjustmentRule;
    }

    public void setDueDateAdjustmentRule(String dueDateAdjustmentRule) {
        this.dueDateAdjustmentRule = dueDateAdjustmentRule;
    }

    public String getImpactAfterModif() {
        return this.impactAfterModif;
    }

    public void setImpactAfterModif(String impactAfterModif) {
        this.impactAfterModif = impactAfterModif;
    }

    public BigDecimal getMinimumAmount() {
        return this.minimumAmount;
    }

    public void setMinimumAmount(BigDecimal minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public boolean isPeriodique() {
        return this.isPeriodique;
    }

    public void setPeriodique(boolean isPeriodique) {
        this.isPeriodique = isPeriodique;
    }

    public BigDecimal getCurrentCycleMinimumAmount() {
        return this.currentCycleMinimumAmount;
    }

    public void setCurrentCycleMinimumAmount(BigDecimal currentCycleMinimumAmount) {
        this.currentCycleMinimumAmount = currentCycleMinimumAmount;
    }

    @Override
    public String toString() {
        return "FeeDetailsMapper{" +
                "externalId='" + externalId + '\'' +
                ", version='" + version + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", managementLevelId=" + managementLevelId +
                ", managementLevelCode='" + managementLevelCode + '\'' +
                ", feeTypeCode='" + feeTypeCode + '\'' +
                ", calcBasisCode='" + calcBasisCode + '\'' +
                ", matrixFlag='" + matrixFlag + '\'' +
                ", matrixLineId=" + matrixLineId +
                ", grossAmount=" + grossAmount +
                ", minimumAmount=" + minimumAmount +
                ", currentCycleMinimumAmount=" + currentCycleMinimumAmount +
                ", netAmount=" + netAmount +
                ", percentage=" + percentage +
                ", feeCode='" + feeCode + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", taxCode='" + taxCode + '\'' +
                ", agentId=" + agentId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", calendarCode='" + calendarCode + '\'' +
                ", frequencyCode='" + frequencyCode + '\'' +
                ", termCode='" + termCode + '\'' +
                ", nbdRule='" + nbdRule + '\'' +
                ", pmtCounterpartId=" + pmtCounterpartId +
                ", flagDelete=" + flagDelete +
                ", flagUpdate=" + flagUpdate +
                ", flagInsert=" + flagInsert +
                ", isSelected=" + isSelected +
                ", isPeriodique=" + isPeriodique +
                ", senseCode='" + senseCode + '\'' +
                ", transactionId=" + transactionId +
                ", beneficiaryId=" + beneficiaryId +
                ", beneficiaryRoleCode='" + beneficiaryRoleCode + '\'' +
                ", taxeCode='" + taxeCode + '\'' +
                ", agentCode='" + agentCode + '\'' +
                ", dealVersionId=" + dealVersionId +
                ", facilityId='" + facilityId + '\'' +
                ", externalTransactionId='" + externalTransactionId + '\'' +
                ", scheduleFlag='" + scheduleFlag + '\'' +
                ", feeScheduleList=" + feeScheduleList +
                ", percentageModeFlag='" + percentageModeFlag + '\'' +
                ", remainingAmount=" + remainingAmount +
                ", declarationId='" + declarationId + '\'' +
                ", lendingFlag='" + lendingFlag + '\'' +
                ", exigibleHeaderId=" + exigibleHeaderId +
                ", originId=" + originId +
                ", modifTransactionId=" + modifTransactionId +
                ", dueDateAdjustmentRule='" + dueDateAdjustmentRule + '\'' +
                ", impactAfterModif='" + impactAfterModif + '\'' +
                '}';
    }
}
