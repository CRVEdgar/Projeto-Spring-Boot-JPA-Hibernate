package com.example.projetospringboot.services;

import com.example.projetospringboot.entities.User;
import com.example.projetospringboot.repositories.UserRepository;
import com.example.projetospringboot.services.exceptions.DatabaseException;
import com.example.projetospringboot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); //retorna o objeto do Id localizado, ou laca uma exception
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(long id){
        try{
            repository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){ // capturando excessoes quando eh soliciada exclusao de atributos que estao relacionados a outros em outra tabela
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
        try{
            User entity = repository.getOne(id); //[getOne] monitora o objeto no JPA pra poder trabalhar com ele, sem precisar ir no BD
            updateData(entity, obj);
            return repository.save(entity);
        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
