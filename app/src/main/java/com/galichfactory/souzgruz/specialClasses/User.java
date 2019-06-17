
package com.galichfactory.souzgruz.specialClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("deliverer")
    @Expose
    private Object deliverer;
    @SerializedName("customer")
    @Expose
    private Object customer;
    @SerializedName("driver")
    @Expose
    private Driver driver;
    @SerializedName("dispatcher")
    @Expose
    private Object dispatcher;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("company_made_id")
    @Expose
    private Integer companyMadeId;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("is_superuser")
    @Expose
    private Boolean isSuperuser;
    @SerializedName("role")
    @Expose
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(Object deliverer) {
        this.deliverer = deliverer;
    }

    public Object getCustomer() {
        return customer;
    }

    public void setCustomer(Object customer) {
        this.customer = customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Object getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(Object dispatcher) {
        this.dispatcher = dispatcher;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCompanyMadeId() {
        return companyMadeId;
    }

    public void setCompanyMadeId(Integer companyMadeId) {
        this.companyMadeId = companyMadeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getIsSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(Boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
