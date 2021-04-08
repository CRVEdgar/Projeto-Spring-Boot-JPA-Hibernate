package com.example.projetospringboot.resources;
//classe que implementa os recursos da aplicacao

import com.example.projetospringboot.entities.User;
import com.example.projetospringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController //Controlador Rest
@RequestMapping(value = "/users") //caminho do diretorio (link)
public class UserResources {

    @Autowired
    private UserService service; //UserResources -> UseService

    @GetMapping //utilizado para fazer uma busca
    public ResponseEntity<List<User>> findAll(){
        List<User> lista = service.findAll();

        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping //usado quando for inserir um novo recurso
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
