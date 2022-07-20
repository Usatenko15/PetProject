package com.example.petproject.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CustomerGetDTO {
    private Long id;
    private String name;
    private List<OrderGetAllDTO> orders;
}
