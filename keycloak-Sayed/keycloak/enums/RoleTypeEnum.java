/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unilever.erada_cls.keycloak.enums;

/**
 *
 * @author Sayed.Hakim
 */
public enum RoleTypeEnum {
    ROLE_ADMIN("ADMIN"), ROLE_TEAMLEAD("TEAMLEAD"), ROLE_SALESMAN("SALESMAN");
    String code = "";

    RoleTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
