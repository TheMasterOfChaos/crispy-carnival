
package com.example.testname.specialClasses;

import java.util.HashMap;
import java.util.Map;

public class Driver {

    private Integer id;
    private Object userId;
    private PassportData passportData;
    private Object kYCControl;
    private Integer companyMadeId;
    private String fullName;
    private String phoneNumber;
    private String contractNumber;
    private String birthDate;
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

    public PassportData getPassportData() {
        return passportData;
    }

    public void setPassportData(PassportData passportData) {
        this.passportData = passportData;
    }

    public Object getKYCControl() {
        return kYCControl;
    }

    public void setKYCControl(Object kYCControl) {
        this.kYCControl = kYCControl;
    }

    public Integer getCompanyMadeId() {
        return companyMadeId;
    }

    public void setCompanyMadeId(Integer companyMadeId) {
        this.companyMadeId = companyMadeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
