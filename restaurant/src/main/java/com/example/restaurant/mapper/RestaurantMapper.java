package com.example.restaurant.mapper;

import com.example.restaurant.dto.RestaurantRequestDTO;
import com.example.restaurant.dto.RestaurantResponseDTO;
import com.example.restaurant.model.Restaurant;
import com.example.restaurant.model.CuisineType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class RestaurantMapper {

    public Restaurant toEntity(RestaurantRequestDTO dto) {
        return new Restaurant(
                null,
                dto.getName(),
                dto.getDescription(),
                CuisineType.valueOf(dto.getCuisineType()),
                dto.getAverageCheck(),
                BigDecimal.ZERO
        );
    }

    public RestaurantResponseDTO toResponseDTO(Restaurant restaurant) {
        return new RestaurantResponseDTO(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getDescription(),
                restaurant.getCuisineType().toString(),
                restaurant.getAverageCheck(),
                restaurant.getRating() != null ? restaurant.getRating().doubleValue() : null
        );
    }
}