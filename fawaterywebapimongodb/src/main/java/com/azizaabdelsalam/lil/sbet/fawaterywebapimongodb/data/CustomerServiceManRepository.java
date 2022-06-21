package com.azizaabdelsalam.lil.sbet.fawaterywebapimongodb.data;

import com.azizaabdelsalam.lil.sbet.fawaterywebapimongodb.model.CustomerServiceMan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerServiceManRepository extends MongoRepository<CustomerServiceMan,String> {
}
