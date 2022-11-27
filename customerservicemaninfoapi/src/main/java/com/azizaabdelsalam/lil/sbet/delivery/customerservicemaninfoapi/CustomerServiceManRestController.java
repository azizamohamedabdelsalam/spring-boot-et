package com.azizaabdelsalam.lil.sbet.delivery.customerservicemaninfoapi;

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
@RequestMapping(value = "/api")
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


    @JsonView(CSMView.CSMPublic.class)
    @GetMapping(value="/CSMData", produces = {"application/JSON"})
    public ResponseEntity<CustomerServiceMan> getCustomerServiceManByCustomerServiceManId() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        CustomerServiceMan customerServiceMan = customerServiceManService.getCustomerServiceManByCustomerServiceManId();
        if (customerServiceMan != null) return new ResponseEntity<>(customerServiceMan, HttpStatus.OK);
        else  return new ResponseEntity<>(headers,HttpStatus.OK);
    }

    @JsonView(CSMDtlView.CSMCustomerList.class)
    @GetMapping(value="/CSMData/CSMCustomersList", produces = {"application/JSON"})
    public ResponseEntity<List<CustomerIdDto>> getCustListByCustomerServiceManId(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        List<CustomerIdDto> customerIdDtoList = customerServiceManService.getCustListByCustomerServiceManId();
        if (customerIdDtoList.size() != 0) return new ResponseEntity<List<CustomerIdDto>>(customerIdDtoList, HttpStatus.OK);
        else  return new ResponseEntity<>(headers,HttpStatus.OK);
    }

}
