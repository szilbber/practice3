package com.example.restaurant.dto;

import lombok.Value;
import com.example.restaurant.model.CuisineType;

@Value
public class RestaurantRequestDTO {
    String name;
    String description;
    CuisineType cuisineType;
    int capacity;
}