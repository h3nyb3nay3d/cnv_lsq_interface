package com.linedata.lsq.model.wrappers.dealRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.linedata.ekip.party.management.address.entity.Address;
import com.linedata.ekip.party.management.party.entity.Party;
import com.linedata.ekip.std.services.contact.entity.impl.ContactImpl;
import com.linedata.ekip.std.services.deal.entity.DealThirdParty;
import com.linedata.ekip.std.services.remittanceinstructions.entity.impl.RemittanceInstructionsImpl;

import java.util.List;

public class DealThirdPartyWrapper {

    @JsonIgnore
    private DealThirdParty dealThirdParty;

    @JsonIgnore
    private Party party;

    @JsonIgnore
    private Address address;

    private String roleCode;
    private String partyName;
    private Long thirdpartyId;
    private boolean flagDelete;
    private boolean flagUpdate;
    private boolean flagInsert;
    private String mainFlag;
    private Long dealVersionId;
    private String tiers;
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
    public DealThirdPartyWrapper() {
    }

    public DealThirdPartyWrapper(DealThirdParty dealThirdParty) {
        this.dealThirdParty = dealThirdParty;
        this.roleCode = dealThirdParty.getRoleCode();
        this.partyName = dealThirdParty.getPartyName();
        this.thirdpartyId = dealThirdParty.getThirdpartyId();
        this.flagDelete = dealThirdParty.isFlagDelete();
        this.flagUpdate = dealThirdParty.isFlagUpdate();
        this.flagInsert = dealThirdParty.isFlagInsert();
        this.mainFlag = dealThirdParty.getMainFlag();
        this.dealVersionId = dealThirdParty.getThirdpartyId();
        this.tiers = dealThirdParty.getTiers();
    }

    public DealThirdParty getDealThirdParty() {
        return dealThirdParty;
    }

    public void setDealThirdParty(DealThirdParty dealThirdParty) {
        this.dealThirdParty = dealThirdParty;
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

    public String getRoleCode() {
        return this.roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Long getThirdpartyId() {
        return this.thirdpartyId;
    }

    public void setThirdpartyId(Long thirdpartyId) {
        this.thirdpartyId = thirdpartyId;
    }

    public String getPartyName() {
        return this.partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getMainFlag() {
        return this.mainFlag;
    }

    public void setMainFlag(String mainFlag) {
        this.mainFlag = mainFlag;
    }

    public Long getDealVersionId() {
        return this.dealVersionId;
    }

    public void setDealVersionId(Long dealVersionId) {
        this.dealVersionId = dealVersionId;
    }

    public String getTiers() {
        return this.tiers;
    }

    public void setTiers(String tiers) {
        this.tiers = tiers;
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
