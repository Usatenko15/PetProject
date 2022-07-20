package com.example.petproject.mapper;

import com.example.petproject.DTO.CustomerGetAllDTO;
import com.example.petproject.DTO.CustomerGetDTO;
import com.example.petproject.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerGetDTO CustomerToDTO(Customer customer);

    CustomerGetAllDTO CustomerAllToDTO(Customer customer);

    List<CustomerGetDTO> ListCustomerToDTO(List<Customer> orders);

    List<CustomerGetAllDTO> ListCustomerAllToDTO(List<Customer> orders);
}
