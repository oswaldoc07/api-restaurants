package com.ecommerce.api.restaurants.domain.dto;

import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private int id;
    private Client Client;
    private Commerce commerce;
    private Courier courier;
    private Integer commerceId;
    private LocalDateTime includedDate;
    private LocalDateTime estimatedDate;
    private LocalDateTime deliveredDate ;
    private String customerComment;
    private String commerceComment;
    private String courierComment;
    private String state;
    private Integer price;
    private Integer shippingCost;
    private List<OrderProduct> cartItem;
    private String desRejected;
    private String ubicationGPS;

    private String address;
    private PaymentMethod paymentMethod;
    private Double cashAmount;
    private Double deliveryTime;
    private Boolean  deliveryHouse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Integer getCommerceId() {
        return commerceId;
    }

    public void setCommerceId(Integer commerceId) {
        this.commerceId = commerceId;
    }

    public LocalDateTime getIncludedDate() {
        return includedDate;
    }

    public void setIncludedDate(LocalDateTime includedDate) {
        this.includedDate = includedDate;
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

    public String getCustomerComment() {
        return customerComment;
    }

    public void setCustomerComment(String customerComment) {
        this.customerComment = customerComment;
    }

    public String getCommerceComment() {
        return commerceComment;
    }

    public void setCommerceComment(String commerceComment) {
        this.commerceComment = commerceComment;
    }

    public String getCourierComment() {
        return courierComment;
    }

    public void setCourierComment(String courierComment) {
        this.courierComment = courierComment;
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

    public List<OrderProduct> getCartItem() {
        return cartItem;
    }

    public void setCartItem(List<OrderProduct> cartItem) {
        this.cartItem = cartItem;
    }

    public String getDesRejected() {
        return desRejected;
    }

    public void setDesRejected(String desRejected) {
        this.desRejected = desRejected;
    }

    public Client getClient() {
        return Client;
    }

    public void setClient(Client client) {
        Client = client;
    }

    public String getUbicationGPS() {
        return ubicationGPS;
    }

    public void setUbicationGPS(String ubicationGPS) {
        this.ubicationGPS = ubicationGPS;
    }


    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(Double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public Double getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Double deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Boolean getDeliveryHouse() {
        return deliveryHouse;
    }

    public void setDeliveryHouse(Boolean deliveryHouse) {
        this.deliveryHouse = deliveryHouse;
    }

    public Commerce getCommerce() {
        return commerce;
    }

    public void setCommerce(Commerce commerce) {
        this.commerce = commerce;
    }
}
