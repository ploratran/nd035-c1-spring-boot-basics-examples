package com.udacity.graphql.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * handle exception
 * should handle RuntimeException
 * implements GraphQLError
 * */
public class DogNotFoundException extends RuntimeException implements GraphQLError {

    // GraphQLError provides a field called "extensions":
    // allow user to pass additional data to the Error object sent back to client:
    private Map<String, Object> extensions = new HashMap<>();

    // constructor:
    public DogNotFoundException(String message, Long invalidDogId) {
        super(message);
        // adds to the extensions map the invalid dog id:
        extensions.put("invalidDogId", invalidDogId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }
}
