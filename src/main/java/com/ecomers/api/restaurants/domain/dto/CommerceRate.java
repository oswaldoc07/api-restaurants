package com.ecomers.api.restaurants.domain.dto;

public class CommerceRate {
    private int id;
    private int commerceId;
    private double distance;
    private double rate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommerceId() {
        return commerceId;
    }

    public void setCommerceId(int commerceId) {
        this.commerceId = commerceId;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
