package com.azizaabdelsalam.lil.sbet.fawaterydelivery.fawaterywebapi.service;

import com.azizaabdelsalam.lil.sbet.fawaterydelivery.fawaterywebapi.data.CustomerServiceManRepository;
import com.azizaabdelsalam.lil.sbet.fawaterydelivery.fawaterywebapi.model.CustomerIdDto;
import com.azizaabdelsalam.lil.sbet.fawaterydelivery.fawaterywebapi.model.CustomerServiceMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerServiceManService {
    @Autowired
    private final CustomerServiceManRepository customerServiceManRepository;

    private MongoTemplate mongoTemplate;

    public CustomerServiceManService(CustomerServiceManRepository customerServiceManRepository) {
        this.customerServiceManRepository = customerServiceManRepository;
    }

    public boolean checkCustomerServiceManExistedById(String id){
        return customerServiceManRepository.existsById(id);
    }
    public List<CustomerServiceMan> getCustomerServiceMen(){
        return customerServiceManRepository.findAll();
    }

    public Optional<CustomerServiceMan> getCustomerServiceManById(){
        String CSMId = "62b2547f1ea5032b889c047d";
        return customerServiceManRepository.findById(CSMId);
    }

    /*--- Get Customers list with thier orders with known CSM ID who is responsible to deliver*/
    public ArrayList<CustomerIdDto> getCustListPerCSMId(){

        String CSMId = "62b2547f1ea5032b889c047d";
      //  AggregationResult <CustomerServiceMan> results;
        //results = mongoTemplate.aggregate(aggregation, "CustomerIdDto", CustomerServiceMan.class);
        //List<CustomerServiceMan> tapes;
        //tapes = results.getMappedResults();

        return customerServiceManRepository.findCustomerslistByCSMId(CSMId);
    }
}
