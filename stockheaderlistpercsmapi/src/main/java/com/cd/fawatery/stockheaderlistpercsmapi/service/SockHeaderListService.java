package com.cd.fawatery.stockheaderlistpercsmapi.service;

import com.cd.fawatery.stockheaderlistpercsmapi.data.StockHeaderListRepository;
import com.cd.fawatery.stockheaderlistpercsmapi.model.KeycloakUserInfoDto;
import com.cd.fawatery.stockheaderlistpercsmapi.model.StockHeader;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Map;
@Service
public class SockHeaderListService {

    private final StockHeaderListRepository  stockHeaderListRepository;

    public SockHeaderListService(StockHeaderListRepository stockHeaderListRepository) {
        this.stockHeaderListRepository = stockHeaderListRepository;
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
    public List<StockHeader> getStockHeaderListByCustomerServiceManId(){
        KeycloakUserInfoDto CSMUserMap = getUserInfoByToken();
        String CSMId = CSMUserMap.getCustomer_service_man_id();
        /*Item item1 = new Item("itemNO1","itemNameA1");
        Item item2 = new Item("itemNO2","itemNameA2");
        Item item3 = new Item("itemNO3","itemNameA3");
        List<StockHeader> stList = new ArrayList<>();
        stList.add(new StockHeader(item1,CSMId,500,200,0,400,200,0,150,0,0));
        stList.add(new StockHeader(item2,CSMId,100,100,0,100,100,0,0,0,0));
        stList.add(new StockHeader(item3,CSMId,0,0,0,(float)20.5,5,0,0,0,0));
        return stList;*/
        return (stockHeaderListRepository.findBycsmNo(CSMId));
    }

}
