package com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.controller;

import com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.model.CSMView;
import com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.model.CustomerServiceMan;
import com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.model.KeycloakUserInfoDto;
import com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.service.CustomerServiceManService;
import com.fasterxml.jackson.annotation.JsonView;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
public class CustomerServiceManRestController {

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @Autowired
    private final CustomerServiceManService customerServiceManService;

    public CustomerServiceManRestController(CustomerServiceManService customerServiceManService) {
        this.customerServiceManService = customerServiceManService;
    }


    @GetMapping("/ALLCSM")
    public List<CustomerServiceMan> getCustomerServiceMen() {
        return customerServiceManService.getCustomerServiceMen();
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
            user.setUserName(token.getName());
            Map<String, Object> otherClaims = token.getOtherClaims();
            if  (otherClaims.containsKey("applicationUserId")) {
                user.setApplicationUserId(String.valueOf(otherClaims.get("applicationUserId")));
            }
        }
        return user;
    }


    @JsonView(CSMView.CSMPublic.class)
    @GetMapping("/CSMData")
    public ResponseEntity<?> getCSMPublicDataById(){
        KeycloakUserInfoDto CSMUserMap = getUserInfoByToken();
        String CSMId = CSMUserMap.getApplicationUserId();
        if (customerServiceManService.checkCustomerServiceManExistedById(CSMId)){
            Optional <CustomerServiceMan> customerServiceMan = customerServiceManService.getCustomerServiceManById(CSMId);
            return new ResponseEntity<Optional<CustomerServiceMan>>(customerServiceMan, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("No Such Customer Service Man Account",HttpStatus.NOT_FOUND);
        }
    }









}
