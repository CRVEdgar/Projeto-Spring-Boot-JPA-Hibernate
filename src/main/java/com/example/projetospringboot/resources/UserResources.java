package com.example.projetospringboot.resources;
//classe que implementa os recursos da aplicacao

import com.example.projetospringboot.entities.User;
import com.example.projetospringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users") //caminho do diretorio (link)
public class UserResources {

    @Autowired
    private UserService service; //UserResources -> UseService

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> lista = service.findAll();

        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
