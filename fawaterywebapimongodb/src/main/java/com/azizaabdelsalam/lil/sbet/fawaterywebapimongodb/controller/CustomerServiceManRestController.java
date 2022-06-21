package com.azizaabdelsalam.lil.sbet.fawaterywebapimongodb.controller;

import com.azizaabdelsalam.lil.sbet.fawaterywebapimongodb.model.CustomerServiceMan;
import com.azizaabdelsalam.lil.sbet.fawaterywebapimongodb.service.CustomerServiceManService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/customerservicemen/{customerServiceManId}")
public class CustomerServiceManRestController {
    private final CustomerServiceManService customerServiceManService;

    public CustomerServiceManRestController(CustomerServiceManService customerServiceManService) {
        this.customerServiceManService = customerServiceManService;
    }

    @GetMapping
    public Optional<CustomerServiceMan> getCustomerServiceMan(@PathVariable(value = "customerServiceManId") String customerServiceManId){ return customerServiceManService.getCustomerServiceMan(customerServiceManId);}
}
