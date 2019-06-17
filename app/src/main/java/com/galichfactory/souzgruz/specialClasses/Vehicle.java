
package com.galichfactory.souzgruz.specialClasses;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vehicle {
	
	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("vehicle_type")
	@Expose
	private VehicleType vehicleType;
	@SerializedName("options")
	@Expose
	private List<Object> options = null;
	@SerializedName("max_cargo_mass")
	@Expose
	private String maxCargoMass;
	@SerializedName("length")
	@Expose
	private String length;
	@SerializedName("width")
	@Expose
	private String width;
	@SerializedName("height")
	@Expose
	private String height;
	@SerializedName("KYC_control")
	@Expose
	private KYCControl kYCControl;
	@SerializedName("company_made_id")
	@Expose
	private Integer companyMadeId;
	@SerializedName("vehicle_number")
	@Expose
	private String vehicleNumber;
	@SerializedName("vehicle_class")
	@Expose
	private Object vehicleClass;
	@SerializedName("body_type")
	@Expose
	private Integer bodyType;
	@SerializedName("special_type")
	@Expose
	private Object specialType;
	@SerializedName("vehicle_brand")
	@Expose
	private String vehicleBrand;
	@SerializedName("vehicle_model")
	@Expose
	private String vehicleModel;
	@SerializedName("vehicle_color")
	@Expose
	private String vehicleColor;
	@SerializedName("owner")
	@Expose
	private String owner;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
	
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
}
