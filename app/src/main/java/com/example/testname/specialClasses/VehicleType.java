
package com.example.testname.specialClasses;

import java.util.HashMap;
import java.util.Map;

public class VehicleType {

    private Integer id;
    private Object defaultCargo;
    private Integer companyMadeId;
    private String name;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getDefaultCargo() {
        return defaultCargo;
    }

    public void setDefaultCargo(Object defaultCargo) {
        this.defaultCargo = defaultCargo;
    }

    public Integer getCompanyMadeId() {
        return companyMadeId;
    }

    public void setCompanyMadeId(Integer companyMadeId) {
        this.companyMadeId = companyMadeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
