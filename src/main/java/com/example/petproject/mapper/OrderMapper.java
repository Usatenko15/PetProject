package com.example.petproject.mapper;

import com.example.petproject.DTO.OrderGetAllDTO;
import com.example.petproject.DTO.OrderGetDTO;
import com.example.petproject.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderGetDTO OrderToDTO(Order order);
    OrderGetAllDTO OrderToAllDTO(Order order);
    List<OrderGetDTO> ListOrderToDTO(List<Order> orders);
    List<OrderGetAllDTO> ListOrderAllToDTO(List<Order> orders);
}
