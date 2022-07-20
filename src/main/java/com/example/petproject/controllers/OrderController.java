package com.example.petproject.controllers;

import com.example.petproject.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public ResponseEntity findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity findOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.findById(orderId));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity deleteOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.deleteOrderById(orderId));
    }
}
