package com.example.petproject.controllers;

import com.example.petproject.DTO.CustomerGetDTO;
import com.example.petproject.entity.Customer;
import com.example.petproject.entity.Order;
import com.example.petproject.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public ResponseEntity findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping()
    public ResponseEntity saveCustomer(@RequestBody Customer customer){ return ResponseEntity.ok(customerService.save(customer));}

    @GetMapping("/{customerId}")
    public ResponseEntity findById(@PathVariable Long customerId){return ResponseEntity.ok(customerService.findById(customerId));}

    @GetMapping("/{customerId}/order")
    public ResponseEntity findOrderByCustomerId(@PathVariable Long customerId){return ResponseEntity.ok(customerService.findOrdersByCustomerId(customerId));}

    @PostMapping("/{customerId}/order")
    public ResponseEntity saveOrderToCustomer(@PathVariable Long customerId, @RequestBody Order order){
        return ResponseEntity.ok(customerService.saveOrderToCustomer(customerId, order));}

    @DeleteMapping("/{customerId}")
    public ResponseEntity deleteById(@PathVariable Long customerId){
        return ResponseEntity.ok(customerService.deleteById(customerId));
    }
}
