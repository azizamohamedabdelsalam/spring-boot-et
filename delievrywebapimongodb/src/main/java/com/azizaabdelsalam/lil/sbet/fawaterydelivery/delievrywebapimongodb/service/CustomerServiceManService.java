package com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.service;

import com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.data.CustomerServiceManRepository;
import com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.model.CustomerIdDto;
import com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.model.CustomerServiceMan;
import com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.model.KeycloakUserInfoDto;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerServiceManService {
    @Autowired
    private final CustomerServiceManRepository customerServiceManRepository;

    public CustomerServiceManService(CustomerServiceManRepository customerServiceManRepository) {
        this.customerServiceManRepository = customerServiceManRepository;
    }

    public boolean checkCustomerServiceManExistedById(String id){
        return customerServiceManRepository.existsById(id);
    }


    public List<CustomerServiceMan> getCustomerServiceMen(){
        return customerServiceManRepository.findAll();
    }

    public KeycloakUserInfoDto getUserInfoByToken(){
        KeycloakUserInfoDto user = new KeycloakUserInfoDto();
        KeycloakAuthenticationToken authentication =
                (KeycloakAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Principal principal = (Principal) authentication.getPrincipal();
        if (principal instanceof KeycloakPrincipal) {
            KeycloakPrincipal<KeycloakSecurityContext> kPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) principal;
            AccessToken token = kPrincipal.getKeycloakSecurityContext().getToken();
            user.setId(token.getId());
            user.setUserName(token.getPreferredUsername());
            Map<String, Object> otherClaims = token.getOtherClaims();
            if  (otherClaims.containsKey("applicationUserId")) {
                user.setApplicationUserId(String.valueOf(otherClaims.get("applicationUserId")));
            }
        }
        return user;
    }

    public Optional<CustomerServiceMan> getCustomerServiceManById(){
        KeycloakUserInfoDto CSMUserMap = getUserInfoByToken();
        String CSMId = CSMUserMap.getApplicationUserId();
        return customerServiceManRepository.findById(CSMId);
    }

    /*--- Get Customers list with thier orders with known CSM ID who is responsible to deliver*/
    public ArrayList<CustomerIdDto> getCustListPerCSMId(){

        String CSMId = "62b2547f1ea5032b889c047d";
        //  AggregationResult <CustomerServiceMan> results;
        //results = mongoTemplate.aggregate(aggregation, "CustomerIdDto", CustomerServiceMan.class);
        //List<CustomerServiceMan> tapes;
        //tapes = results.getMappedResults();

        return customerServiceManRepository.findCustomerslistByCSMId(CSMId);
    }
}
