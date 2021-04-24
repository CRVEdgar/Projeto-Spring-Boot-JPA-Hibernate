package com.example.projetospringboot.resources.exceptions;

import com.example.projetospringboot.services.exceptions.DatabaseException;
import com.example.projetospringboot.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    //EXCESSAO CASO NAO SEJA ENCONTRADA A INFORMACAO
    @ExceptionHandler(ResourceNotFoundException.class) //anotacao serve para retornar um ResponseEntity toda vez que uma excecao do tipo especificado for encontrada
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest requested){
        String error = "RESOURCE NOT FOUND ";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), requested.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    //EXCESSAO CASO O ATRIBUTO ESTEJA RELACIONADO COM OUTRA TABELA
    @ExceptionHandler(DatabaseException.class) //anotacao serve para retornar um ResponseEntity toda vez que uma excecao do tipo especificado for encontrada
    public ResponseEntity<StandardError> dataBase(DatabaseException e, HttpServletRequest requested){
        String error = "DataBase Error ";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), requested.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
