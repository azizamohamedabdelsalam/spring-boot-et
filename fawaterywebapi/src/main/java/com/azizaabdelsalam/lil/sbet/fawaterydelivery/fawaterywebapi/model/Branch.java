package com.azizaabdelsalam.lil.sbet.fawaterydelivery.fawaterywebapi.model;


import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document("branch")
public class Branch {

    @JsonView(CSMView.CSMPublic.class)
    @Field("branchNo")
    private String branchNO;
    @JsonView(CSMView.CSMPublic.class)
    @Field("branchNameA")
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
