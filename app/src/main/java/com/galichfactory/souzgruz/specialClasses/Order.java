
package com.galichfactory.souzgruz.specialClasses;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("customer")
    @Expose
    private Customer customer;
    @SerializedName("cargo_template")
    @Expose
    private Object cargoTemplate;
    @SerializedName("points")
    @Expose
    private List<Point> points = null;
    @SerializedName("vehicle_type")
    @Expose
    private VehicleType vehicleType;
    @SerializedName("cargo")
    @Expose
    private Cargo cargo;
    @SerializedName("options")
    @Expose
    private List<Object> options = null;
    @SerializedName("tariff_value_deliverer")
    @Expose
    private TariffValueDeliverer tariffValueDeliverer;
    @SerializedName("tariff_value_customer")
    @Expose
    private TariffValueCustomer tariffValueCustomer;
    @SerializedName("vehicle")
    @Expose
    private Vehicle vehicle;
    @SerializedName("driver")
    @Expose
    private Driver driver;
    @SerializedName("dispatcher_made")
    @Expose
    private Object dispatcherMade;
    @SerializedName("begin_date_time")
    @Expose
    private String beginDateTime;
    @SerializedName("finish_date_time")
    @Expose
    private Object finishDateTime;
    @SerializedName("actual_start_date_time")
    @Expose
    private String actualStartDateTime;
    @SerializedName("order_date_time")
    @Expose
    private String orderDateTime;
    @SerializedName("deliverer")
    @Expose
    private Object deliverer;
    @SerializedName("company_made_id")
    @Expose
    private Integer companyMadeId;
    @SerializedName("next_point")
    @Expose
    private Integer nextPoint;
    @SerializedName("region_type")
    @Expose
    private Integer regionType;
    @SerializedName("cost_deliverer")
    @Expose
    private String costDeliverer;
    @SerializedName("additional_hour_cost_deliverer")
    @Expose
    private String additionalHourCostDeliverer;
    @SerializedName("cost_customer")
    @Expose
    private String costCustomer;
    @SerializedName("additional_hour_cost_customer")
    @Expose
    private String additionalHourCostCustomer;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("hours")
    @Expose
    private Integer hours;
    @SerializedName("comment")
    @Expose
    private String comment;
    
    public void setOrder(Order order) {
        this.id = order.id;
        this.customer = order.customer;
        this.cargoTemplate = order.cargoTemplate;
        this.points = order.points;
        this.vehicleType = order.vehicleType;
        this.cargo = order.cargo;
        this.options = order.options;
        this.tariffValueDeliverer = order.tariffValueDeliverer;
        this.tariffValueCustomer = order.tariffValueCustomer;
        this.vehicle = order.vehicle;
        this.driver = order.driver;
        this.dispatcherMade = order.dispatcherMade;
        this.beginDateTime = order.beginDateTime;
        this.finishDateTime = order.finishDateTime;
        this.actualStartDateTime = order.actualStartDateTime;
        this.orderDateTime = order.orderDateTime;
        this.deliverer = order.deliverer;
        this.companyMadeId = order.companyMadeId;
        this.nextPoint = order.nextPoint;
        this.regionType = order.regionType;
        this.costDeliverer = order.costDeliverer;
        this.additionalHourCostDeliverer = order.additionalHourCostDeliverer;
        this.costCustomer = order.costCustomer;
        this.additionalHourCostCustomer = order.additionalHourCostCustomer;
        this.status = order.status;
        this.hours = order.hours;
        this.comment = order.comment;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Object getCargoTemplate() {
        return cargoTemplate;
    }

    public void setCargoTemplate(Object cargoTemplate) {
        this.cargoTemplate = cargoTemplate;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Object> getOptions() {
        return options;
    }

    public void setOptions(List<Object> options) {
        this.options = options;
    }

    public TariffValueDeliverer getTariffValueDeliverer() {
        return tariffValueDeliverer;
    }

    public void setTariffValueDeliverer(TariffValueDeliverer tariffValueDeliverer) {
        this.tariffValueDeliverer = tariffValueDeliverer;
    }

    public TariffValueCustomer getTariffValueCustomer() {
        return tariffValueCustomer;
    }

    public void setTariffValueCustomer(TariffValueCustomer tariffValueCustomer) {
        this.tariffValueCustomer = tariffValueCustomer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Object getDispatcherMade() {
        return dispatcherMade;
    }

    public void setDispatcherMade(Object dispatcherMade) {
        this.dispatcherMade = dispatcherMade;
    }

    public String getBeginDateTime() {
        return beginDateTime;
    }

    public void setBeginDateTime(String beginDateTime) {
        this.beginDateTime = beginDateTime;
    }

    public Object getFinishDateTime() {
        return finishDateTime;
    }

    public void setFinishDateTime(Object finishDateTime) {
        this.finishDateTime = finishDateTime;
    }

    public String getActualStartDateTime() {
        return actualStartDateTime;
    }

    public void setActualStartDateTime(String actualStartDateTime) {
        this.actualStartDateTime = actualStartDateTime;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public Object getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(Object deliverer) {
        this.deliverer = deliverer;
    }

    public Integer getCompanyMadeId() {
        return companyMadeId;
    }

    public void setCompanyMadeId(Integer companyMadeId) {
        this.companyMadeId = companyMadeId;
    }

    public Integer getNextPoint() {
        return nextPoint;
    }

    public void setNextPoint(Integer nextPoint) {
        this.nextPoint = nextPoint;
    }

    public Integer getRegionType() {
        return regionType;
    }

    public void setRegionType(Integer regionType) {
        this.regionType = regionType;
    }

    public String getCostDeliverer() {
        return costDeliverer;
    }

    public void setCostDeliverer(String costDeliverer) {
        this.costDeliverer = costDeliverer;
    }

    public String getAdditionalHourCostDeliverer() {
        return additionalHourCostDeliverer;
    }

    public void setAdditionalHourCostDeliverer(String additionalHourCostDeliverer) {
        this.additionalHourCostDeliverer = additionalHourCostDeliverer;
    }

    public String getCostCustomer() {
        return costCustomer;
    }

    public void setCostCustomer(String costCustomer) {
        this.costCustomer = costCustomer;
    }

    public String getAdditionalHourCostCustomer() {
        return additionalHourCostCustomer;
    }

    public void setAdditionalHourCostCustomer(String additionalHourCostCustomer) {
        this.additionalHourCostCustomer = additionalHourCostCustomer;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
