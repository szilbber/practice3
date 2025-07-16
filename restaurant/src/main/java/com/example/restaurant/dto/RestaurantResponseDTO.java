package com.example.restaurant.dto;

import lombok.Value;
import com.example.restaurant.model.CuisineType;

@Value
public class RestaurantResponseDTO {
    Long id;
    String name;
    String description;
    CuisineType cuisineType;
    int capacity;
    Double rating;
}