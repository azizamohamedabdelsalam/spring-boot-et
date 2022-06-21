package com.azizaabdelsalam.lil.sbet.fawaterywebapimongodb.model;


import java.util.List;

public class Customer {

    private String customerId;
    private List<Order> orders;

    public Customer() {
    }

    public Customer(String customerId, List<Order> orders) {
        this.customerId = customerId;
        this.orders = orders;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
