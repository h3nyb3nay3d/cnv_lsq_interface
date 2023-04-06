package com.linedata.lsq.model.wrappers.dealRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.linedata.ekip.party.management.address.entity.Address;
import com.linedata.ekip.party.management.party.entity.Party;
import com.linedata.ekip.std.services.contact.entity.impl.ContactImpl;
import com.linedata.ekip.std.services.lender.entity.DealLender;
import com.linedata.ekip.std.services.remittanceinstructions.entity.impl.RemittanceInstructionsImpl;

import java.math.BigDecimal;
import java.util.List;

public class DealLenderWrapper {

    @JsonIgnore
    private DealLender dealLender;
    @JsonIgnore
    private Address address;
    @JsonIgnore
    private Party party;

    public String fullName;

    public String address1;

    public String countryCode;

    public String postalCode;

    public String town;

    public String city;
    private String statusCode;


    private Long lenderId;
    private String lenderTypeCode;
    private BigDecimal grossShareAmt;
    private BigDecimal grossSharePc;
    private String hostBankFlag;
    private BigDecimal netShareAmt;
    private boolean flagInsert;
    private boolean flagUpdate;
    private boolean flagDelete;
    private String agentFlag;
    private List<ContactImpl> contactList;
    private List<RemittanceInstructionsImpl> remittanceInstructionsList;


    public DealLenderWrapper() {
    }

    public DealLenderWrapper(DealLender dealLender) {
        this.dealLender = dealLender;
        this.statusCode = dealLender.getStatusCode();
        this.lenderId = dealLender.getLenderId();
        this.lenderTypeCode = dealLender.getLenderTypeCode();
        this.grossShareAmt = dealLender.getGrossShareAmt();
        this.grossSharePc = dealLender.getGrossSharePc();
        this.hostBankFlag = dealLender.getHostBankFlag();
        this.netShareAmt = dealLender.getNetShareAmt();
        this.flagInsert = dealLender.isFlagInsert();
        this.flagUpdate = dealLender.isFlagUpdate();
        this.flagDelete = dealLender.isFlagDelete();
        this.agentFlag = dealLender.getAgentFlag();
    }

    public DealLender getDealLender() {
        return dealLender;
    }

    public void setDealLender(DealLender dealLender) {
        this.dealLender = dealLender;
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

    public String getLenderTypeCode() {
        return this.lenderTypeCode;
    }

    public void setLenderTypeCode(String lenderTypeCode) {
        this.lenderTypeCode = lenderTypeCode;
    }

    public BigDecimal getGrossShareAmt() {
        return this.grossShareAmt;
    }

    public void setGrossShareAmt(BigDecimal grossShareAmt) {
        this.grossShareAmt = grossShareAmt;
    }

    public BigDecimal getGrossSharePc() {
        return this.grossSharePc;
    }

    public void setGrossSharePc(BigDecimal grossSharePc) {
        this.grossSharePc = grossSharePc;
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

    public String getHostBankFlag() {
        return this.hostBankFlag;
    }

    public void setHostBankFlag(String hostBankFlag) {
        this.hostBankFlag = hostBankFlag;
    }

    public BigDecimal getNetShareAmt() {
        return this.netShareAmt;
    }

    public void setNetShareAmt(BigDecimal netShareAmt) {
        this.netShareAmt = netShareAmt;
    }

    public String getAgentFlag() {
        return this.agentFlag;
    }

    public void setAgentFlag(String agentFlag) {
        this.agentFlag = agentFlag;
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

    public DealLender dealLender() {
        return dealLender;
    }

    public Address address() {
        return address;
    }

    public Party party() {
        return party;
    }

    public String statusCode() {
        return statusCode;
    }

    public Long lenderId() {
        return lenderId;
    }

    public String lenderTypeCode() {
        return lenderTypeCode;
    }

    public BigDecimal grossShareAmt() {
        return grossShareAmt;
    }

    public BigDecimal grossSharePc() {
        return grossSharePc;
    }

    public String hostBankFlag() {
        return hostBankFlag;
    }

    public BigDecimal netShareAmt() {
        return netShareAmt;
    }

    public boolean flagInsert() {
        return flagInsert;
    }

    public boolean flagUpdate() {
        return flagUpdate;
    }

    public boolean flagDelete() {
        return flagDelete;
    }

    public String agentFlag() {
        return agentFlag;
    }

    public List<ContactImpl> contactList() {
        return contactList;
    }

    public List<RemittanceInstructionsImpl> remittanceInstructionsList() {
        return remittanceInstructionsList;
    }

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




}
