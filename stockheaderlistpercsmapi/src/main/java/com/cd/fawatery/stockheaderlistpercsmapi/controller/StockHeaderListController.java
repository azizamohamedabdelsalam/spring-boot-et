package com.cd.fawatery.stockheaderlistpercsmapi.controller;

import com.cd.fawatery.stockheaderlistpercsmapi.model.StockHeader;
import com.cd.fawatery.stockheaderlistpercsmapi.model.StockHeaderView;
import com.cd.fawatery.stockheaderlistpercsmapi.service.SockHeaderListService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class StockHeaderListController {
    @Autowired
    private final SockHeaderListService sockHeaderListService;

    public StockHeaderListController(SockHeaderListService sockHeaderListService) {
        this.sockHeaderListService = sockHeaderListService;
    }

    @JsonView(StockHeaderView.StockHeaderPublic.class)
    @GetMapping(value="/api-stockheaderlist", produces = {"application/JSON"})
    public ResponseEntity<List<StockHeader>> getStockHeaderListByCustomerServiceManId() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        List<StockHeader> stockHeaderList= sockHeaderListService.getStockHeaderListByCustomerServiceManId();
        if (stockHeaderList.size() != 0) return new ResponseEntity<List<StockHeader>>(stockHeaderList, HttpStatus.OK);
        else  return new ResponseEntity<>(headers,HttpStatus.OK);
    }
}
