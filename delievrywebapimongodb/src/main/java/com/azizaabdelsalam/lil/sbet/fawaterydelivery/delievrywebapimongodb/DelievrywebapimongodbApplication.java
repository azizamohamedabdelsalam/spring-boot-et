package com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DelievrywebapimongodbApplication {

	public static void main(String[] args) {

		SpringApplication.run(DelievrywebapimongodbApplication.class, args);
	}

	 // @Bean /* i want to create a bean of the following */
	/*CommandLineRunner runner(CustomerServiceManRepository repository) {
		return args -> {
			Branch branch = new Branch(
					"1",
					 "BranchTEST"
			);


			List<Customer> customersList = new ArrayList<Customer>();

			CustomerServiceMan customerServiceMan = new CustomerServiceMan(
					"xyz2",
					"CSNNAME3",
					branch,
					customersList
			);
			repository.insert(customerServiceMan);

		};

	}*/

}
