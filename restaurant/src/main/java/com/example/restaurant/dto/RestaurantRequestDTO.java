package com.example.restaurant.dto;

import lombok.Value;

@Value

public class RestaurantRequestDTO {
    String name;
    String description;
    String cuisineType;
    Integer averageCheck;
}