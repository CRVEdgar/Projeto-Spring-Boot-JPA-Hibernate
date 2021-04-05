package com.example.projetospringboot.resources;
//classe que implementa os recursos da aplicacao

import com.example.projetospringboot.entities.Category;
import com.example.projetospringboot.entities.User;
import com.example.projetospringboot.services.CategoryService;
import com.example.projetospringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories") //caminho do diretorio (link)
public class CategoryResources {

    @Autowired
    private CategoryService service; //UserResources -> UseService

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> lista = service.findAll();

        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
