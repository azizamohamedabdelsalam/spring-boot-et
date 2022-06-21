package com.azizaabdelsalam.lil.sbet.fawaterywebapimongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;


public class Branch {
    @Id
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
