package com.unilever.erada_cls.keycloak.model.decoded_token;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.annotation.Generated;

//-----------------------------------com.unilever.erada_cls.keycloak.model.KeycloakAttributes.java-----------------------------------
@Generated("jsonschema2pojo")
public class KeycloakAttributes {

    @SerializedName("exp")
    @Expose
    private Integer exp;
    @SerializedName("iat")
    @Expose
    private Integer iat;
    @SerializedName("auth_time")
    @Expose
    private Integer authTime;
    @SerializedName("jti")
    @Expose
    private String jti;
    @SerializedName("iss")
    @Expose
    private String iss;
    @SerializedName("aud")
    @Expose
    private List<String> aud = null;
    @SerializedName("sub")
    @Expose
    private String sub;
    @SerializedName("typ")
    @Expose
    private String typ;
    @SerializedName("azp")
    @Expose
    private String azp;
    @SerializedName("nonce")
    @Expose
    private String nonce;
    @SerializedName("session_state")
    @Expose
    private String sessionState;
    @SerializedName("acr")
    @Expose
    private String acr;
    @SerializedName("allowed-origins")
    @Expose
    private List<String> allowedOrigins = null;
    @SerializedName("realm_access")
    @Expose
    private RealmAccess realmAccess;
    @SerializedName("resource_access")
    @Expose
    private ResourceAccess resourceAccess;
    @SerializedName("scope")
    @Expose
    private String scope;
    @SerializedName("sid")
    @Expose
    private String sid;
    @SerializedName("email_verified")
    @Expose
    private Boolean emailVerified;
    @SerializedName("preferred_username")
    @Expose
    private String preferredUsername;
    @SerializedName("erada_id")
    @Expose
    private String eradaId;

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getIat() {
        return iat;
    }

    public void setIat(Integer iat) {
        this.iat = iat;
    }

    public Integer getAuthTime() {
        return authTime;
    }

    public void setAuthTime(Integer authTime) {
        this.authTime = authTime;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public List<String> getAud() {
        return aud;
    }

    public void setAud(List<String> aud) {
        this.aud = aud;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getAzp() {
        return azp;
    }

    public void setAzp(String azp) {
        this.azp = azp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSessionState() {
        return sessionState;
    }

    public void setSessionState(String sessionState) {
        this.sessionState = sessionState;
    }

    public String getAcr() {
        return acr;
    }

    public void setAcr(String acr) {
        this.acr = acr;
    }

    public List<String> getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(List<String> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public RealmAccess getRealmAccess() {
        return realmAccess;
    }

    public void setRealmAccess(RealmAccess realmAccess) {
        this.realmAccess = realmAccess;
    }

    public ResourceAccess getResourceAccess() {
        return resourceAccess;
    }

    public void setResourceAccess(ResourceAccess resourceAccess) {
        this.resourceAccess = resourceAccess;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getPreferredUsername() {
        return preferredUsername;
    }

    public void setPreferredUsername(String preferredUsername) {
        this.preferredUsername = preferredUsername;
    }

    public String getEradaId() {
        return eradaId;
    }

    public void setEradaId(String eradaId) {
        this.eradaId = eradaId;
    }

    //---------------- helper methods --------------------
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

}
