package com.cd.fawatery.stockheaderlistpercsmapi.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("item")
public class Item {
    @JsonView(StockHeaderView.StockHeaderPublic.class)
    @Field("itemNO")
    private String itemNO;
    @JsonView(StockHeaderView.StockHeaderPublic.class)
    @Field("itemNameA")
    private String itemNameA;

    public Item() {
    }

    public Item(String itemNO, String itemNameA) {
        this.itemNO = itemNO;
        this.itemNameA = itemNameA;
    }

    public String getItemNO() {
        return itemNO;
    }

    public void setItemNO(String itemNO) {
        this.itemNO = itemNO;
    }

    public String getItemNameA() {
        return itemNameA;
    }

    public void setItemNameA(String itemNameA) {
        this.itemNameA = itemNameA;
    }
}
