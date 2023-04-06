package com.linedata.lsq.model.wrappers.drawdownRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.linedata.ekip.std.services.capital.entity.ThirdpartyCapitalSchedule;
import com.linedata.ekip.std.services.capital.entity.impl.ThirdpartyScheduleDetailImpl;
import com.linedata.ekip.std.services.capitalschedule.entity.impl.PortfolioCapitalScheduleImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ThirdpartyCapitalScheduleWrapper {

    @JsonIgnore
    private ThirdpartyCapitalSchedule thirdpartyCapitalSchedule;

    private String version;
    private String statusCode;
    private Long capitalFinancialScheduleId;
    private Long thirdpartyId;
    private String roleCode;
    private BigDecimal capitalAmount;
    private BigDecimal sumPrincipalReimbursedAmt;
    private BigDecimal balancePrincipalAmt;
    private BigDecimal capitalAdjustedAmount;
    private List<ThirdpartyScheduleDetailImpl> thirdPartyScheduleDetailList;
    private List<PortfolioCapitalScheduleImpl> portfolioCapitalScheduleList;
    private boolean flagUpdate;
    private boolean flagInsert;
    private boolean flagDelete;

    public ThirdpartyCapitalScheduleWrapper() {
    }

    public ThirdpartyCapitalScheduleWrapper(ThirdpartyCapitalSchedule thirdpartyCapitalSchedule) {
        this.thirdpartyCapitalSchedule = thirdpartyCapitalSchedule;

        this.version = thirdpartyCapitalSchedule.getVersion();
        this.statusCode = thirdpartyCapitalSchedule.getStatusCode();
        this.capitalFinancialScheduleId = thirdpartyCapitalSchedule.getCapitalFinancialScheduleId();
        this.thirdpartyId = thirdpartyCapitalSchedule.getThirdpartyId();
        this.roleCode = thirdpartyCapitalSchedule.getRoleCode();
        this.capitalAmount = thirdpartyCapitalSchedule.getCapitalAmount();
        this.sumPrincipalReimbursedAmt = thirdpartyCapitalSchedule.getSumPrincipalReimbursedAmt();
        this.balancePrincipalAmt = thirdpartyCapitalSchedule.getBalancePrincipalAmt();
        this.capitalAdjustedAmount = thirdpartyCapitalSchedule.getCapitalAdjustedAmount();
        if (thirdpartyCapitalSchedule.getThirdPartyScheduleDetailList() != null)
            this.thirdPartyScheduleDetailList = thirdpartyCapitalSchedule.getThirdPartyScheduleDetailList().parallelStream().map(thirdpartyScheduleDetail -> ((ThirdpartyScheduleDetailImpl) thirdpartyScheduleDetail)).collect(Collectors.toList());
        if (thirdpartyCapitalSchedule.getPortfolioCapitalScheduleList() != null)
            this.portfolioCapitalScheduleList = thirdpartyCapitalSchedule.getPortfolioCapitalScheduleList().parallelStream().map(portfolioCapitalSchedule -> ((PortfolioCapitalScheduleImpl) portfolioCapitalSchedule)).collect(Collectors.toList());
        this.flagUpdate = thirdpartyCapitalSchedule.isFlagUpdate();
        this.flagInsert = thirdpartyCapitalSchedule.isFlagInsert();
        this.flagDelete = thirdpartyCapitalSchedule.isFlagDelete();
    }

    public ThirdpartyCapitalSchedule getThirdpartyCapitalSchedule() {
        return thirdpartyCapitalSchedule;
    }

    public void setThirdpartyCapitalSchedule(ThirdpartyCapitalSchedule thirdpartyCapitalSchedule) {
        this.thirdpartyCapitalSchedule = thirdpartyCapitalSchedule;
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

    public Long getCapitalFinancialScheduleId() {
        return this.capitalFinancialScheduleId;
    }

    public void setCapitalFinancialScheduleId(Long capitalFinancialScheduleId) {
        this.capitalFinancialScheduleId = capitalFinancialScheduleId;
    }

    public Long getThirdpartyId() {
        return this.thirdpartyId;
    }

    public void setThirdpartyId(Long thirdpartyId) {
        this.thirdpartyId = thirdpartyId;
    }

    public String getRoleCode() {
        return this.roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public BigDecimal getCapitalAmount() {
        return this.capitalAmount;
    }

    public void setCapitalAmount(BigDecimal capitalAmount) {
        this.capitalAmount = capitalAmount;
    }

    public BigDecimal getSumPrincipalReimbursedAmt() {
        return this.sumPrincipalReimbursedAmt;
    }

    public void setSumPrincipalReimbursedAmt(BigDecimal sumPrincipalReimbursedAmt) {
        this.sumPrincipalReimbursedAmt = sumPrincipalReimbursedAmt;
    }

    public BigDecimal getBalancePrincipalAmt() {
        return this.balancePrincipalAmt;
    }

    public void setBalancePrincipalAmt(BigDecimal balancePrincipalAmt) {
        this.balancePrincipalAmt = balancePrincipalAmt;
    }

    public BigDecimal getCapitalAdjustedAmount() {
        return this.capitalAdjustedAmount;
    }

    public void setCapitalAdjustedAmount(BigDecimal capitalAdjustedAmount) {
        this.capitalAdjustedAmount = capitalAdjustedAmount;
    }

    public List<ThirdpartyScheduleDetailImpl> getThirdPartyScheduleDetailList() {
        return this.thirdPartyScheduleDetailList;
    }

    public void setThirdPartyScheduleDetailList(List<ThirdpartyScheduleDetailImpl> thirdPartyScheduleDetailList) {
        this.thirdPartyScheduleDetailList = thirdPartyScheduleDetailList;
    }

    public List<PortfolioCapitalScheduleImpl> getPortfolioCapitalScheduleList() {
        return this.portfolioCapitalScheduleList;
    }

    public void setPortfolioCapitalScheduleList(List<PortfolioCapitalScheduleImpl> portfolioCapitalScheduleList) {
        this.portfolioCapitalScheduleList = portfolioCapitalScheduleList;
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
}
