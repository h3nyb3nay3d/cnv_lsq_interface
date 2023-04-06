package com.linedata.lsq.model.wrappers.drawdownRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.linedata.ekip.std.services.interest.entity.InterestCycle;
import com.linedata.ekip.std.services.interest.entity.impl.InterestCycleDetailsImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class InterestCycleWrapper {

    @JsonIgnore
    private InterestCycle interestCycle;

    private String version;
    private String statusCode;
    private Long drawdownId;
    private Date cycleStartDate;
    private Date cycleEndDate;
    private Date paymentDate;
    private String frequencyCode;
    private String termCode;
    private BigDecimal indexRateValue;
    private BigDecimal capIndexRate;
    private BigDecimal floorIndexRate;
    private BigDecimal marginValueRate;
    private BigDecimal globalCapRate;
    private BigDecimal globalFloorRate;
    private BigDecimal interestAmount;
    private BigDecimal interestAdjustedAmount;
    private Long transactionId;
    private Long originId;
    private Long renewalCycleId;
    private BigDecimal balanceAmount;
    private boolean flagDelete;
    private boolean flagUpdate;
    private boolean flagInsert;
    private List<ThirdPartyInterestCycleWrapper> thirdpartyInterestCycleList;
    private List<InterestCycleDetailsImpl> interestCycleDetailsList;
    private String transactionExternalId;
    private String transactionTypeCode;
    private String toRecalculate;

    public InterestCycleWrapper() {
    }

    public InterestCycleWrapper(InterestCycle interestCycle) {
        this.interestCycle = interestCycle;
        this.version = interestCycle.getVersion();
        this.statusCode = interestCycle.getStatusCode();
        this.drawdownId = interestCycle.getDrawdownId();
        this.cycleStartDate = interestCycle.getCycleStartDate();
        this.cycleEndDate = interestCycle.getCycleEndDate();
        this.paymentDate = interestCycle.getPaymentDate();
        this.frequencyCode = interestCycle.getFrequencyCode();
        this.termCode = interestCycle.getTermCode();
        this.indexRateValue = interestCycle.getIndexRateValue();
        this.capIndexRate = interestCycle.getCapIndexRate();
        this.floorIndexRate = interestCycle.getFloorIndexRate();
        this.marginValueRate = interestCycle.getMarginValueRate();
        this.globalCapRate = interestCycle.getGlobalCapRate();
        this.globalFloorRate = interestCycle.getGlobalFloorRate();
        this.interestAmount = interestCycle.getInterestAmount();
        this.interestAdjustedAmount = interestCycle.getInterestAdjustedAmount();
        this.transactionId = interestCycle.getTransactionId();
        this.originId = interestCycle.getOriginId();
        this.renewalCycleId = interestCycle.getRenewalCycleId();
        this.balanceAmount = interestCycle.getBalanceAmount();
        this.flagDelete = interestCycle.isFlagDelete();
        this.flagUpdate = interestCycle.isFlagUpdate();
        this.flagInsert = interestCycle.isFlagInsert();
        if (interestCycle.getThirdpartyInterestCycleList() != null)
            this.thirdpartyInterestCycleList = interestCycle.getThirdpartyInterestCycleList().parallelStream().map(ThirdPartyInterestCycleWrapper::new).collect(Collectors.toList());
        if (interestCycle.getInterestCycleDetails() != null)
            this.interestCycleDetailsList = interestCycle.getInterestCycleDetails().parallelStream().map(interestCycleDetails -> ((InterestCycleDetailsImpl) interestCycleDetails)).collect(Collectors.toList());
        this.transactionExternalId = interestCycle.getTransactionExternalId();
        this.transactionTypeCode = interestCycle.getTransactionTypeCode();
        this.toRecalculate = interestCycle.getToRecalculate();
    }

    public InterestCycle getInterestCycle() {
        return interestCycle;
    }

    public void setInterestCycle(InterestCycle interestCycle) {
        this.interestCycle = interestCycle;
    }

    public List<InterestCycleDetailsImpl> getInterestCycleDetailsList() {
        return interestCycleDetailsList;
    }

    public void setInterestCycleDetailsList(List<InterestCycleDetailsImpl> interestCycleDetailsList) {
        this.interestCycleDetailsList = interestCycleDetailsList;
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

    public Long getDrawdownId() {
        return this.drawdownId;
    }

    public void setDrawdownId(Long drawdownId) {
        this.drawdownId = drawdownId;
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

    public Date getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
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

    public BigDecimal getIndexRateValue() {
        return this.indexRateValue;
    }

    public void setIndexRateValue(BigDecimal indexRateValue) {
        this.indexRateValue = indexRateValue;
    }

    public BigDecimal getCapIndexRate() {
        return this.capIndexRate;
    }

    public void setCapIndexRate(BigDecimal capIndexRate) {
        this.capIndexRate = capIndexRate;
    }

    public BigDecimal getFloorIndexRate() {
        return this.floorIndexRate;
    }

    public void setFloorIndexRate(BigDecimal floorIndexRate) {
        this.floorIndexRate = floorIndexRate;
    }

    public BigDecimal getMarginValueRate() {
        return this.marginValueRate;
    }

    public void setMarginValueRate(BigDecimal marginValueRate) {
        this.marginValueRate = marginValueRate;
    }

    public BigDecimal getGlobalCapRate() {
        return this.globalCapRate;
    }

    public void setGlobalCapRate(BigDecimal globalCapRate) {
        this.globalCapRate = globalCapRate;
    }

    public BigDecimal getGlobalFloorRate() {
        return this.globalFloorRate;
    }

    public void setGlobalFloorRate(BigDecimal globalFloorRate) {
        this.globalFloorRate = globalFloorRate;
    }

    public BigDecimal getInterestAmount() {
        return this.interestAmount;
    }

    public void setInterestAmount(BigDecimal interestAmount) {
        this.interestAmount = interestAmount;
    }

    public BigDecimal getInterestAdjustedAmount() {
        return this.interestAdjustedAmount;
    }

    public void setInterestAdjustedAmount(BigDecimal interestAdjustedAmount) {
        this.interestAdjustedAmount = interestAdjustedAmount;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getOriginId() {
        return this.originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public Long getRenewalCycleId() {
        return this.renewalCycleId;
    }

    public void setRenewalCycleId(Long renewalCycleId) {
        this.renewalCycleId = renewalCycleId;
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

    public List<ThirdPartyInterestCycleWrapper> getThirdpartyInterestCycleList() {
        return this.thirdpartyInterestCycleList;
    }

    public void setThirdpartyInterestCycleList(List<ThirdPartyInterestCycleWrapper> thirdpartyInterestCycleList) {
        this.thirdpartyInterestCycleList = thirdpartyInterestCycleList;
    }

    public BigDecimal getBalanceAmount() {
        return this.balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public String getTransactionExternalId() {
        return this.transactionExternalId;
    }

    public void setTransactionExternalId(String transactionExternalId) {
        this.transactionExternalId = transactionExternalId;
    }

    public String getTransactionTypeCode() {
        return this.transactionTypeCode;
    }

    public void setTransactionTypeCode(String transactionTypeCode) {
        this.transactionTypeCode = transactionTypeCode;
    }

    public List<InterestCycleDetailsImpl> getInterestCycleDetails() {
        return this.interestCycleDetailsList;
    }

    public void setInterestCycleDetails(List<InterestCycleDetailsImpl> interestCycleDetails) {
        this.interestCycleDetailsList = interestCycleDetails;
    }

    public String getToRecalculate() {
        return this.toRecalculate;
    }

    public void setToRecalculate(String toRecalculate) {
        this.toRecalculate = toRecalculate;
    }

}
