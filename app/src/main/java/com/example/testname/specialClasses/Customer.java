
package com.example.testname.specialClasses;

import java.util.HashMap;
import java.util.Map;

public class Customer {

    private Integer id;
    private Object userId;
    private Object passportData;
    private Integer companyMadeId;
    private String managerComment;
    private Integer taxType;
    private String surname;
    private String name;
    private String lastName;
    private String birthPlace;
    private String birthDate;
    private String pSRNSP;
    private String organisation;
    private String tIN;
    private String pSRN;
    private Integer paymentType;
    private Integer paymentOrder;
    private Integer delay;
    private Integer discount;
    private String contractNumber;
    private String companyAddress;
    private String realAddress;
    private String checkingAccount;
    private String bIC;
    private String iEC;
    private String bankName;
    private String correspondingAccount;
    private String contactName;
    private String phoneNumber;
    private String email;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public Object getPassportData() {
        return passportData;
    }

    public void setPassportData(Object passportData) {
        this.passportData = passportData;
    }

    public Integer getCompanyMadeId() {
        return companyMadeId;
    }

    public void setCompanyMadeId(Integer companyMadeId) {
        this.companyMadeId = companyMadeId;
    }

    public String getManagerComment() {
        return managerComment;
    }

    public void setManagerComment(String managerComment) {
        this.managerComment = managerComment;
    }

    public Integer getTaxType() {
        return taxType;
    }

    public void setTaxType(Integer taxType) {
        this.taxType = taxType;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPSRNSP() {
        return pSRNSP;
    }

    public void setPSRNSP(String pSRNSP) {
        this.pSRNSP = pSRNSP;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getTIN() {
        return tIN;
    }

    public void setTIN(String tIN) {
        this.tIN = tIN;
    }

    public String getPSRN() {
        return pSRN;
    }

    public void setPSRN(String pSRN) {
        this.pSRN = pSRN;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getPaymentOrder() {
        return paymentOrder;
    }

    public void setPaymentOrder(Integer paymentOrder) {
        this.paymentOrder = paymentOrder;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getRealAddress() {
        return realAddress;
    }

    public void setRealAddress(String realAddress) {
        this.realAddress = realAddress;
    }

    public String getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(String checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public String getBIC() {
        return bIC;
    }

    public void setBIC(String bIC) {
        this.bIC = bIC;
    }

    public String getIEC() {
        return iEC;
    }

    public void setIEC(String iEC) {
        this.iEC = iEC;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCorrespondingAccount() {
        return correspondingAccount;
    }

    public void setCorrespondingAccount(String correspondingAccount) {
        this.correspondingAccount = correspondingAccount;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
