package com.example.petproject.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderGetAllDTO {
    private Long id;
    private String description;
    private boolean isDone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
