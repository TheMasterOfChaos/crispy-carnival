
package com.example.testnae.specialClasses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vehicle {

    private Integer id;
    private VehicleType vehicleType;
    private List<Object> options = null;
    private String maxCargoMass;
    private String length;
    private String width;
    private String height;
    private KYCControl kYCControl;
    private Integer companyMadeId;
    private String vehicleNumber;
    private Object vehicleClass;
    private Integer bodyType;
    private Object specialType;
    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleColor;
    private String owner;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public List<Object> getOptions() {
        return options;
    }

    public void setOptions(List<Object> options) {
        this.options = options;
    }

    public String getMaxCargoMass() {
        return maxCargoMass;
    }

    public void setMaxCargoMass(String maxCargoMass) {
        this.maxCargoMass = maxCargoMass;
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

    public KYCControl getKYCControl() {
        return kYCControl;
    }

    public void setKYCControl(KYCControl kYCControl) {
        this.kYCControl = kYCControl;
    }

    public Integer getCompanyMadeId() {
        return companyMadeId;
    }

    public void setCompanyMadeId(Integer companyMadeId) {
        this.companyMadeId = companyMadeId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Object getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(Object vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public Integer getBodyType() {
        return bodyType;
    }

    public void setBodyType(Integer bodyType) {
        this.bodyType = bodyType;
    }

    public Object getSpecialType() {
        return specialType;
    }

    public void setSpecialType(Object specialType) {
        this.specialType = specialType;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
