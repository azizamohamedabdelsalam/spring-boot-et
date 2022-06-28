package com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.service;

import com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.data.CustomerServiceManRepository;
import com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.model.CustomerServiceMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceManService {
    @Autowired
    private final CustomerServiceManRepository customerServiceManRepository;

    public CustomerServiceManService(CustomerServiceManRepository customerServiceManRepository) {
        this.customerServiceManRepository = customerServiceManRepository;
    }

    public boolean checkCustomerServiceManExistedById(String id){
        return customerServiceManRepository.existsById(id);
    }
    public Optional<CustomerServiceMan> getCustomerServiceManById(String id){
           return customerServiceManRepository.findById(id);
    }

    public List<CustomerServiceMan> getCustomerServiceMen(){
        return customerServiceManRepository.findAll();
    }
}
