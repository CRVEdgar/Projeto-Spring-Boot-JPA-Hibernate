package com.example.projetospringboot.resources;
//classe que implementa os recursos da aplicacao

import com.example.projetospringboot.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users") //caminho do diretorio (link)
public class UserResources {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Edgar", "edgar@gmail.com", "999999", "12345");
        return ResponseEntity.ok().body(u);
    }
}
