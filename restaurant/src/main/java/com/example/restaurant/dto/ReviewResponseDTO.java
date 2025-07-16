package com.example.restaurant.dto;

import lombok.Value;

@Value
public class ReviewResponseDTO {
    Long id;
    Long visitorId;
    Long restaurantId;
    int rating;
    String text;
}