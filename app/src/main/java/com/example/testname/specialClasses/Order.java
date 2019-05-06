
package com.example.testname.specialClasses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

    private Integer id;
    private Customer customer;
    private Object cargoTemplate;
    private List<Point> points = null;
    private VehicleType vehicleType;
    private Cargo cargo;
    private List<Object> options = null;
    private TariffValueDeliverer tariffValueDeliverer;
    private TariffValueCustomer tariffValueCustomer;
    private Vehicle vehicle;
    private Driver driver;
    private Object dispatcherMade;
    private String beginDateTime;
    private String finishDateTime;
    private String actualStartDateTime;
    private String orderDateTime;
    private Object deliverer;
    private Integer companyMadeId;
    private Integer nextPoint;
    private Integer regionType;
    private String costDeliverer;
    private String additionalHourCostDeliverer;
    private String costCustomer;
    private String additionalHourCostCustomer;
    private Integer status;
    private Integer hours;
    private String comment;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public String getFinishDateTime() {
        return finishDateTime;
    }

    public void setFinishDateTime(String finishDateTime) {
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
