package com.azizaabdelsalam.lil.sbet.delivery.customerservicemaninfoapi;

import com.fasterxml.jackson.annotation.JsonView;



public class Branch {
    @JsonView(CSMView.CSMPublic.class)
    private String branchNO;
    @JsonView(CSMView.CSMPublic.class)
    private String branchNameA;

    public Branch() {
    }

    public Branch(String branchNO, String branchNameA) {
        this.branchNO = branchNO;
        this.branchNameA = branchNameA;
    }

    public String getBranchNO() {
        return branchNO;
    }

    public void setBranchNO(String branchNO) {
        this.branchNO = branchNO;
    }

    public String getBranchNameA() {
        return branchNameA;
    }

    public void setBranchNameA(String branchNameA) {
        this.branchNameA = branchNameA;
    }
}
