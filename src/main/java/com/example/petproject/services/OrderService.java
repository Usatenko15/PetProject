package com.example.petproject.services;

import com.example.petproject.DTO.OrderGetAllDTO;
import com.example.petproject.DTO.OrderGetDTO;
import com.example.petproject.entity.Order;
import com.example.petproject.mapper.OrderMapper;
import com.example.petproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    public List<OrderGetAllDTO> findAll(){
        return orderMapper.ListOrderAllToDTO(orderRepository.findAll());
    }

    public OrderGetDTO save(Order order){
        return orderMapper.OrderToDTO(orderRepository.save(order));
    }

    public OrderGetDTO findById(Long orderId){
        return orderMapper.OrderToDTO(orderRepository.findById(orderId).orElseThrow());
    }

    public List<OrderGetAllDTO> findOrdersByCustomerId(Long customerId){
        return orderMapper.ListOrderAllToDTO(orderRepository.findOrdersByCustomerId(customerId));
    }

    public boolean deleteOrderById(Long orderId){
        orderRepository.deleteById(orderId);
        return true;
    }
}
