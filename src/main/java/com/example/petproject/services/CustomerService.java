package com.example.petproject.services;

import com.example.petproject.DTO.CustomerGetAllDTO;
import com.example.petproject.DTO.CustomerGetDTO;
import com.example.petproject.DTO.OrderGetAllDTO;
import com.example.petproject.entity.Customer;
import com.example.petproject.entity.Order;
import com.example.petproject.mapper.CustomerMapper;
import com.example.petproject.mapper.OrderMapper;
import com.example.petproject.repository.CustomerRepository;
import com.example.petproject.repository.OrderRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Transactional(readOnly = true)
    public List<CustomerGetAllDTO> findAll() {
        return customerMapper.ListCustomerAllToDTO(customerRepository.findAll());
    }

    public CustomerGetDTO save(Customer customer) {
        return customerMapper.CustomerToDTO(customerRepository.save(customer));
    }

    @Transactional(readOnly = true)
    public CustomerGetDTO findById(Long customerId) {
        return customerMapper.CustomerToDTO(customerRepository.findById(customerId).orElseThrow());
    }

    @Transactional
    public CustomerGetDTO saveOrderToCustomer(Long customerId, Order order) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        order.setCustomer(customer);
        orderRepository.save(order);
        return customerMapper.CustomerToDTO(customer);
    }

    @Transactional
    public boolean deleteById(Long customerId) {
        customerRepository.deleteById(customerId);
        return true;
    }

    @Transactional(readOnly = true)
    public List<OrderGetAllDTO> findOrdersByCustomerId(Long customerId) {
        return orderMapper.ListOrderAllToDTO(orderRepository.findOrdersByCustomerId(customerId));
    }
}
