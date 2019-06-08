
package com.example.testname.specialClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("company_made_id")
    @Expose
    private Integer companyMadeId;
    @SerializedName("breakages")
    @Expose
    private Integer breakages;
    @SerializedName("rudeness")
    @Expose
    private Integer rudeness;
    @SerializedName("contract_disregards")
    @Expose
    private Integer contractDisregards;
    @SerializedName("other")
    @Expose
    private Integer other;
    @SerializedName("work_access")
    @Expose
    private Boolean workAccess;

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

    public Integer getBreakages() {
        return breakages;
    }

    public void setBreakages(Integer breakages) {
        this.breakages = breakages;
    }

    public Integer getRudeness() {
        return rudeness;
    }

    public void setRudeness(Integer rudeness) {
        this.rudeness = rudeness;
    }

    public Integer getContractDisregards() {
        return contractDisregards;
    }

    public void setContractDisregards(Integer contractDisregards) {
        this.contractDisregards = contractDisregards;
    }

    public Integer getOther() {
        return other;
    }

    public void setOther(Integer other) {
        this.other = other;
    }

    public Boolean getWorkAccess() {
        return workAccess;
    }

    public void setWorkAccess(Boolean workAccess) {
        this.workAccess = workAccess;
    }

}
