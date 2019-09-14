
package su.szg.driverapp.specialClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Point  {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("arrive_date_time")
    @Expose
    private String arriveDateTime;
    @SerializedName("company_made_id")
    @Expose
    private Integer companyMadeId;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArriveDateTime() {
        return arriveDateTime;
    }

    public void setArriveDateTime(String arriveDateTime) {
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

}
