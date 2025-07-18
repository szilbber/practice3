package com.example.restaurant.mapper;

import com.example.restaurant.dto.ReviewRequestDTO;
import com.example.restaurant.dto.ReviewResponseDTO;
import com.example.restaurant.model.Review;
import com.example.restaurant.repository.VisitorRepository;
import com.example.restaurant.repository.RestaurantRepository;
import org.springframework.stereotype.Component;


@Component
public class ReviewMapper {

    private final VisitorRepository visitorRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewMapper(VisitorRepository visitorRepository, RestaurantRepository restaurantRepository) {
        this.visitorRepository = visitorRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Review toEntity(ReviewRequestDTO dto) {
        return new Review(
                null,
                dto.getRating(),
                dto.getText(),
                visitorRepository.findById(dto.getVisitorId()).orElseThrow(),
                restaurantRepository.findById(dto.getRestaurantId()).orElseThrow()
        );
    }

    public ReviewResponseDTO toResponseDTO(Review review) {
        return new ReviewResponseDTO(
                review.getId(),
                review.getVisitor().getId(),
                review.getRestaurant().getId(),
                review.getRating(),
                review.getText()
        );
    }
}