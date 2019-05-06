
package com.example.testname.specialClasses;

import java.util.HashMap;
import java.util.Map;

public class TariffValueCustomer {

    private Integer id;
    private Integer companyMadeId;
    private Integer hours;
    private Boolean isAdditional;
    private String cost;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Boolean getIsAdditional() {
        return isAdditional;
    }

    public void setIsAdditional(Boolean isAdditional) {
        this.isAdditional = isAdditional;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
