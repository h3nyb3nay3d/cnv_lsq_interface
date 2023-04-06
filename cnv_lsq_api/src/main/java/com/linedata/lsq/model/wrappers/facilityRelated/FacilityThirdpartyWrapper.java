package com.linedata.lsq.model.wrappers.facilityRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.linedata.ekip.party.management.address.entity.Address;
import com.linedata.ekip.party.management.party.entity.Party;
import com.linedata.ekip.std.services.contact.entity.impl.ContactImpl;
import com.linedata.ekip.std.services.facility.entity.FacilityThirdparty;
import com.linedata.ekip.std.services.remittanceinstructions.entity.impl.RemittanceInstructionsImpl;

import java.util.List;

public class FacilityThirdpartyWrapper {

    @JsonIgnore
    private FacilityThirdparty facilityThirdparty;
    @JsonIgnore
    private Party party;
    @JsonIgnore
    private Address address;

    private String statusCode;
    private String roleCode;
    private String mainFlag;
    private String partyName;
    private Long thirdpartyId;
    private boolean isSelected;
    private boolean flagInsert = false;
    private boolean flagUpdate = false;
    private boolean flagDelete = false;
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

    public FacilityThirdpartyWrapper() {
    }

    public FacilityThirdpartyWrapper(FacilityThirdparty facilityThirdparty) {
        this.facilityThirdparty = facilityThirdparty;

        this.statusCode = facilityThirdparty.getStatusCode();
        this.roleCode = facilityThirdparty.getRoleCode();
        this.mainFlag = facilityThirdparty.getMainFlag();
        this.partyName = facilityThirdparty.getPartyName();
        this.thirdpartyId = facilityThirdparty.getThirdpartyId();
        this.isSelected = facilityThirdparty.isSelected();
    }

    public FacilityThirdparty getFacilityThirdparty() {
        return facilityThirdparty;
    }

    public void setFacilityThirdparty(FacilityThirdparty facilityThirdparty) {
        this.facilityThirdparty = facilityThirdparty;
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

    public String getRoleCode() {
        return this.roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getMainFlag() {
        return this.mainFlag;
    }

    public void setMainFlag(String mainFlag) {
        this.mainFlag = mainFlag;
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

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public boolean isFlagInsert() {
        return this.flagInsert;
    }

    public void setFlagInsert(boolean insertFlag) {
        this.flagInsert = insertFlag;
    }

    public boolean isFlagUpdate() {
        return this.flagUpdate;
    }

    public void setFlagUpdate(boolean updateFlag) {
        this.flagUpdate = updateFlag;
    }

    public boolean isFlagDelete() {
        return this.flagDelete;
    }

    public void setFlagDelete(boolean deleteFlag) {
        this.flagDelete = deleteFlag;
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
