package com.galichfactory.souzgruz.specialClasses;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Deliverer {
	public Deliverer(Integer id) {
		this.id = id;
	}
	
	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("user_id")
	@Expose
	private Object userId;
	@SerializedName("vehicles")
	@Expose
	private List<Vehicle> vehicles;
	@SerializedName("drivers")
	@Expose
	private List<Object> drivers = null;
	@SerializedName("rating")
	@Expose
	private Rating rating;
	@SerializedName("passport_data")
	@Expose
	private PassportData passportData;
	@SerializedName("company_made_id")
	@Expose
	private Integer companyMadeId;
	@SerializedName("surname")
	@Expose
	private String surname;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("last_name")
	@Expose
	private String lastName;
	@SerializedName("birth_date")
	@Expose
	private String birthDate;
	@SerializedName("birth_place")
	@Expose
	private String birthPlace;
	@SerializedName("TIN")
	@Expose
	private String tIN;
	@SerializedName("IEC")
	@Expose
	private String iEC;
	@SerializedName("PSRN")
	@Expose
	private String pSRN;
	@SerializedName("BIC")
	@Expose
	private String bIC;
	@SerializedName("bank_name")
	@Expose
	private String bankName;
	@SerializedName("corresponding_account")
	@Expose
	private String correspondingAccount;
	@SerializedName("checking_account")
	@Expose
	private String checkingAccount;
	@SerializedName("company_address")
	@Expose
	private String companyAddress;
	@SerializedName("real_address")
	@Expose
	private String realAddress;
	@SerializedName("tax_type")
	@Expose
	private Integer taxType;
	@SerializedName("PSRNSP")
	@Expose
	private String pSRNSP;
	@SerializedName("manager_full_name")
	@Expose
	private String managerFullName;
	@SerializedName("manager_comment")
	@Expose
	private String managerComment;
	@SerializedName("deliverer_type")
	@Expose
	private Integer delivererType;
	@SerializedName("deliverer_name")
	@Expose
	private String delivererName;
	@SerializedName("contact_person")
	@Expose
	private String contactPerson;
	@SerializedName("contact_phone")
	@Expose
	private String contactPhone;
	@SerializedName("email")
	@Expose
	private String email;
	@SerializedName("registration_data")
	@Expose
	private String registrationData;
	@SerializedName("delivery_area")
	@Expose
	private String deliveryArea;
	@SerializedName("parking_area")
	@Expose
	private String parkingArea;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Object getUserId() {
		return userId;
	}
	
	public void setUserId(Object userId) {
		this.userId = userId;
	}
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public List<Object> getDrivers() {
		return drivers;
	}
	
	public void setDrivers(List<Object> drivers) {
		this.drivers = drivers;
	}
	
	public Rating getRating() {
		return rating;
	}
	
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	public PassportData getPassportData() {
		return passportData;
	}
	
	public void setPassportData(PassportData passportData) {
		this.passportData = passportData;
	}
	
	public Integer getCompanyMadeId() {
		return companyMadeId;
	}
	
	public void setCompanyMadeId(Integer companyMadeId) {
		this.companyMadeId = companyMadeId;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getBirthPlace() {
		return birthPlace;
	}
	
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	
	public String getTIN() {
		return tIN;
	}
	
	public void setTIN(String tIN) {
		this.tIN = tIN;
	}
	
	public String getIEC() {
		return iEC;
	}
	
	public void setIEC(String iEC) {
		this.iEC = iEC;
	}
	
	public String getPSRN() {
		return pSRN;
	}
	
	public void setPSRN(String pSRN) {
		this.pSRN = pSRN;
	}
	
	public String getBIC() {
		return bIC;
	}
	
	public void setBIC(String bIC) {
		this.bIC = bIC;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getCorrespondingAccount() {
		return correspondingAccount;
	}
	
	public void setCorrespondingAccount(String correspondingAccount) {
		this.correspondingAccount = correspondingAccount;
	}
	
	public String getCheckingAccount() {
		return checkingAccount;
	}
	
	public void setCheckingAccount(String checkingAccount) {
		this.checkingAccount = checkingAccount;
	}
	
	public String getCompanyAddress() {
		return companyAddress;
	}
	
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	public String getRealAddress() {
		return realAddress;
	}
	
	public void setRealAddress(String realAddress) {
		this.realAddress = realAddress;
	}
	
	public Integer getTaxType() {
		return taxType;
	}
	
	public void setTaxType(Integer taxType) {
		this.taxType = taxType;
	}
	
	public String getPSRNSP() {
		return pSRNSP;
	}
	
	public void setPSRNSP(String pSRNSP) {
		this.pSRNSP = pSRNSP;
	}
	
	public String getManagerFullName() {
		return managerFullName;
	}
	
	public void setManagerFullName(String managerFullName) {
		this.managerFullName = managerFullName;
	}
	
	public String getManagerComment() {
		return managerComment;
	}
	
	public void setManagerComment(String managerComment) {
		this.managerComment = managerComment;
	}
	
	public Integer getDelivererType() {
		return delivererType;
	}
	
	public void setDelivererType(Integer delivererType) {
		this.delivererType = delivererType;
	}
	
	public String getDelivererName() {
		return delivererName;
	}
	
	public void setDelivererName(String delivererName) {
		this.delivererName = delivererName;
	}
	
	public String getContactPerson() {
		return contactPerson;
	}
	
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	
	public String getContactPhone() {
		return contactPhone;
	}
	
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRegistrationData() {
		return registrationData;
	}
	
	public void setRegistrationData(String registrationData) {
		this.registrationData = registrationData;
	}
	
	public String getDeliveryArea() {
		return deliveryArea;
	}
	
	public void setDeliveryArea(String deliveryArea) {
		this.deliveryArea = deliveryArea;
	}
	
	public String getParkingArea() {
		return parkingArea;
	}
	
	public void setParkingArea(String parkingArea) {
		this.parkingArea = parkingArea;
	}
	
}