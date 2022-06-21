package com.azizaabdelsalam.lil.sbet.fawaterywebapimongodb.service;

import com.azizaabdelsalam.lil.sbet.fawaterywebapimongodb.data.CustomerServiceManRepository;
import com.azizaabdelsalam.lil.sbet.fawaterywebapimongodb.model.CustomerServiceMan;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceManService {
    private final CustomerServiceManRepository customerServiceManRepository;

    public CustomerServiceManService(CustomerServiceManRepository customerServiceManRepository) {
        this.customerServiceManRepository = customerServiceManRepository;
    }

    public Optional<CustomerServiceMan> getCustomerServiceMan(String customerServiceManId){
        return customerServiceManRepository.findById(customerServiceManId);
    }
}
