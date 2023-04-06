package com.linedata.lsq.model.wrappers.drawdownRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.linedata.ekip.std.services.capital.entity.CapitalFinancialSchedule;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CapitalFinancialScheduleWrapper {

    @JsonIgnore
    private CapitalFinancialSchedule capitalFinancialSchedule;

    private String version;
    private String statusCode;
    private Long drawdownId;
    private Date paymentDate;
    private String transactionTypeCode;
    private BigDecimal capitalAmount;
    private BigDecimal balancePrincipalAmt;
    private BigDecimal sumPrincipalReimbursedAmt;
    private Long transactionId;
    private Long cancelTransactionId;
    private String effectTypeCode;
    private BigDecimal balanceAmount;
    private List<ThirdpartyCapitalScheduleWrapper> thirdpartyCapitalScheduleList;
    private boolean flagDelete;
    private boolean flagUpdate;
    private boolean flagInsert;

    public CapitalFinancialScheduleWrapper() {
    }

    public CapitalFinancialScheduleWrapper(CapitalFinancialSchedule capitalFinancialSchedule) {

        this.capitalFinancialSchedule = capitalFinancialSchedule;

        this.version = capitalFinancialSchedule.getVersion();
        this.statusCode = capitalFinancialSchedule.getStatusCode();
        this.drawdownId = capitalFinancialSchedule.getDrawdownId();
        this.paymentDate = capitalFinancialSchedule.getPaymentDate();
        this.transactionTypeCode = capitalFinancialSchedule.getTransactionTypeCode();
        this.capitalAmount = capitalFinancialSchedule.getCapitalAmount();
        this.balancePrincipalAmt = capitalFinancialSchedule.getBalancePrincipalAmt();
        this.sumPrincipalReimbursedAmt = capitalFinancialSchedule.getSumPrincipalReimbursedAmt();
        this.transactionId = capitalFinancialSchedule.getTransactionId();
        this.cancelTransactionId = capitalFinancialSchedule.getCancelTransactionId();
        this.effectTypeCode = capitalFinancialSchedule.getEffectTypeCode();
        this.balanceAmount = capitalFinancialSchedule.getBalanceAmount();
        if (capitalFinancialSchedule.getThirdpartyCapitalScheduleList() != null)
            this.thirdpartyCapitalScheduleList = capitalFinancialSchedule.getThirdpartyCapitalScheduleList().parallelStream().map(ThirdpartyCapitalScheduleWrapper::new).collect(Collectors.toList());
        this.flagDelete = capitalFinancialSchedule.isFlagDelete();
        this.flagUpdate = capitalFinancialSchedule.isFlagUpdate();
        this.flagInsert = capitalFinancialSchedule.isFlagInsert();
    }

    public CapitalFinancialSchedule getCapitalFinancialSchedule() {
        return capitalFinancialSchedule;
    }

    public void setCapitalFinancialSchedule(CapitalFinancialSchedule capitalFinancialSchedule) {
        this.capitalFinancialSchedule = capitalFinancialSchedule;
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

    public Date getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getTransactionTypeCode() {
        return this.transactionTypeCode;
    }

    public void setTransactionTypeCode(String transactionTypeCode) {
        this.transactionTypeCode = transactionTypeCode;
    }

    public BigDecimal getCapitalAmount() {
        return this.capitalAmount;
    }

    public void setCapitalAmount(BigDecimal capitalAmount) {
        this.capitalAmount = capitalAmount;
    }

    public BigDecimal getBalancePrincipalAmt() {
        return this.balancePrincipalAmt;
    }

    public void setBalancePrincipalAmt(BigDecimal balancePrincipalAmt) {
        this.balancePrincipalAmt = balancePrincipalAmt;
    }

    public BigDecimal getSumPrincipalReimbursedAmt() {
        return this.sumPrincipalReimbursedAmt;
    }

    public void setSumPrincipalReimbursedAmt(BigDecimal sumPrincipalReimbursedAmt) {
        this.sumPrincipalReimbursedAmt = sumPrincipalReimbursedAmt;
    }

    public List<ThirdpartyCapitalScheduleWrapper> getThirdpartyCapitalScheduleList() {
        return this.thirdpartyCapitalScheduleList;
    }

    public void setThirdpartyCapitalScheduleList(List<ThirdpartyCapitalScheduleWrapper> thirdpartyCapitalScheduleList) {
        this.thirdpartyCapitalScheduleList = thirdpartyCapitalScheduleList;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getCancelTransactionId() {
        return this.cancelTransactionId;
    }

    public void setCancelTransactionId(Long cancelTransactionId) {
        this.cancelTransactionId = cancelTransactionId;
    }

    public BigDecimal getBalanceAmount() {
        return this.balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
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

    public String getEffectTypeCode() {
        return this.effectTypeCode;
    }

    public void setEffectTypeCode(String effectTypeCode) {
        this.effectTypeCode = effectTypeCode;
    }

}
