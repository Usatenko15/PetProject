package com.example.petproject.repository;

import com.example.petproject.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrdersByCustomerId(Long customerId);
}
