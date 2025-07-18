package com.example.restaurant.mapper;

import com.example.restaurant.dto.ReviewRequestDTO;
import com.example.restaurant.dto.ReviewResponseDTO;
import com.example.restaurant.model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public Review toEntity(ReviewRequestDTO dto) {
        return new Review(
                null,
                dto.getVisitorId(),
                dto.getRestaurantId(),
                dto.getRating(),
                dto.getText()
        );
    }

    public ReviewResponseDTO toResponseDTO(Review review) {
        return new ReviewResponseDTO(
                review.getId(),
                review.getVisitorId(),
                review.getRestaurantId(),
                review.getRating(),
                review.getText()
        );
    }
}