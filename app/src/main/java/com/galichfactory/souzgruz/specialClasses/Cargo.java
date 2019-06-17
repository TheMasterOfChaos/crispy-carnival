
package com.galichfactory.souzgruz.specialClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cargo {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("mass")
    @Expose
    private String mass;
    @SerializedName("length")
    @Expose
    private String length;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("company_made_id")
    @Expose
    private Integer companyMadeId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("is_template")
    @Expose
    private Boolean isTemplate;
    @SerializedName("loading_type")
    @Expose
    private Object loadingType;
    @SerializedName("comment")
    @Expose
    private String comment;

    public void setCargo(Cargo cargo) {
        this.id = cargo.id;
        this.mass = cargo.mass;
        this.length = cargo.length;
        this.width = cargo.width;
        this.height = cargo.height;
        this.companyMadeId = cargo.companyMadeId;
        this.name = cargo.name;
        this.isTemplate = cargo.isTemplate;
        this.loadingType = cargo.loadingType;
        this.comment = cargo.comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
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

    public Boolean getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Boolean isTemplate) {
        this.isTemplate = isTemplate;
    }

    public Object getLoadingType() {
        return loadingType;
    }

    public void setLoadingType(Object loadingType) {
        this.loadingType = loadingType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
