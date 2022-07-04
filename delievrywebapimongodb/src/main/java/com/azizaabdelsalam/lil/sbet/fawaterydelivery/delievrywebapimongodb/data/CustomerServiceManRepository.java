package com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.data;

import com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.model.CustomerIdDto;
import com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.model.CustomerServiceMan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.ArrayList;

/*
 - include customer service man class and data type of customer service man ID*/
public interface CustomerServiceManRepository
        extends MongoRepository<CustomerServiceMan,String> {

    CustomerServiceMan findByCustomerServiceManId(String customerServiceManId);

    @Query(value="{ id : ?0}", fields="{ customerIdsList : 0 }")
    ArrayList<CustomerIdDto> findCustomerslistByCSMId(String id);


}
