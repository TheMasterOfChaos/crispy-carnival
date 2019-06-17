
package com.galichfactory.souzgruz.specialClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KYCControl {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("company_made_id")
    @Expose
    private Integer companyMadeId;
    @SerializedName("police_registration_date")
    @Expose
    private Object policeRegistrationDate;
    @SerializedName("accidents")
    @Expose
    private Boolean accidents;
    @SerializedName("manhunt")
    @Expose
    private Boolean manhunt;
    @SerializedName("limitations")
    @Expose
    private Boolean limitations;
    @SerializedName("OSAGO_data")
    @Expose
    private String oSAGOData;
    @SerializedName("pledge")
    @Expose
    private Object pledge;
    @SerializedName("true_passport")
    @Expose
    private Boolean truePassport;
    @SerializedName("criminal_records")
    @Expose
    private Boolean criminalRecords;
    @SerializedName("debts")
    @Expose
    private Object debts;
    @SerializedName("FSSP")
    @Expose
    private String fSSP;
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

    public Object getPoliceRegistrationDate() {
        return policeRegistrationDate;
    }

    public void setPoliceRegistrationDate(Object policeRegistrationDate) {
        this.policeRegistrationDate = policeRegistrationDate;
    }

    public Boolean getAccidents() {
        return accidents;
    }

    public void setAccidents(Boolean accidents) {
        this.accidents = accidents;
    }

    public Boolean getManhunt() {
        return manhunt;
    }

    public void setManhunt(Boolean manhunt) {
        this.manhunt = manhunt;
    }

    public Boolean getLimitations() {
        return limitations;
    }

    public void setLimitations(Boolean limitations) {
        this.limitations = limitations;
    }

    public String getOSAGOData() {
        return oSAGOData;
    }

    public void setOSAGOData(String oSAGOData) {
        this.oSAGOData = oSAGOData;
    }

    public Object getPledge() {
        return pledge;
    }

    public void setPledge(Object pledge) {
        this.pledge = pledge;
    }

    public Boolean getTruePassport() {
        return truePassport;
    }

    public void setTruePassport(Boolean truePassport) {
        this.truePassport = truePassport;
    }

    public Boolean getCriminalRecords() {
        return criminalRecords;
    }

    public void setCriminalRecords(Boolean criminalRecords) {
        this.criminalRecords = criminalRecords;
    }

    public Object getDebts() {
        return debts;
    }

    public void setDebts(Object debts) {
        this.debts = debts;
    }

    public String getFSSP() {
        return fSSP;
    }

    public void setFSSP(String fSSP) {
        this.fSSP = fSSP;
    }

    public Boolean getWorkAccess() {
        return workAccess;
    }

    public void setWorkAccess(Boolean workAccess) {
        this.workAccess = workAccess;
    }

}
