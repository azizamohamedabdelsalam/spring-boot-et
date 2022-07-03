package com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.model;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class CustomerIdDto {
    @JsonView(CSMView.CSMPublic.class)
    private String customerId;
    @JsonView(CSMView.CSMPublic.class)
    private List<OrderIdDto> orderIdsList;

    public CustomerIdDto() {
    }

    public CustomerIdDto(String customerId, List<OrderIdDto> orderIdsList) {
        this.customerId = customerId;
        this.orderIdsList = orderIdsList;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<OrderIdDto> getOrderIdsList() {
        return orderIdsList;
    }

    public void setOrderIdsList(List<OrderIdDto> orderIdsList) {
        this.orderIdsList = orderIdsList;
    }
}
