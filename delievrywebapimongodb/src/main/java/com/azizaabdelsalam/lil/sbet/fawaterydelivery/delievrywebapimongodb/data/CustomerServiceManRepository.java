package com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.data;

import com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.model.CustomerServiceMan;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
 - include customer service man class and data type of customer service man ID*/
public interface CustomerServiceManRepository
        extends MongoRepository<CustomerServiceMan,String> {
}
