/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unilever.erada_cls.keycloak.model.decoded_token;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.annotation.Generated;

/**
 *
 * @author Sayed.Hakim
 */
//-----------------------------------com.unilever.erada_cls.keycloak.model.EradaBE.java-----------------------------------
@Generated("jsonschema2pojo")
public class Account {

    @SerializedName("roles")
    @Expose
    private List<String> roles = null;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

}
