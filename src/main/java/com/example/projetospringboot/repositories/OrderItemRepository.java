package com.example.projetospringboot.repositories;

import com.example.projetospringboot.entities.OrderItem;
import com.example.projetospringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


}
