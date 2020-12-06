package com.udacity.jwdnd.spring_security_basics.config;

import com.udacity.jwdnd.spring_security_basics.mapper.UserMapper;
import com.udacity.jwdnd.spring_security_basics.service.AuthenticationService;
import com.udacity.jwdnd.spring_security_basics.service.HashService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.ArrayList;

@Configuration
// @Configuration: defines the source of configuration in Spring IoC
@EnableWebSecurity
// @EnableWebSecurity lets Spring knows that it configures Spring Security

// WebSecurityConfigureAdapter is an adapter for Spring's WebSecurityConfigure:
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationService authenticationService;

    // inject authenticationService in the constructor like Spring bean:
    public SecurityConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    // configure Spring Authentication Manager

    // take AuthenticationManagerBuilder class supplied by Spring:
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        // called method of the builder class
        // to configure parts of auth scheme to use
        // authenticationService to check user logins
        auth.authenticationProvider(this.authenticationService);
    }

    // use complex DSL to use method chaining (like promises)
    // define how Spring receives Auth requests
    // which page(s) requires auth access
    // how to handle logout:
    @Override
    // generic Spring object "HttpSecurity"
    protected void configure(HttpSecurity http) throws Exception {
        // .authorizeRequests(): specifies which requests to authorize and how
        // .antMatchers(): match requests against URLs accessible to all users
        // .permitAll(): allow all requests to URLs without auth
        // .anyRequest(): match any requests that are NOT match with first call
        // .authenticated(): authenticate any requests that have NOT been matched
        http.authorizeRequests()
                .antMatchers("/signup", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated();

        // /login are handled specially by Spring
        // call http.formLogin(), Spring will auto generate entire things for us
        // .permitAll(): accessible by anyone to the /login
        http.formLogin()
                .loginPage("/login")
                .permitAll();

        // add a default redirect on successful login to /home URL
        // help users to not manually type url when successfully login
        http.formLogin()
                .defaultSuccessUrl("/home", true);
    }
}
