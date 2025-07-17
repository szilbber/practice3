package com.example.restaurant.dto;

import lombok.Value;

@Value
public class RestaurantResponseDTO {
    Long id;
    String name;
    String description;
    String cuisineType;
    Integer averageCheck;
    Double rating;
}