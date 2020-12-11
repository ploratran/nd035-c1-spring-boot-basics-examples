package com.udacity.jwdnd.spring_security_basics.service;

import com.udacity.jwdnd.spring_security_basics.mapper.UserMapper;
import com.udacity.jwdnd.spring_security_basics.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {

    // fields:
    private final UserMapper userMapper;
    private final HashService hashService;

    // constructor:
    public UserService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    // check to see if username already exist in database (if null):
    public boolean isUsernameAvailable(String username) {
        return userMapper.getUser(username) == null;
    }

    public int createUser(User user) {
        // provides a cryptographically strong random number generator:
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        // generate random salt value:
        random.nextBytes(salt);
        // encode base65 of the salt so that HashService understands:
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        // get hash value from user plain-text password with salt using HashService method:
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
        // insert secured user credentials into User database:
        return userMapper.insert(new User(null, user.getUsername(), encodedSalt, hashedPassword, user.getFirstName(), user.getLastName()));
    }

    // get a particular user by username using Mapper to query from database
    // return User object:
    public User getUser(String username) {
        return userMapper.getUser(username);
    }
}
