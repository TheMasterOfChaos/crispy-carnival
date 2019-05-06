
package com.example.testnae.specialClasses;

import java.util.HashMap;
import java.util.Map;

public class Point {

    private Integer id;
    private Object arriveDateTime;
    private Integer companyMadeId;
    private String location;
    private String phoneNumber;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getArriveDateTime() {
        return arriveDateTime;
    }

    public void setArriveDateTime(Object arriveDateTime) {
        this.arriveDateTime = arriveDateTime;
    }

    public Integer getCompanyMadeId() {
        return companyMadeId;
    }

    public void setCompanyMadeId(Integer companyMadeId) {
        this.companyMadeId = companyMadeId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
