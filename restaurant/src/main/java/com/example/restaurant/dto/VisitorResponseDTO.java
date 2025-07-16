package com.example.restaurant.dto;

import lombok.Value;

@Value
public class VisitorResponseDTO {
    Long id;
    String name;
    int age;
    String gender;
}
