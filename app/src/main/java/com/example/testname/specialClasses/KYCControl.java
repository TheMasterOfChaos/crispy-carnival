
package com.example.testname.specialClasses;

import java.util.HashMap;
import java.util.Map;

public class KYCControl {

    private Integer id;
    private Integer companyMadeId;
    private Object policeRegistrationDate;
    private Boolean accidents;
    private Boolean manhunt;
    private Boolean limitations;
    private String oSAGOData;
    private Object pledge;
    private Boolean truePassport;
    private Boolean criminalRecords;
    private Object debts;
    private String fSSP;
    private Boolean workAccess;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
