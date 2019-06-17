
package com.galichfactory.souzgruz.specialClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PassportData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("company_made_id")
    @Expose
    private Integer companyMadeId;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("reception_info")
    @Expose
    private String receptionInfo;
    @SerializedName("registration_address")
    @Expose
    private String registrationAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyMadeId() {
        return companyMadeId;
    }

    public void setCompanyMadeId(Integer companyMadeId) {
        this.companyMadeId = companyMadeId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getReceptionInfo() {
        return receptionInfo;
    }

    public void setReceptionInfo(String receptionInfo) {
        this.receptionInfo = receptionInfo;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

}
