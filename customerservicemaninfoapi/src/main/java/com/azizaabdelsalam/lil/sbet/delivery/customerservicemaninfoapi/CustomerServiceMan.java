package com.azizaabdelsalam.lil.sbet.delivery.customerservicemaninfoapi;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceMan {
    private String id;
    @JsonView(CSMView.CSMPublic.class)
    private String customerServiceManId;
    @JsonView(CSMView.CSMPublic.class)
    private String customerServiceManNameA;
    @JsonView(CSMView.CSMPublic.class)
    private Branch branch;
    private List<CustomerIdDto> customerIdsList = new ArrayList<>();

    public CustomerServiceMan() {
    }

    /* we create constructor without id since ID is auto-generated for us*/
    public CustomerServiceMan( String customerServiceManId, String customerServiceManNameA, Branch branch, List<CustomerIdDto> customerIdsList) {

        this.customerServiceManId = customerServiceManId;
        this.customerServiceManNameA = customerServiceManNameA;
        this.branch = branch;
        this.customerIdsList = customerIdsList;
    }

    public CustomerServiceMan(String customerServiceManId, String customerServiceManNameA, Branch branch) {
        this.customerServiceManId = customerServiceManId;
        this.customerServiceManNameA = customerServiceManNameA;
        this.branch = branch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<CustomerIdDto> getCustomerIdsList() {
        return customerIdsList;
    }

    public void setCustomerIdsList(List<CustomerIdDto> customerIdsList) {
        this.customerIdsList = customerIdsList;
    }
}
