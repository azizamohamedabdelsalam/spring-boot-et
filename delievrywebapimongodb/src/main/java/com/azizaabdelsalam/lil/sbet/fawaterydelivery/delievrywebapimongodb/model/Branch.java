package com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.model;


public class Branch {

    private String branchNO;
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
