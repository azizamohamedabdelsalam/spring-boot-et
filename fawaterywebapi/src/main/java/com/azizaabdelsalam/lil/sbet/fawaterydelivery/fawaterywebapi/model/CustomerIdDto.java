package com.azizaabdelsalam.lil.sbet.fawaterydelivery.fawaterywebapi.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document("customerId")
public class CustomerIdDto {
    //@JsonView(CSMDtlView.CSMCustomerList.class)
    @JsonView(CSMView.CSMPublic.class)
    @Field("customerId")
    private String customerId;
   // @JsonView(CSMDtlView.CSMCustomerList.class)
  // @JsonView(CSMView.CSMPublic.class)
  //  private List<OrderIdDto> orderIdsList;

    public CustomerIdDto() {
    }
    public CustomerIdDto(String customerId) {
        this.customerId = customerId;
    }
    /*public CustomerIdDto(String customerId, List<OrderIdDto> orderIdsList) {
        this.customerId = customerId;
        this.orderIdsList = orderIdsList;
    }*/

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
/*
    public List<OrderIdDto> getOrderIdsList() {
        return orderIdsList;
    }

    public void setOrderIdsList(List<OrderIdDto> orderIdsList) {
        this.orderIdsList = orderIdsList;
    }
    */
}
