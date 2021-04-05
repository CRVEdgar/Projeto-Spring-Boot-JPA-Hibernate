package com.example.projetospringboot.services;

import com.example.projetospringboot.entities.Order;
import com.example.projetospringboot.entities.User;
import com.example.projetospringboot.repositories.OrderRepository;
import com.example.projetospringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository; //UseService -> UserRepository

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);

        return obj.get();
    }
}
