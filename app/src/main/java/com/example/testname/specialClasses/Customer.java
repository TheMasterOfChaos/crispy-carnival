
package com.example.testname.specialClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_id")
    @Expose
    private Object userId;
    @SerializedName("passport_data")
    @Expose
    private Object passportData;
    @SerializedName("company_made_id")
    @Expose
    private Integer companyMadeId;
    @SerializedName("manager_comment")
    @Expose
    private String managerComment;
    @SerializedName("tax_type")
    @Expose
    private Integer taxType;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("birth_place")
    @Expose
    private String birthPlace;
    @SerializedName("birth_date")
    @Expose
    private String birthDate;
    @SerializedName("PSRNSP")
    @Expose
    private String pSRNSP;
    @SerializedName("organisation")
    @Expose
    private String organisation;
    @SerializedName("TIN")
    @Expose
    private String tIN;
    @SerializedName("PSRN")
    @Expose
    private String pSRN;
    @SerializedName("payment_type")
    @Expose
    private Integer paymentType;
    @SerializedName("payment_order")
    @Expose
    private Integer paymentOrder;
    @SerializedName("delay")
    @Expose
    private Integer delay;
    @SerializedName("discount")
    @Expose
    private Integer discount;
    @SerializedName("contract_number")
    @Expose
    private String contractNumber;
    @SerializedName("company_address")
    @Expose
    private String companyAddress;
    @SerializedName("real_address")
    @Expose
    private String realAddress;
    @SerializedName("checking_account")
    @Expose
    private String checkingAccount;
    @SerializedName("BIC")
    @Expose
    private String bIC;
    @SerializedName("IEC")
    @Expose
    private String iEC;
    @SerializedName("bank_name")
    @Expose
    private String bankName;
    @SerializedName("corresponding_account")
    @Expose
    private String correspondingAccount;
    @SerializedName("contact_name")
    @Expose
    private String contactName;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("email")
    @Expose
    private String email;

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

}
