package com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.security;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.session.HttpSessionEventPublisher;
/*how to set up Spring Security and use it in conjunction with Keycloak. */
/* Keycloak provides a KeycloakWebSecurityConfigurerAdapter as a convenient base class for creating a WebSecurityConfigurer instance.
This is helpful because any application secured by Spring Security requires a configuration class that extends WebSecurityConfigurerAdapter:*/


@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
//The @KeycloakConfiguration annotation is a metadata annotation that defines all of the annotations required to use Keycloak with Spring Security.
@KeycloakConfiguration
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    /* --
    Unlike the other Keycloak Adapters, you should not configure your security in web.xml. However, keycloak.json is still required.
     In order for Single Sign Out to work properly you have to define a session listener.
     */
    @Bean
    public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
    }

    /* --Registers the KeycloakAuthenticationProvider with the authentication manager. --*/
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        KeycloakAuthenticationProvider keycloakAuthenticationProvider  = keycloakAuthenticationProvider();
        var mapper = new SimpleAuthorityMapper();
       // mapper.setConvertToUpperCase(true);
        //mapper.setPrefix("");
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(mapper);
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }


    /**
     * Defines the session authentication strategy so that RegisterSessionAuthenticationStrategy  is used for public or confidential applications.
     */

    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(buildSessionRegistry());
    }

    @Bean
    protected SessionRegistry buildSessionRegistry() {
        return new SessionRegistryImpl();
    }



    //By Default, the Spring Security Adapter looks for a keycloak.json configuration file. You can make sure it looks at the configuration provided by the Spring Boot Adapter by adding this bean
    @Bean
    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {

        return new KeycloakSpringBootConfigResolver();
    }

    //We define our security constraints here based on a selection match.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests()
                .antMatchers("/api*").hasRole("ADMIN")
                .anyRequest().authenticated();

    }
}