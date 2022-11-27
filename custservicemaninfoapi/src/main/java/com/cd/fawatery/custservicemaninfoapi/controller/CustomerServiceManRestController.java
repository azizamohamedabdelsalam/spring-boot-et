package com.cd.fawatery.custservicemaninfoapi.controller;

import com.cd.fawatery.custservicemaninfoapi.model.CustomerServiceMan;
import com.cd.fawatery.custservicemaninfoapi.service.CustomerServiceManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping(value = "/api")
public class CustomerServiceManRestController {

    @Autowired
    private final CustomerServiceManService customerServiceManService;

    public CustomerServiceManRestController(CustomerServiceManService customerServiceManService) {
        this.customerServiceManService = customerServiceManService;
    }

    @GetMapping(value="/CSMData", produces = {"application/JSON"})
    public ResponseEntity<CustomerServiceMan> getCustomerServiceManByCustomerServiceManId() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        CustomerServiceMan customerServiceMan = customerServiceManService.getCustomerServiceManByCustomerServiceManId().orElse(null);
        if (customerServiceMan != null) return new ResponseEntity<>(customerServiceMan, HttpStatus.OK);
        else  return new ResponseEntity<>(headers,HttpStatus.OK);
    }
 }
