package com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;
@Document("customerIds")
public class CustomerIdDto {
    @JsonView(CSMDtlView.CSMCustomerList.class)
    @Field("customerId")
    private String customerId;
    @JsonView(CSMDtlView.CSMCustomerList.class)
    @Field("OrderIds")
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
