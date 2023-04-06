package com.linedata.lsq.model.wrappers.drawdownRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.linedata.ekip.party.management.address.entity.Address;
import com.linedata.ekip.party.management.party.entity.Party;
import com.linedata.ekip.std.services.contact.entity.impl.ContactImpl;
import com.linedata.ekip.std.services.drawdown.entity.DrawdownThirdparty;
import com.linedata.ekip.std.services.remittanceinstructions.entity.impl.RemittanceInstructionsImpl;

import java.math.BigDecimal;
import java.util.List;

public class DrawdownThirdpartyWrapper {

    @JsonIgnore
    private DrawdownThirdparty drawdownThirdparty;
    @JsonIgnore
    private Party party;

    @JsonIgnore
    private Address address;

    private String version;
    private String statusCode;
    private Long drawdownId;
    private Long thirdpartyId;
    private String roleCode;
    private BigDecimal grossSharePc;
    private boolean flagDelete;
    private boolean flagUpdate;
    private boolean flagInsert;
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

    public DrawdownThirdpartyWrapper() {
    }

    public DrawdownThirdpartyWrapper(DrawdownThirdparty drawdownThirdparty) {
        this.drawdownThirdparty = drawdownThirdparty;

        this.version = drawdownThirdparty.getVersion();
        this.statusCode = drawdownThirdparty.getStatusCode();
        this.drawdownId = drawdownThirdparty.getDrawdownId();
        this.thirdpartyId = drawdownThirdparty.getThirdpartyId();
        this.roleCode = drawdownThirdparty.getRoleCode();
        this.grossSharePc = drawdownThirdparty.getGrossSharePc();
        this.flagDelete = drawdownThirdparty.isFlagDelete();
        this.flagUpdate = drawdownThirdparty.isFlagUpdate();
        this.flagInsert = drawdownThirdparty.isFlagInsert();
    }

    public DrawdownThirdparty getDrawdownThirdparty() {
        return drawdownThirdparty;
    }

    public void setDrawdownThirdparty(DrawdownThirdparty drawdownThirdparty) {
        this.drawdownThirdparty = drawdownThirdparty;
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

    public Long getDrawdownId() {
        return this.drawdownId;
    }

    public void setDrawdownId(Long drawdownId) {
        this.drawdownId = drawdownId;
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

    public BigDecimal getGrossSharePc() {
        return this.grossSharePc;
    }

    public void setGrossSharePc(BigDecimal grossSharePc) {
        this.grossSharePc = grossSharePc;
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
