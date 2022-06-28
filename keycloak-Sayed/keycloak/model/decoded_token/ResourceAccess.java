package com.unilever.erada_cls.keycloak.model.decoded_token;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//-----------------------------------com.unilever.erada_cls.keycloak.model.ResourceAccess.java-----------------------------------
public class ResourceAccess {

    @SerializedName("Erada-FE")
    @Expose
    private EradaFE eradaFE;
    @SerializedName("Erada-BE")
    @Expose
    private EradaBE eradaBE;
    @SerializedName("account")
    @Expose
    private Account account;

    public EradaFE getEradaFE() {
        return eradaFE;
    }

    public void setEradaFE(EradaFE eradaFE) {
        this.eradaFE = eradaFE;
    }

    public EradaBE getEradaBE() {
        return eradaBE;
    }

    public void setEradaBE(EradaBE eradaBE) {
        this.eradaBE = eradaBE;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
