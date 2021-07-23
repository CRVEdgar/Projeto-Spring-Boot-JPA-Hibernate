package com.example.projetospringboot.repositories;

import com.example.projetospringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
