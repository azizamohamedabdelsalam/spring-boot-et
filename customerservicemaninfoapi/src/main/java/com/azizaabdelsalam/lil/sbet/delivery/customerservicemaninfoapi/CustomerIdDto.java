package com.azizaabdelsalam.lil.sbet.delivery.customerservicemaninfoapi;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;


public class CustomerIdDto {
    @JsonView(CSMDtlView.CSMCustomerList.class)
    private String customerId;
    @JsonView(CSMDtlView.CSMCustomerList.class)
    private List<String> orderIdsList;

    public CustomerIdDto() {
    }

    public CustomerIdDto(String customerId, List<String> orderIdsList) {
        this.customerId = customerId;
        this.orderIdsList = orderIdsList;
    }



    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<String> getOrderIdsList() {
        return orderIdsList;
    }

    public void setOrderIdsList(List<String> orderIdsList) {
        this.orderIdsList = orderIdsList;
    }
}
