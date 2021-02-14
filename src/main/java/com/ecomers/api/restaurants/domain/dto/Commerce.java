package com.ecomers.api.restaurants.domain.dto;

import java.util.List;

public class Commerce extends User {

    private Integer id;
    private String geolocalization;
    private String url;
    private String description;
    private List<PaymentType> paymentTypes;


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

    public List<PaymentType> getPaymentTypes() {
        return paymentTypes;
    }

    public void setPaymentTypes(List<PaymentType> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }
}
