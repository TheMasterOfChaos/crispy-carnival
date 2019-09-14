
package su.szg.driverapp.specialClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TariffValueDeliverer {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("company_made_id")
    @Expose
    private Integer companyMadeId;
    @SerializedName("hours")
    @Expose
    private Integer hours;
    @SerializedName("is_additional")
    @Expose
    private Boolean isAdditional;
    @SerializedName("cost")
    @Expose
    private String cost;

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

}
