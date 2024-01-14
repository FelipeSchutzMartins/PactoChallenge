package com.pacto.config;

import com.pacto.exceptions.UsernameAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.AbstractMap;
import java.util.HashMap;

@RestControllerAdvice
class ExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AbstractMap<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        var errors = new HashMap<String, String>();
        ex.getBindingResult().getFieldErrors().forEach(it -> errors.put(it.getField(), it.getDefaultMessage()));
        return errors;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public AbstractMap<String, String> handleValidationExceptions(UsernameAlreadyExistsException ex) {
        var error = new HashMap<String, String>();
        error.put("Username already registered", ex.getMessage());
        return error;
    }

}
