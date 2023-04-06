package com.linedata.lsq.model.wrappers.feeRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.linedata.ekip.std.services.fee.entity.FeeSchedule;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FeeScheduleWrapper {

    @JsonIgnore
    private FeeSchedule feeSchedule;

    private String externalId;
    private String version;
    private String statusCode;
    private Long feeId;
    private Date startDate;
    private Date endDate;
    private Date paymentDate;
    private BigDecimal grossAmount;
    private BigDecimal netAmount;
    private String taxCode;
    private String transactionExternalId;
    private Long transactionId;
    private BigDecimal balanceAmount;
    private BigDecimal minimumAmount;
    private BigDecimal feeAdjustAmount;
    private Long originId;
    private List<ThirdPartyFeeScheduleWrapper> thirdPartyFeeScheduleList;
    private boolean flagDelete;
    private boolean flagUpdate;
    private boolean flagInsert;
    private String toRecalculate;

    public FeeScheduleWrapper() {
    }

    public FeeScheduleWrapper(FeeSchedule feeSchedule) {
        this.feeSchedule = feeSchedule;

        this.externalId = feeSchedule.getExternalId();
        this.version = feeSchedule.getVersion();
        this.statusCode = feeSchedule.getStatusCode();
        this.feeId = feeSchedule.getFeeId();
        this.startDate = feeSchedule.getStartDate();
        this.endDate = feeSchedule.getEndDate();
        this.paymentDate = feeSchedule.getPaymentDate();
        this.grossAmount = feeSchedule.getGrossAmount();
        this.netAmount = feeSchedule.getNetAmount();
        this.taxCode = feeSchedule.getTaxCode();
        this.transactionExternalId = feeSchedule.getTransactionExternalId();
        this.transactionId = feeSchedule.getTransactionId();
        this.balanceAmount = feeSchedule.getBalanceAmount();
        this.minimumAmount = feeSchedule.getMinimumAmount();
        this.feeAdjustAmount = feeSchedule.getFeeAdjustAmount();
        this.originId = feeSchedule.getOriginId();

        if (feeSchedule.getThirdPartyFeeScheduleList() != null)
            this.thirdPartyFeeScheduleList = feeSchedule.getThirdPartyFeeScheduleList().parallelStream().map(thirdPartyFeeSchedule -> new ThirdPartyFeeScheduleWrapper(thirdPartyFeeSchedule)).collect(Collectors.toList());

        this.flagDelete = feeSchedule.isFlagDelete();
        this.flagUpdate = feeSchedule.isFlagUpdate();
        this.flagInsert = feeSchedule.isFlagInsert();
        this.toRecalculate = feeSchedule.getToRecalculate();
    }

    public FeeSchedule getFeeSchedule() {
        return feeSchedule;
    }

    public void setFeeSchedule(FeeSchedule feeSchedule) {
        this.feeSchedule = feeSchedule;
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

    public Long getFeeId() {
        return this.feeId;
    }

    public void setFeeId(Long feeId) {
        this.feeId = feeId;
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

    public Date getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
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

    public String getTaxCode() {
        return this.taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
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

    public BigDecimal getBalanceAmount() {
        return this.balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public BigDecimal getFeeAdjustAmount() {
        return this.feeAdjustAmount;
    }

    public void setFeeAdjustAmount(BigDecimal feeAdjustAmount) {
        this.feeAdjustAmount = feeAdjustAmount;
    }

    public Long getOriginId() {
        return this.originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public List<ThirdPartyFeeScheduleWrapper> getThirdPartyFeeScheduleList() {
        return this.thirdPartyFeeScheduleList;
    }

    public void setThirdPartyFeeScheduleList(List<ThirdPartyFeeScheduleWrapper> thirdPartyFeeScheduleList) {
        this.thirdPartyFeeScheduleList = thirdPartyFeeScheduleList;
    }

    public String getTransactionExternalId() {
        return this.transactionExternalId;
    }

    public void setTransactionExternalId(String transactionExternalId) {
        this.transactionExternalId = transactionExternalId;
    }

    public BigDecimal getMinimumAmount() {
        return this.minimumAmount;
    }

    public void setMinimumAmount(BigDecimal minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public String getToRecalculate() {
        return this.toRecalculate;
    }

    public void setToRecalculate(String toRecalculate) {
        this.toRecalculate = toRecalculate;
    }

    @Override
    public String toString() {
        return "FeeScheduleDetailsMapper{" +
                "externalId='" + externalId + '\'' +
                ", version='" + version + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", feeId=" + feeId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", paymentDate=" + paymentDate +
                ", grossAmount=" + grossAmount +
                ", netAmount=" + netAmount +
                ", taxCode='" + taxCode + '\'' +
                ", transactionExternalId='" + transactionExternalId + '\'' +
                ", transactionId=" + transactionId +
                ", balanceAmount=" + balanceAmount +
                ", minimumAmount=" + minimumAmount +
                ", feeAdjustAmount=" + feeAdjustAmount +
                ", originId=" + originId +
                ", thirdPartyFeeScheduleList=" + thirdPartyFeeScheduleList +
                ", flagDelete=" + flagDelete +
                ", flagUpdate=" + flagUpdate +
                ", flagInsert=" + flagInsert +
                ", toRecalculate='" + toRecalculate + '\'' +
                '}';
    }
}
