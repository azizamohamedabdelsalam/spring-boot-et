/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unilever.erada_cls.keycloak.service;

import com.google.gson.Gson;
import com.unilever.erada_cls.exceptions.BusinessException;
import com.unilever.erada_cls.keycloak.enums.RoleTypeEnum;
import com.unilever.erada_cls.keycloak.model.decoded_token.KeycloakAttributes;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Base64;
import java.util.logging.Level;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sayed.Hakim
 */
@Service
public class KeycloakService {

    public KeycloakAttributes getKeycloakAttributes() {
        KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Principal principal = (Principal) authentication.getPrincipal();
        KeycloakAttributes decodedToken = null;
        if (principal instanceof KeycloakPrincipal) {
            KeycloakPrincipal kPrincipal = (KeycloakPrincipal) principal;
            String tokenString = kPrincipal.getKeycloakSecurityContext().getTokenString();
            try {
                decodedToken = getDecoded(tokenString);
            } catch (UnsupportedEncodingException ex) {
                java.util.logging.Logger.getLogger(KeycloakService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (decodedToken == null) {
            throw new BusinessException("can't authorize user");
        }
        return decodedToken;
    }

    public Long getEradaId() {
        Long eradaId = null;
        try {
            eradaId = Long.parseLong(getKeycloakAttributes().getEradaId());
        } catch (Exception e) {
            throw new BusinessException("can't authorize user when getting erada id " + e.getMessage());
        }
        return eradaId;
    }

    KeycloakAttributes getDecoded(String encodedToken) throws UnsupportedEncodingException {
        String[] pieces = encodedToken.split("\\.");
        String b64payload = pieces[1];
        String jsonString = new String(Base64.getDecoder().decode(b64payload), "UTF-8");
        //  String jsonString = new String(Base64.getDecoder().decode(b64payload));
        return new Gson().fromJson(jsonString, KeycloakAttributes.class);
    }

    public boolean validateRole(String role) {
        try {
            return getKeycloakAttributes().getResourceAccess().getEradaBE().getRoles().contains(role);
        } catch (Exception e) {
            throw new BusinessException("can't authorize role");
        }
    }

    public boolean isUserAdmin() {
        return validateRole(RoleTypeEnum.ROLE_ADMIN.name());
    }

    public boolean isUserTeamlead() {
        return validateRole(RoleTypeEnum.ROLE_TEAMLEAD.name());
    }

    public boolean isUserSalesman() {
        return validateRole(RoleTypeEnum.ROLE_SALESMAN.name());
    }
}
