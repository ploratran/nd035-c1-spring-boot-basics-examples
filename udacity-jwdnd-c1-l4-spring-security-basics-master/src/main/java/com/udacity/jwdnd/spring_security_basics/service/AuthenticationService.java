package com.udacity.jwdnd.spring_security_basics.service;

import com.udacity.jwdnd.spring_security_basics.mapper.UserMapper;
import com.udacity.jwdnd.spring_security_basics.model.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;

@Service
// implement Spring's Interface AuthenticationProvider:
public class AuthenticationService implements AuthenticationProvider {
    private UserMapper userMapper;
    private HashService hashService;

    public AuthenticationService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    @Override
    // provide a hook for Spring's security, integrate with Spring's many auth schemes:
    // authenticate() used by Spring to check user credential using Spring's special login form:
    // here we implement how Spring use authenticate() to check user credentials:
    // Authentication is Spring's generic object from user input:
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // extract username and password from the user input in "authentication" object:
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // use @Mapper to check if we have that username in database:
        User user = userMapper.getUser(username);
        if (user != null) {
            String encodedSalt = user.getSalt();
            // hash input password with current salt and HashService
            String hashedPassword = hashService.getHashedValue(password, encodedSalt);
            // compare the result with user's actual password:
            if (user.getPassword().equals(hashedPassword)) {
                // if match, return a username, password auth token:
                // is a special class that represent successful auth of a specific username and password:
                // ArrayList<>() contains list of granted authorities (permissions users are granted):
                return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            }
        }

        return null;
    }

    @Override
    // tells Spring which auth scheme to use in this class (here is UsernamePassword auth scheme):
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
