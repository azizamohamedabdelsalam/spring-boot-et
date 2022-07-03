package com.azizaabdelsalam.lil.sbet.fawaterydelivery.fawaterywebapi.data;


import com.azizaabdelsalam.lil.sbet.fawaterydelivery.fawaterywebapi.model.CustomerIdDto;
import com.azizaabdelsalam.lil.sbet.fawaterydelivery.fawaterywebapi.model.CustomerServiceMan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.ArrayList;


/*
 - include customer service man class and data type of customer service man ID*/
public interface CustomerServiceManRepository
        extends MongoRepository<CustomerServiceMan,String> {

    @Query(value="{ id : ?0}", fields="{ customerIdsList : 0 }")
    ArrayList<CustomerIdDto> findCustomerslistByCSMId(String id);

}
