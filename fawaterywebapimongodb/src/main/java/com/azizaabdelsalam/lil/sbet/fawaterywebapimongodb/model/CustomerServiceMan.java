package com.azizaabdelsalam.lil.sbet.fawaterywebapimongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.util.List;

@Document (collection="CUSTOMERSERVICEMAN")
public class CustomerServiceMan {
    @Id
    private String customerServiceManId;
    @Indexed
    private String customerServiceManNameA;

    private Branch branch;

    private List<Customer> customers;

    public CustomerServiceMan() {
    }

    public CustomerServiceMan(String customerServiceManId, String customerServiceManNameA, @NonNull Branch branch, List<Customer> customers) {
        this.customerServiceManId = customerServiceManId;
        this.customerServiceManNameA = customerServiceManNameA;
        this.branch = branch;
        this.customers = customers;
    }

    public String getCustomerServiceManId() {
        return customerServiceManId;
    }

    public void setCustomerServiceManId(String customerServiceManId) {
        this.customerServiceManId = customerServiceManId;
    }

    public String getCustomerServiceManNameA() {
        return customerServiceManNameA;
    }

    public void setCustomerServiceManNameA(String customerServiceManNameA) {
        this.customerServiceManNameA = customerServiceManNameA;
    }

    @NonNull
    public Branch getBranch() {
        return branch;
    }

    public void setBranch(@NonNull Branch branch) {
        this.branch = branch;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
