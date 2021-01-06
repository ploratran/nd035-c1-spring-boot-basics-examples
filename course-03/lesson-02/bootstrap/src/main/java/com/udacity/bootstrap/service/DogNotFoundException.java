package com.udacity.bootstrap.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** use @ResponseStatus along with HttpStatus of NOT_FOUND
 * to return message if invalid id is used:
 */

public class DogNotFoundException extends RuntimeException {
}
