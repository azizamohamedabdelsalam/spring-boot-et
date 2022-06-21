package com.azizaabdelsalam.lil.sbet.fawaterywebapimongodb.model;

public class Order {
    private String orderId;

    public Order() {
    }

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
