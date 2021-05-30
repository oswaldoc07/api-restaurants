package com.ecommerce.api.restaurants.domain.dto;

import java.util.List;

import com.ecommerce.api.restaurants.domain.dto.User;

public class Commerce extends User {

    private Integer id;
    private String geolocalization;
    private String url;
    private String description;
    private List<PaymentMethod> paymentMethods;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getGeolocalization() {
        return geolocalization;
    }

    public void setGeolocalization(String geolocalization) {
        this.geolocalization = geolocalization;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}
