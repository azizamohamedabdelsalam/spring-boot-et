package com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;

/**
 *
 * @author Sayed.Hakim
 */
public class KeycloakUserInfoDto {
    private String id;
    private String userName;
    private String email;
    private String password;
    private String firstname;
    private String lastName;
    private String customer_service_man_id;
    private boolean activeUser;


    public KeycloakUserInfoDto(String id, String userName, String email, String password, String firstname, String lastName, String customer_service_man_id, boolean activeUser) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastName = lastName;
        this.customer_service_man_id = customer_service_man_id;
        this.activeUser = activeUser;

    }

    public KeycloakUserInfoDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomer_service_man_id() {
        return customer_service_man_id;
    }

    public void setCustomer_service_man_id(String customer_service_man_id) {
        this.customer_service_man_id = customer_service_man_id;
    }

    public boolean isActiveUser() {
        return activeUser;
    }

    public void setActiveUser(boolean activeUser) {
        this.activeUser = activeUser;
    }

}
