package com.azizaabdelsalam.lil.sbet.fawaterydelivery.fawaterywebapi.controller;

import com.azizaabdelsalam.lil.sbet.fawaterydelivery.fawaterywebapi.model.CSMDtlView;
import com.azizaabdelsalam.lil.sbet.fawaterydelivery.fawaterywebapi.model.CSMView;
import com.azizaabdelsalam.lil.sbet.fawaterydelivery.fawaterywebapi.model.CustomerIdDto;
import com.azizaabdelsalam.lil.sbet.fawaterydelivery.fawaterywebapi.model.CustomerServiceMan;
import com.azizaabdelsalam.lil.sbet.fawaterydelivery.fawaterywebapi.service.CustomerServiceManService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class CustomerServiceManRestController {



    @Autowired
    private final CustomerServiceManService customerServiceManService;

    public CustomerServiceManRestController(CustomerServiceManService customerServiceManService) {
        this.customerServiceManService = customerServiceManService;
    }



    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping(value="/ALLCSM", produces = {"application/JSON"})
    public List<CustomerServiceMan> getCustomerServiceMen() {
        return customerServiceManService.getCustomerServiceMen();
    }

    @JsonView(CSMView.CSMPublic.class)
    @GetMapping(value="/CSMData", produces = {"application/JSON"})
    public ResponseEntity<?> getCSMPublicDataById() {
            Optional <CustomerServiceMan> customerServiceMan = customerServiceManService.getCustomerServiceManById();
          if (customerServiceMan.isPresent()) {
            return new ResponseEntity<Optional<CustomerServiceMan>>(customerServiceMan, HttpStatus.OK);
          }
          else {
              //throw new IllegalAccessException();
            return new ResponseEntity<>("No Such Customer Service Man Account",HttpStatus.NOT_FOUND);
          }
    }

    @JsonView(CSMView.CSMPublic.class)
    @GetMapping("/CSMData/CSMCustomersList")
    public ResponseEntity<?> getCSMCustomersListDtlDataById(){
        ArrayList<CustomerIdDto> customerIdDtoList = customerServiceManService.getCustListPerCSMId();

            return new ResponseEntity< ArrayList<CustomerIdDto>>(customerIdDtoList, HttpStatus.OK);

    }













}
