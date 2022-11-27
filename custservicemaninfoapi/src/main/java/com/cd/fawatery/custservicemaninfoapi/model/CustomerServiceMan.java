package com.cd.fawatery.custservicemaninfoapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "CustomerServiceMan")
public class CustomerServiceMan {
    @Id
    private String customerServiceManId;
    private String customerServiceManNameA;
    private Branch branch;

    public CustomerServiceMan() {
    }
    public CustomerServiceMan( String customerServiceManId, String customerServiceManNameA, Branch branch ) {

        this.customerServiceManId = customerServiceManId;
        this.customerServiceManNameA = customerServiceManNameA;
        this.branch = branch;
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

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
