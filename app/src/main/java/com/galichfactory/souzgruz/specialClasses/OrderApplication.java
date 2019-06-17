package com.galichfactory.souzgruz.specialClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderApplication {
	
	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("driver")
	@Expose
	private Driver driver;
	@SerializedName("order")
	@Expose
	private Order order;
	@SerializedName("company_made_id")
	@Expose
	private Integer companyMadeId;
	@SerializedName("vehicle")
	@Expose
	private Vehicle vehicle;
	@SerializedName("deliverer")
	@Expose
	private Deliverer deliverer;
	
	public OrderApplication(Driver driver, Order order, Vehicle vehicle) {
		this.driver = driver;
		this.order = order;
		this.vehicle = vehicle;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Driver getDriver() {
		return driver;
	}
	
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Integer getCompanyMadeId() {
		return companyMadeId;
	}
	
	public void setCompanyMadeId(Integer companyMadeId) {
		this.companyMadeId = companyMadeId;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}