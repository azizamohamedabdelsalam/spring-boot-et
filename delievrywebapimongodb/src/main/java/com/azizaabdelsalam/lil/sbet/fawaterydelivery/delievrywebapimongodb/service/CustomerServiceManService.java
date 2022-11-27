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

    public List<CustomerServiceMan> getCustomerServiceMen(){
        return customerServiceManRepository.findAll();
    }

    public KeycloakUserInfoDto getUserInfoByToken()  {
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
                try{
                    if  (otherClaims.containsKey("customer_service_man_id")) user.setCustomer_service_man_id(String.valueOf(otherClaims.get("customer_service_man_id")));
                }
                catch (Exception e) {
                                    }
        }
        return user;
    }

    public CustomerServiceMan getCustomerServiceManByCustomerServiceManId(){
        KeycloakUserInfoDto CSMUserMap = getUserInfoByToken();
        String CSMId = CSMUserMap.getCustomer_service_man_id();
        return customerServiceManRepository.findByCustomerServiceManId(CSMId);
    }
    public List<CustomerIdDto> getCustListByCustomerServiceManId(){
        KeycloakUserInfoDto CSMUserMap = getUserInfoByToken();
        String CSMId = CSMUserMap.getCustomer_service_man_id();
        CustomerServiceMan customerServiceMan = customerServiceManRepository.findByCustomerServiceManId(CSMId);
        return customerServiceMan.getCustomerIdsList();
    }
}
