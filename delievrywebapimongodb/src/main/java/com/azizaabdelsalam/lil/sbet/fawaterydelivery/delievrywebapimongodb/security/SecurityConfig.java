package com.azizaabdelsalam.lil.sbet.fawaterydelivery.delievrywebapimongodb.security;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
/*how to set up Spring Security and use it in conjunction with Keycloak. */
/* Keycloak provides a KeycloakWebSecurityConfigurerAdapter as a convenient base class for creating a WebSecurityConfigurer instance.
This is helpful because any application secured by Spring Security requires a configuration class that extends WebSecurityConfigurerAdapter:*/

@EnableWebSecurity
@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
@Configuration
//The @KeycloakConfiguration annotation is a metadata annotation that defines all of the annotations required to use Keycloak with Spring Security.
@KeycloakConfiguration
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    //Registers the KeycloakAuthenticationProvider with the authentication manager.
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider  = keycloakAuthenticationProvider();
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }

    //Defines the session authentication strategy. RegisterSessionAuthenticationStrategy  is used for public or confidential applications.
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    //Instead of the default Keycloak.json, use the Spring Boot properties file.
    @Bean
    @Primary
    public KeycloakSpringBootConfigResolver keycloakConfigResolver(KeycloakSpringBootProperties properties) {

        return new CustomKeycloakSpringBootConfigResolver(properties);
    }

    //We define our security constraints here based on a selection match.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests()
                .antMatchers("/","/api/*").permitAll()
                .anyRequest()
                .authenticated();
    }
}