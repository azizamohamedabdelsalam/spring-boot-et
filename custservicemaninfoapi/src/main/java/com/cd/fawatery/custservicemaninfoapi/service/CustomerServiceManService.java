package com.cd.fawatery.custservicemaninfoapi.service;

import com.cd.fawatery.custservicemaninfoapi.data.CustomerServiceManRepository;
import com.cd.fawatery.custservicemaninfoapi.model.CustomerServiceMan;
import com.cd.fawatery.custservicemaninfoapi.model.KeycloakUserInfoDto;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerServiceManService {
    @Autowired
    private final CustomerServiceManRepository customerServiceManRepository;

    public CustomerServiceManService(CustomerServiceManRepository customerServiceManRepository) {
        this.customerServiceManRepository = customerServiceManRepository;
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
               if  (otherClaims.containsKey("customer_service_man_id")) user.setCustomer_service_man_id(String.valueOf(otherClaims.get("customer_service_man_id")));
        }
        return user;
    }

    public Optional<CustomerServiceMan> getCustomerServiceManByCustomerServiceManId(){
        KeycloakUserInfoDto CSMUserMap = getUserInfoByToken();
        String CSMId = CSMUserMap.getCustomer_service_man_id();
        return customerServiceManRepository.findById(CSMId);
        //return customerServiceManRepository.findByCustomerServiceManId(CSMId);
    }

}
