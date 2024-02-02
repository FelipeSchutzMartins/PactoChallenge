package com.pacto.config;

import com.pacto.exceptions.UsernameAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Objects;

@RestControllerAdvice
class ExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AbstractMap<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        var errors = new HashMap<String, String>();
        var error = ex.getBindingResult().getFieldErrors().get(0);
        if (error != null) {
            errors.put("erro", error.getField() + ": " + error.getDefaultMessage());
        }
        return errors;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public AbstractMap<String, String> handleUsernameAlreadyExistException(UsernameAlreadyExistsException ex) {
        var error = new HashMap<String, String>();
        error.put("erro", "E-mail já cadastrado");
        return error;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(BadCredentialsException.class)
    public AbstractMap<String, String> handleBadCredentialsException(BadCredentialsException ex) {
        var error = new HashMap<String, String>();
        error.put("erro", "E-mail ou senha incorreto(s)");
        return error;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UsernameNotFoundException.class)
    public AbstractMap<String, String> handleUsernameNotFoundException(UsernameAlreadyExistsException ex) {
        var error = new HashMap<String, String>();
        error.put("erro", "E-mail de usuário não foi encontrado");
        return error;
    }

}
