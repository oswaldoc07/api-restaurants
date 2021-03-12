package com.ecomers.api.restaurants.domain.dto;


public class Courier extends User{
    private Integer id;
    private String vehicleType;
    private String licensePlate;
    private Integer commerceId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getCommerceId() {
        return commerceId;
    }

    public void setCommerceId(Integer commerceId) {
        this.commerceId = commerceId;
    }
}
