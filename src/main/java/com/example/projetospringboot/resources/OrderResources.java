package com.example.projetospringboot.resources;
//classe que implementa os recursos da aplicacao

import com.example.projetospringboot.entities.Order;
import com.example.projetospringboot.entities.User;
import com.example.projetospringboot.services.OrderService;
import com.example.projetospringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders") //caminho do diretorio (link)
public class OrderResources {

    @Autowired
    private OrderService service; //UserResources -> UseService

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> lista = service.findAll();

        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
