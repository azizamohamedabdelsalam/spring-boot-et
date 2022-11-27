package com.cd.fawatery.custservicemaninfoapi.data;

import com.cd.fawatery.custservicemaninfoapi.model.CustomerServiceMan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerServiceManRepository
        extends MongoRepository<CustomerServiceMan,String> {

   //Optional<CustomerServiceMan> findById(String customerServiceManId);

}
