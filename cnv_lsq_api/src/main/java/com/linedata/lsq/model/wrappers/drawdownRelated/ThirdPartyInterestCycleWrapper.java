package com.linedata.lsq.model.wrappers.drawdownRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.linedata.ekip.std.services.interest.entity.ThirdPartyInterestCycle;
import com.linedata.ekip.std.services.interest.entity.impl.PortfolioInterestScheduleImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ThirdPartyInterestCycleWrapper {

    @JsonIgnore
    private ThirdPartyInterestCycle thirdPartyInterestCycle;

    private String version;
    private String statusCode;
    private Long thirdpartyId;
    private String roleCode;
    private Long hostbankId;
    private Long interestCycleId;
    private BigDecimal interestAmount;
    private BigDecimal interestAdjustedAmount;
    private BigDecimal skimAmount;
    private BigDecimal skimAdjustedAmount;
    private Long mvtId;
    private List<PortfolioInterestScheduleImpl> portfolioInterestScheduleList;
    private boolean flagDelete;
    private boolean flagUpdate;
    private boolean flagInsert;

    public ThirdPartyInterestCycleWrapper() {
    }

    public ThirdPartyInterestCycleWrapper(ThirdPartyInterestCycle thirdPartyInterestCycle) {

        this.thirdPartyInterestCycle = thirdPartyInterestCycle;

        this.version = thirdPartyInterestCycle.getVersion();
        this.statusCode = thirdPartyInterestCycle.getStatusCode();
        this.thirdpartyId = thirdPartyInterestCycle.getThirdpartyId();
        this.roleCode = thirdPartyInterestCycle.getRoleCode();
        this.hostbankId = thirdPartyInterestCycle.getHostbankId();
        this.interestCycleId = thirdPartyInterestCycle.getInterestCycleId();
        this.interestAmount = thirdPartyInterestCycle.getInterestAmount();
        this.interestAdjustedAmount = thirdPartyInterestCycle.getInterestAdjustedAmount();
        this.skimAmount = thirdPartyInterestCycle.getSkimAmount();
        this.skimAdjustedAmount = thirdPartyInterestCycle.getSkimAdjustedAmount();
        this.mvtId = thirdPartyInterestCycle.getMvtId();
        if (thirdPartyInterestCycle.getPortfolioInterestSchedule() != null)
            this.portfolioInterestScheduleList = thirdPartyInterestCycle.getPortfolioInterestSchedule().parallelStream().map(portfolioInterestSchedule -> ((PortfolioInterestScheduleImpl) portfolioInterestSchedule)).collect(Collectors.toList());
        this.flagDelete = thirdPartyInterestCycle.isFlagDelete();
        this.flagUpdate = thirdPartyInterestCycle.isFlagUpdate();
        this.flagInsert = thirdPartyInterestCycle.isFlagInsert();
    }

    public ThirdPartyInterestCycle getThirdPartyInterestCycle() {
        return thirdPartyInterestCycle;
    }

    public void setThirdPartyInterestCycle(ThirdPartyInterestCycle thirdPartyInterestCycle) {
        this.thirdPartyInterestCycle = thirdPartyInterestCycle;
    }

    public List<PortfolioInterestScheduleImpl> getPortfolioInterestScheduleList() {
        return portfolioInterestScheduleList;
    }

    public void setPortfolioInterestScheduleList(List<PortfolioInterestScheduleImpl> portfolioInterestScheduleList) {
        this.portfolioInterestScheduleList = portfolioInterestScheduleList;
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

    public Long getHostbankId() {
        return this.hostbankId;
    }

    public void setHostbankId(Long hostbankId) {
        this.hostbankId = hostbankId;
    }

    public Long getInterestCycleId() {
        return this.interestCycleId;
    }

    public void setInterestCycleId(Long interestCycleId) {
        this.interestCycleId = interestCycleId;
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

    public BigDecimal getSkimAmount() {
        return this.skimAmount;
    }

    public void setSkimAmount(BigDecimal skimAmount) {
        this.skimAmount = skimAmount;
    }

    public BigDecimal getSkimAdjustedAmount() {
        return this.skimAdjustedAmount;
    }

    public void setSkimAdjustedAmount(BigDecimal skimAdjustedAmount) {
        this.skimAdjustedAmount = skimAdjustedAmount;
    }

    public Long getMvtId() {
        return this.mvtId;
    }

    public void setMvtId(Long mvtId) {
        this.mvtId = mvtId;
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

    public List<PortfolioInterestScheduleImpl> getPortfolioInterestSchedule() {
        return this.portfolioInterestScheduleList;
    }

    public void setPortfolioInterestSchedule(List<PortfolioInterestScheduleImpl> portfolioInterestSchedule) {
        this.portfolioInterestScheduleList = portfolioInterestSchedule;
    }

}
