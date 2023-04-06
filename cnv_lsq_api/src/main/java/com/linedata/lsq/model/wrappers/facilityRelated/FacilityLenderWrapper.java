package com.linedata.lsq.model.wrappers.facilityRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.linedata.ekip.party.management.address.entity.Address;
import com.linedata.ekip.party.management.party.entity.Party;
import com.linedata.ekip.std.services.contact.entity.Contact;
import com.linedata.ekip.std.services.lender.entity.FacilityLender;
import com.linedata.ekip.std.services.lender.entity.impl.FacilityLenderPortfolioImpl;
import com.linedata.ekip.std.services.lender.entity.impl.FacilityLenderRateIndexImpl;
import com.linedata.ekip.std.services.remittanceinstructions.entity.impl.RemittanceInstructionsImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FacilityLenderWrapper {

    @JsonIgnore
    private FacilityLender facilityLender;
    @JsonIgnore
    private Party party;

    @JsonIgnore
    private Address address;

    private String externalId;
    private String statusCode;
    private Long lenderId;
    private Long facilityId;
    private String lenderTypeCode;
    private String description;
    private BigDecimal grossShareAmt;
    private BigDecimal riskMarginRate;
    private Date effectiveDate;
    private Date maturityDate;
    private BigDecimal facilityAmount;
    private Long transactionId;
    private Long originId;
    private BigDecimal newGrossShareAmt;
    private BigDecimal newNetShareAmt;
    private BigDecimal grossSharePc;
    private String hostBankFlag;
    private BigDecimal netShareAmt;
    private boolean flagDelete;
    private boolean flagUpdate;
    private boolean flagInsert;
    private String agentFlag;
    private List<FacilityLenderRateIndexImpl> facilityLenderRateIndexList;
    private List<FacilityLenderPortfolioImpl> facilityLenderPortfolioList;
    private List<RemittanceInstructionsImpl> remittanceInstructionsList;
    private List<Contact> contactList;
    private String treasuryFlag;

    public String fullName;

    public String address1;

    public String countryCode;

    public String postalCode;

    public String town;

    public String city;

    public String fullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String address1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String countryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String postalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String town() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String city() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public FacilityLenderWrapper() {
    }

    public FacilityLenderWrapper(FacilityLender facilityLender) {
        this.facilityLender = facilityLender;

        this.externalId = facilityLender.getExternalId();
        this.statusCode = facilityLender.getStatusCode();
        this.lenderId = facilityLender.getLenderId();
        this.facilityId = facilityLender.getFacilityId();
        this.lenderTypeCode = facilityLender.getLenderTypeCode();
        this.description = facilityLender.getDescription();
        this.grossShareAmt = facilityLender.getGrossShareAmt();
        this.riskMarginRate = facilityLender.getRiskMarginRate();
        this.effectiveDate = facilityLender.getEffectiveDate();
        this.maturityDate = facilityLender.getMaturityDate();
        this.facilityAmount = facilityLender.getFacilityAmount();
        this.transactionId = facilityLender.getTransactionId();
        this.originId = facilityLender.getOriginId();
        this.newGrossShareAmt = facilityLender.getNewGrossShareAmt();
        this.newNetShareAmt = facilityLender.getNewNetShareAmt();
        this.grossSharePc = facilityLender.getGrossSharePc();
        this.hostBankFlag = facilityLender.getHostBankFlag();
        this.netShareAmt = facilityLender.getNetShareAmt();
        this.flagDelete = facilityLender.isFlagDelete();
        this.flagUpdate = facilityLender.isFlagUpdate();
        this.flagInsert = facilityLender.isFlagInsert();
        this.agentFlag = facilityLender.getAgentFlag();

        if (facilityLender.getFacilityLenderRateIndexList() != null)
            this.facilityLenderRateIndexList = facilityLender.getFacilityLenderRateIndexList().parallelStream().map(facilityLenderRateIndex -> ((FacilityLenderRateIndexImpl) facilityLenderRateIndex)).collect(Collectors.toList());
        if (facilityLender.getFacilityLenderPortfolioList() != null)
            this.facilityLenderPortfolioList = facilityLender.getFacilityLenderPortfolioList().parallelStream().map(facilityLenderPortfolio -> ((FacilityLenderPortfolioImpl) facilityLenderPortfolio)).collect(Collectors.toList());
        if (facilityLender.getRemittanceInstructionsList() != null)
            this.remittanceInstructionsList = facilityLender.getRemittanceInstructionsList().parallelStream().map(remittanceInstructions -> ((RemittanceInstructionsImpl) remittanceInstructions)).collect(Collectors.toList());

        this.treasuryFlag = facilityLender.getTreasuryFlag();
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public FacilityLender getFacilityLender() {
        return facilityLender;
    }

    public void setFacilityLender(FacilityLender facilityLender) {
        this.facilityLender = facilityLender;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Long getLenderId() {
        return lenderId;
    }

    public void setLenderId(Long lenderId) {
        this.lenderId = lenderId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public String getLenderTypeCode() {
        return lenderTypeCode;
    }

    public void setLenderTypeCode(String lenderTypeCode) {
        this.lenderTypeCode = lenderTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getGrossShareAmt() {
        return grossShareAmt;
    }

    public void setGrossShareAmt(BigDecimal grossShareAmt) {
        this.grossShareAmt = grossShareAmt;
    }

    public BigDecimal getRiskMarginRate() {
        return riskMarginRate;
    }

    public void setRiskMarginRate(BigDecimal riskMarginRate) {
        this.riskMarginRate = riskMarginRate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public BigDecimal getFacilityAmount() {
        return facilityAmount;
    }

    public void setFacilityAmount(BigDecimal facilityAmount) {
        this.facilityAmount = facilityAmount;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getOriginId() {
        return originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public BigDecimal getNewGrossShareAmt() {
        return newGrossShareAmt;
    }

    public void setNewGrossShareAmt(BigDecimal newGrossShareAmt) {
        this.newGrossShareAmt = newGrossShareAmt;
    }

    public BigDecimal getNewNetShareAmt() {
        return newNetShareAmt;
    }

    public void setNewNetShareAmt(BigDecimal newNetShareAmt) {
        this.newNetShareAmt = newNetShareAmt;
    }

    public BigDecimal getGrossSharePc() {
        return grossSharePc;
    }

    public void setGrossSharePc(BigDecimal grossSharePc) {
        this.grossSharePc = grossSharePc;
    }

    public String getHostBankFlag() {
        return hostBankFlag;
    }

    public void setHostBankFlag(String hostBankFlag) {
        this.hostBankFlag = hostBankFlag;
    }

    public BigDecimal getNetShareAmt() {
        return netShareAmt;
    }

    public void setNetShareAmt(BigDecimal netShareAmt) {
        this.netShareAmt = netShareAmt;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public boolean isFlagUpdate() {
        return flagUpdate;
    }

    public void setFlagUpdate(boolean flagUpdate) {
        this.flagUpdate = flagUpdate;
    }

    public boolean isFlagInsert() {
        return flagInsert;
    }

    public void setFlagInsert(boolean flagInsert) {
        this.flagInsert = flagInsert;
    }

    public String getAgentFlag() {
        return agentFlag;
    }

    public void setAgentFlag(String agentFlag) {
        this.agentFlag = agentFlag;
    }

    public List<FacilityLenderRateIndexImpl> getFacilityLenderRateIndexList() {
        return facilityLenderRateIndexList;
    }

    public void setFacilityLenderRateIndexList(List<FacilityLenderRateIndexImpl> facilityLenderRateIndexList) {
        this.facilityLenderRateIndexList = facilityLenderRateIndexList;
    }

    public List<FacilityLenderPortfolioImpl> getFacilityLenderPortfolioList() {
        return facilityLenderPortfolioList;
    }

    public void setFacilityLenderPortfolioList(List<FacilityLenderPortfolioImpl> facilityLenderPortfolioList) {
        this.facilityLenderPortfolioList = facilityLenderPortfolioList;
    }

    public List<RemittanceInstructionsImpl> getRemittanceInstructionsList() {
        return remittanceInstructionsList;
    }

    public void setRemittanceInstructionsList(List<RemittanceInstructionsImpl> remittanceInstructionsList) {
        this.remittanceInstructionsList = remittanceInstructionsList;
    }


    public String getTreasuryFlag() {
        return treasuryFlag;
    }

    public void setTreasuryFlag(String treasuryFlag) {
        this.treasuryFlag = treasuryFlag;
    }

    @Override
    public String toString() {
        return "FacilityLenderDetailsMapper{" +
                "externalId='" + externalId + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", lenderId=" + lenderId +
                ", facilityId=" + facilityId +
                ", lenderTypeCode='" + lenderTypeCode + '\'' +
                ", description='" + description + '\'' +
                ", grossShareAmt=" + grossShareAmt +
                ", riskMarginRate=" + riskMarginRate +
                ", effectiveDate=" + effectiveDate +
                ", maturityDate=" + maturityDate +
                ", facilityAmount=" + facilityAmount +
                ", transactionId=" + transactionId +
                ", originId=" + originId +
                ", newGrossShareAmt=" + newGrossShareAmt +
                ", newNetShareAmt=" + newNetShareAmt +
                ", grossSharePc=" + grossSharePc +
                ", hostBankFlag='" + hostBankFlag + '\'' +
                ", netShareAmt=" + netShareAmt +
                ", flagDelete=" + flagDelete +
                ", flagUpdate=" + flagUpdate +
                ", flagInsert=" + flagInsert +
                ", agentFlag='" + agentFlag + '\'' +
                ", facilityLenderRateIndexList=" + facilityLenderRateIndexList +
                ", facilityLenderPortfolioList=" + facilityLenderPortfolioList +
                ", remittanceInstructionsList=" + remittanceInstructionsList +
                ", treasuryFlag='" + treasuryFlag + '\'' +
                '}';
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
        this.fullName = party.getFormattedFullName();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        this.address1 = address.getAddress1();
        this.countryCode = address.getCountryCode();
        this.postalCode = address.getPostalCode();
        this.town = address.getTown();
        this.city = address.getCity();
    }
}
