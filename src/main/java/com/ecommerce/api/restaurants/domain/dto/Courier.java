package com.ecommerce.api.restaurants.domain.dto;

import com.ecommerce.api.restaurants.domain.dto.User;

public class Courier extends User{
    private Integer id;
    private String vehicleType;
    private String licensePlate;
    private Boolean available;
    private Long pendingDeliveries;
    private Double  pendingTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
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

    public Long getPendingDeliveries() {
        return pendingDeliveries;
    }

    public void setPendingDeliveries(Long pendingDeliveries) {
        this.pendingDeliveries = pendingDeliveries;
    }

    public Double getPendingTime() {
        return pendingTime;
    }

    public void setPendingTime(Double pendingTime) {
        this.pendingTime = pendingTime;
    }
}
