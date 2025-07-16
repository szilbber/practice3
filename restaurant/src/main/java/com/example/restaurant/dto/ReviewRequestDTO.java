package com.example.restaurant.dto;

import lombok.Value;

@Value
public class ReviewRequestDTO {
    Long visitorId;
    Long restaurantId;
    int rating;
    String text;
}