package com.cd.fawatery.stockheaderlistpercsmapi.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "StockHeader")
public class StockHeader {
    @Id
    private String id;
    @JsonView(StockHeaderView.StockHeaderPublic.class)
    private Item item;
    @JsonView(StockHeaderView.StockHeaderPublic.class)
    private String csmNo;
    @JsonView(StockHeaderView.StockHeaderPublic.class)
    private float openingQtyCrt;
    @JsonView(StockHeaderView.StockHeaderPublic.class)
    private float openingQtyPlt;
    @JsonView(StockHeaderView.StockHeaderPublic.class)
    private float openingQtyPkt;
    @JsonView(StockHeaderView.StockHeaderPublic.class)
    private float QtyCrt;
    @JsonView(StockHeaderView.StockHeaderPublic.class)
    private float QtyPlt;
    @JsonView(StockHeaderView.StockHeaderPublic.class)
    private float QtyPkt;
    @JsonView(StockHeaderView.StockHeaderPublic.class)
    private float pendingQtyCrt;
    @JsonView(StockHeaderView.StockHeaderPublic.class)
    private float pendingQtyPlt;
    @JsonView(StockHeaderView.StockHeaderPublic.class)
    private float pendingQtyPkt;

    public StockHeader() {
    }


    public StockHeader( Item item, String csmNo, float openingQtyCrt, float openingQtyPlt, float openingQtyPkt, float qtyCrt, float qtyPlt, float qtyPkt, float pendingQtyCrt, float pendingQtyPlt, float pendingQtyPkt) {
        this.item = item;
        this.csmNo = csmNo;
        this.openingQtyCrt = openingQtyCrt;
        this.openingQtyPlt = openingQtyPlt;
        this.openingQtyPkt = openingQtyPkt;
        QtyCrt = qtyCrt;
        QtyPlt = qtyPlt;
        QtyPkt = qtyPkt;
        this.pendingQtyCrt = pendingQtyCrt;
        this.pendingQtyPlt = pendingQtyPlt;
        this.pendingQtyPkt = pendingQtyPkt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getCsmNo() {
        return csmNo;
    }

    public void setCsmNo(String csmNo) {
        this.csmNo = csmNo;
    }

    public float getOpeningQtyCrt() {
        return openingQtyCrt;
    }

    public void setOpeningQtyCrt(float openingQtyCrt) {
        this.openingQtyCrt = openingQtyCrt;
    }

    public float getOpeningQtyPlt() {
        return openingQtyPlt;
    }

    public void setOpeningQtyPlt(float openingQtyPlt) {
        this.openingQtyPlt = openingQtyPlt;
    }

    public float getOpeningQtyPkt() {
        return openingQtyPkt;
    }

    public void setOpeningQtyPkt(float openingQtyPkt) {
        this.openingQtyPkt = openingQtyPkt;
    }

    public float getQtyCrt() {
        return QtyCrt;
    }

    public void setQtyCrt(float qtyCrt) {
        QtyCrt = qtyCrt;
    }

    public float getQtyPlt() {
        return QtyPlt;
    }

    public void setQtyPlt(float qtyPlt) {
        QtyPlt = qtyPlt;
    }

    public float getQtyPkt() {
        return QtyPkt;
    }

    public void setQtyPkt(float qtyPkt) {
        QtyPkt = qtyPkt;
    }

    public float getPendingQtyCrt() {
        return pendingQtyCrt;
    }

    public void setPendingQtyCrt(float pendingQtyCrt) {
        this.pendingQtyCrt = pendingQtyCrt;
    }

    public float getPendingQtyPlt() {
        return pendingQtyPlt;
    }

    public void setPendingQtyPlt(float pendingQtyPlt) {
        this.pendingQtyPlt = pendingQtyPlt;
    }

    public float getPendingQtyPkt() {
        return pendingQtyPkt;
    }

    public void setPendingQtyPkt(float pendingQtyPkt) {
        this.pendingQtyPkt = pendingQtyPkt;
    }
}
