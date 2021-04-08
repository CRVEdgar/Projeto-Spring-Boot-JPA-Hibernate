package com.example.projetospringboot.services;

import com.example.projetospringboot.entities.User;
import com.example.projetospringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository; //UseService -> UserRepository

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);

        return obj.get();
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(long id){
        repository.deleteById(id);
    }

    public User update(Long id, User obj){
        User entity = repository.getOne(id); //[getOne] monitora o objeto no JPA pra poder trabalhar com ele, sem precisar ir no BD
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
