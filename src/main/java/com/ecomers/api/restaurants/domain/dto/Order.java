package com.ecomers.api.restaurants.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private int id;
    private Integer clientId;
    private Integer commerceId;
    private LocalDateTime includeDate;
    private LocalDateTime estimatedDate;
    private LocalDateTime deliveredDate ;
    private String paymentMethod;
    private String comment;
    private String state;
    private Integer price;
    private Integer shippingCost;
    private List<OrderProduct> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getCommerceId() {
        return commerceId;
    }

    public void setCommerceId(Integer commerceId) {
        this.commerceId = commerceId;
    }

    public LocalDateTime getIncludeDate() {
        return includeDate;
    }

    public void setIncludeDate(LocalDateTime includeDate) {
        this.includeDate = includeDate;
    }

    public LocalDateTime getEstimatedDate() {
        return estimatedDate;
    }

    public void setEstimatedDate(LocalDateTime estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

    public LocalDateTime getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(LocalDateTime deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Integer shippingCost) {
        this.shippingCost = shippingCost;
    }

    public List<OrderProduct> getItems() {
        return items;
    }

    public void setItems(List<OrderProduct> items) {
        this.items = items;
    }
}
