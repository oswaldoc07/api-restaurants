package com.ecommerce.api.restaurants.domain.dto;

public class CommerceCourier {
    private int commerceId;
    private int courierId;

    public int getCommerceId() {
        return commerceId;
    }

    public void setCommerceId(int commerceId) {
        this.commerceId = commerceId;
    }

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }
}
