package com.linedata.lsq.model.wrappers.drawdownRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.linedata.ekip.party.management.address.entity.Address;
import com.linedata.ekip.party.management.party.entity.Party;
import com.linedata.ekip.std.services.contact.entity.impl.ContactImpl;
import com.linedata.ekip.std.services.drawdown.entity.DrawdownLender;
import com.linedata.ekip.std.services.remittanceinstructions.entity.impl.RemittanceInstructionsImpl;

import java.math.BigDecimal;
import java.util.List;

public class DrawdownLenderWrapper {

    @JsonIgnore
    private DrawdownLender drawdownLender;

    @JsonIgnore
    private Party party;

    @JsonIgnore
    private Address address;

    private String version;
    private String statusCode;
    private Long lenderId;
    private Long drawdownId;
    private BigDecimal grossShareAmt;
    private BigDecimal grossSharePct;
    private Long transactionId;
    private Long originId;
    private BigDecimal commitmentAmount;
    private BigDecimal availableAmount;
    private boolean flagDelete;
    private boolean flagUpdate;
    private boolean flagInsert;
    private String lenderTypeCode;
    private BigDecimal InitialAmount;
    private String treasuryFlag;
    private BigDecimal netShareAmt;
    private Long hostbankId;
    private String hostbankFlag;
    private String agentFlag;
    private BigDecimal riskMargin;
    private List<ContactImpl> contactList;
    private List<RemittanceInstructionsImpl> remittanceInstructionsList;

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

    public DrawdownLenderWrapper() {
    }

    public DrawdownLenderWrapper(DrawdownLender drawdownLender) {
        this.drawdownLender = drawdownLender;

        this.version = drawdownLender.getVersion();
        this.statusCode = drawdownLender.getStatusCode();
        this.lenderId = drawdownLender.getLenderId();
        this.drawdownId = drawdownLender.getDrawdownId();
        this.grossShareAmt = drawdownLender.getGrossShareAmt();
        this.grossSharePct = drawdownLender.getGrossSharePct();
        this.transactionId = drawdownLender.getTransactionId();
        this.originId = drawdownLender.getOriginId();
        this.commitmentAmount = drawdownLender.getCommitmentAmount();
        this.availableAmount = drawdownLender.getAvailableAmount();
        this.flagDelete = drawdownLender.isFlagDelete();
        this.flagUpdate = drawdownLender.isFlagUpdate();
        this.flagInsert = drawdownLender.isFlagInsert();
        this.lenderTypeCode = drawdownLender.getLenderTypeCode();
        this.InitialAmount = drawdownLender.getInitialAmount();
        this.treasuryFlag = drawdownLender.getTreasuryFlag();
        this.netShareAmt = drawdownLender.getNetShareAmt();
        this.hostbankId = drawdownLender.getHostbankId();
        this.hostbankFlag = drawdownLender.getHostbankFlag();
        this.agentFlag = drawdownLender.getAgentFlag();
        this.riskMargin = drawdownLender.getRiskMargin();
    }

    public DrawdownLender getDrawdownLender() {
        return drawdownLender;
    }

    public void setDrawdownLender(DrawdownLender drawdownLender) {
        this.drawdownLender = drawdownLender;
    }

    public List<ContactImpl> getContactList() {
        return contactList;
    }

    public void setContactList(List<ContactImpl> contactList) {
        this.contactList = contactList;
    }

    public List<RemittanceInstructionsImpl> getRemittanceInstructionsList() {
        return remittanceInstructionsList;
    }

    public void setRemittanceInstructionsList(List<RemittanceInstructionsImpl> remittanceInstructionsList) {
        this.remittanceInstructionsList = remittanceInstructionsList;
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

    public Long getLenderId() {
        return this.lenderId;
    }

    public void setLenderId(Long lenderId) {
        this.lenderId = lenderId;
    }

    public Long getDrawdownId() {
        return this.drawdownId;
    }

    public void setDrawdownId(Long drawdownId) {
        this.drawdownId = drawdownId;
    }

    public BigDecimal getGrossShareAmt() {
        return this.grossShareAmt;
    }

    public void setGrossShareAmt(BigDecimal grossShareAmt) {
        this.grossShareAmt = grossShareAmt;
    }

    public Long getOriginId() {
        return this.originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
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

    public BigDecimal getGrossSharePct() {
        return this.grossSharePct;
    }

    public void setGrossSharePct(BigDecimal grossSharePct) {
        this.grossSharePct = grossSharePct;
    }

    public String getLenderTypeCode() {
        return this.lenderTypeCode;
    }

    public void setLenderTypeCode(String lenderTypeCode) {
        this.lenderTypeCode = lenderTypeCode;
    }

    public BigDecimal getCommitmentAmount() {
        return this.commitmentAmount;
    }

    public void setCommitmentAmount(BigDecimal commitmentAmount) {
        this.commitmentAmount = commitmentAmount;
    }

    public BigDecimal getAvailableAmount() {
        return this.availableAmount;
    }

    public void setAvailableAmount(BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }

    public BigDecimal getInitialAmount() {
        return this.InitialAmount;
    }

    public void setInitialAmount(BigDecimal initialAmount) {
        this.InitialAmount = initialAmount;
    }

    public String getTreasuryFlag() {
        return this.treasuryFlag;
    }

    public void setTreasuryFlag(String treasuryFlag) {
        this.treasuryFlag = treasuryFlag;
    }

    public BigDecimal getNetShareAmt() {
        return this.netShareAmt;
    }

    public void setNetShareAmt(BigDecimal netShareAmt) {
        this.netShareAmt = netShareAmt;
    }

    public Long getHostbankId() {
        return this.hostbankId;
    }

    public void setHostbankId(Long hostbankId) {
        this.hostbankId = hostbankId;
    }

    public String getHostbankFlag() {
        return this.hostbankFlag;
    }

    public void setHostbankFlag(String hostbankFlag) {
        this.hostbankFlag = hostbankFlag;
    }

    public String getAgentFlag() {
        return this.agentFlag;
    }

    public void setAgentFlag(String agentFlag) {
        this.agentFlag = agentFlag;
    }

    public BigDecimal getRiskMargin() {
        return this.riskMargin;
    }

    public void setRiskMargin(BigDecimal riskMargin) {
        this.riskMargin = riskMargin;
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
