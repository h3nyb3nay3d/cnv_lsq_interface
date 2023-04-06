package com.linedata.lsq.model.wrappers.feeRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.linedata.ekip.std.services.fee.entity.ThirdPartyFeeSchedule;
import com.linedata.ekip.std.services.fee.entity.impl.PortfolioFeeScheduleImpl;
import com.linedata.ekip.std.services.fee.entity.impl.ThirdPartyFeeScheduleDetImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ThirdPartyFeeScheduleWrapper {

    @JsonIgnore
    private ThirdPartyFeeSchedule thirdPartyFeeSchedule;

    private String externalId;
    private String version;
    private String statusCode;
    private Long thirdpartyId;
    private Long feeScheduleId;
    private String roleCode;
    private Long hostbankId;
    private BigDecimal netAmount;
    private BigDecimal adjustAmount;
    private List<PortfolioFeeScheduleImpl> portfolioFeeScheduleList;
    private List<ThirdPartyFeeScheduleDetImpl> thirdPartyFeeScheduleDetList;
    private boolean flagDelete;
    private boolean flagUpdate;
    private boolean flagInsert;

    public ThirdPartyFeeScheduleWrapper() {
    }


    public ThirdPartyFeeScheduleWrapper(ThirdPartyFeeSchedule thirdPartyFeeSchedule) {
        this.thirdPartyFeeSchedule = thirdPartyFeeSchedule;

        this.externalId = thirdPartyFeeSchedule.getExternalId();
        this.version = thirdPartyFeeSchedule.getVersion();
        this.statusCode = thirdPartyFeeSchedule.getStatusCode();
        this.thirdpartyId = thirdPartyFeeSchedule.getThirdpartyId();
        this.feeScheduleId = thirdPartyFeeSchedule.getFeeScheduleId();
        this.roleCode = thirdPartyFeeSchedule.getRoleCode();
        this.hostbankId = thirdPartyFeeSchedule.getHostbankId();
        this.netAmount = thirdPartyFeeSchedule.getNetAmount();
        this.adjustAmount = thirdPartyFeeSchedule.getAdjustAmount();

        if (thirdPartyFeeSchedule.getPortfolioFeeScheduleList() != null)
            this.portfolioFeeScheduleList = thirdPartyFeeSchedule.getPortfolioFeeScheduleList().parallelStream().map(portfolioFeeSchedule -> ((PortfolioFeeScheduleImpl) portfolioFeeSchedule)).collect(Collectors.toList());
        if (thirdPartyFeeSchedule.getThirdPartyFeeScheduleDetList() != null)
            this.thirdPartyFeeScheduleDetList = thirdPartyFeeSchedule.getThirdPartyFeeScheduleDetList().parallelStream().map(thirdPartyFeeScheduleDet -> ((ThirdPartyFeeScheduleDetImpl) thirdPartyFeeScheduleDet)).collect(Collectors.toList());

        this.flagDelete = thirdPartyFeeSchedule.isFlagDelete();
        this.flagUpdate = thirdPartyFeeSchedule.isFlagUpdate();
        this.flagInsert = thirdPartyFeeSchedule.isFlagInsert();
    }

    public ThirdPartyFeeSchedule getThirdPartyFeeSchedule() {
        return thirdPartyFeeSchedule;
    }

    public void setThirdPartyFeeSchedule(ThirdPartyFeeSchedule thirdPartyFeeSchedule) {
        this.thirdPartyFeeSchedule = thirdPartyFeeSchedule;
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

    public Long getThirdpartyId() {
        return this.thirdpartyId;
    }

    public void setThirdpartyId(Long thirdpartyId) {
        this.thirdpartyId = thirdpartyId;
    }

    public Long getFeeScheduleId() {
        return this.feeScheduleId;
    }

    public void setFeeScheduleId(Long feeScheduleId) {
        this.feeScheduleId = feeScheduleId;
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

    public BigDecimal getNetAmount() {
        return this.netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
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

    public BigDecimal getAdjustAmount() {
        return this.adjustAmount;
    }

    public void setAdjustAmount(BigDecimal adjustAmount) {
        this.adjustAmount = adjustAmount;
    }

    public List<PortfolioFeeScheduleImpl> getPortfolioFeeScheduleList() {
        return this.portfolioFeeScheduleList;
    }

    public void setPortfolioFeeScheduleList(List<PortfolioFeeScheduleImpl> portfolioFeeScheduleList) {
        this.portfolioFeeScheduleList = portfolioFeeScheduleList;
    }

    public List<ThirdPartyFeeScheduleDetImpl> getThirdPartyFeeScheduleDetList() {
        return this.thirdPartyFeeScheduleDetList;
    }

    public void setThirdPartyFeeScheduleDetList(List<ThirdPartyFeeScheduleDetImpl> thirdPartyFeeScheduleDetList) {
        this.thirdPartyFeeScheduleDetList = thirdPartyFeeScheduleDetList;
    }

    @Override
    public String toString() {
        return "ThirdPartyFeeScheduleDetailsMapper{" +
                "externalId='" + externalId + '\'' +
                ", version='" + version + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", thirdpartyId=" + thirdpartyId +
                ", feeScheduleId=" + feeScheduleId +
                ", roleCode='" + roleCode + '\'' +
                ", hostbankId=" + hostbankId +
                ", netAmount=" + netAmount +
                ", adjustAmount=" + adjustAmount +
                ", portfolioFeeScheduleList=" + portfolioFeeScheduleList +
                ", thirdPartyFeeScheduleDetList=" + thirdPartyFeeScheduleDetList +
                ", flagDelete=" + flagDelete +
                ", flagUpdate=" + flagUpdate +
                ", flagInsert=" + flagInsert +
                '}';
    }
}
