package com.example.projetospringboot.resources.exceptions;

import com.example.projetospringboot.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) //anotacao serve para retornar um ResponseEntity toda vez que uma excecao do tipo especificado for encontrada
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest requested){
        String error = "RESOURCE NOT FOUND";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), requested.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
