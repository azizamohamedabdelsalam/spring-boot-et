package com.azizaabdelsalam.lil.sbet.delivery.customerservicemaninfoapi;

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

@Service
public class CustomerServiceManService {

    public CustomerServiceManService() {

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
        Branch branch = new Branch("br1","BranchNameTest");
        CustomerServiceMan customerServiceMan = new CustomerServiceMan(CSMId,"cust.Service Man Name Test",branch) ;
        return customerServiceMan;
    }
    public List<CustomerIdDto> getCustListByCustomerServiceManId(){
        KeycloakUserInfoDto CSMUserMap = getUserInfoByToken();
        String CSMId = CSMUserMap.getCustomer_service_man_id();
        List<String> orderIdsList1=new ArrayList<String>();
        orderIdsList1.add("ord1");
        orderIdsList1.add("ord2");

        List<String> orderIdsList2=new ArrayList<String>();
        orderIdsList2.add("ord3");
        orderIdsList2.add("ord4");


         List<CustomerIdDto> customerIdDtoList = new ArrayList<CustomerIdDto>();
        customerIdDtoList.add(new CustomerIdDto("Cust1",orderIdsList1));
        customerIdDtoList.add(new CustomerIdDto("Cust2",orderIdsList2));
        return customerIdDtoList;
    }
}
