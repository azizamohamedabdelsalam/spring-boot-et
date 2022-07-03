package com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("orderId")
public class OrderIdDto {
    @JsonView(CSMView.CSMPublic.class)
    @Field("orderId")
    private String orderId;

    public OrderIdDto(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
