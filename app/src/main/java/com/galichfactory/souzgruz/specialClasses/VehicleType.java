
package com.galichfactory.souzgruz.specialClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehicleType {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("default_cargo")
    @Expose
    private Object defaultCargo;
    @SerializedName("company_made_id")
    @Expose
    private Integer companyMadeId;
    @SerializedName("name")
    @Expose
    private String name;

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

}
