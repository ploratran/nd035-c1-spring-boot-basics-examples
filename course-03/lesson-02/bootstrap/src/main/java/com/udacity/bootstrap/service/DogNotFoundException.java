package com.udacity.bootstrap.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** use @ResponseStatus along with HttpStatus of NOT_FOUND
 * to return message if invalid id is used:
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Dog not found")
public class DogNotFoundException extends RuntimeException {

    // default constructor:
    public DogNotFoundException() {}

    public DogNotFoundException(String message) {
        // inherit error message from RuntimeException's message:
        super(message);
    }
}
