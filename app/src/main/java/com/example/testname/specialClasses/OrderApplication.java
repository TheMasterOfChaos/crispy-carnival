package com.example.testname.specialClasses;

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
	
}