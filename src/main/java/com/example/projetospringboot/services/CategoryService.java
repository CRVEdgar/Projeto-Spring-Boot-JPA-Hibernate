package com.example.projetospringboot.services;

import com.example.projetospringboot.entities.Category;
import com.example.projetospringboot.entities.User;
import com.example.projetospringboot.repositories.CategoryRepository;
import com.example.projetospringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository; //UseService -> UserRepository

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);

        return obj.get();
    }
}
