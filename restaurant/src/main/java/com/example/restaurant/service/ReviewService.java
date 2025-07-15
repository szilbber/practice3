package com.example.restaurant.service;

import com.example.restaurant.model.Restaurant;
import org.springframework.stereotype.Service;
import com.example.restaurant.model.Review;
import com.example.restaurant.repository.ReviewRepository;
import com.example.restaurant.repository.RestaurantRepository;

import java.math.BigDecimal;
import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public void save(Review review) {
        reviewRepository.save(review);
        updateAverageRating(review.getRestaurantId());
    }

    public boolean remove(Review review) {
        boolean removed = reviewRepository.remove(review);
        if (removed) {
            updateAverageRating(review.getRestaurantId());
        }
        return removed;
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    private void updateAverageRating(Long restaurantId) {
        List<Review> reviews = reviewRepository.findAll().stream()
                .filter(r -> r.getRestaurantId().equals(restaurantId))
                .toList();

        double average = reviews.stream()
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0);

        Restaurant restaurantToUpdate = null;
        for (Restaurant restaurant : restaurantRepository.findAll()) {
            if (restaurant.getId().equals(restaurantId)) {
                restaurantToUpdate = restaurant;
                break;
            }
        }

        if (restaurantToUpdate != null) {
            Restaurant updated = new Restaurant(
                    restaurantToUpdate.getId(),
                    restaurantToUpdate.getName(),
                    restaurantToUpdate.getDescription(),
                    restaurantToUpdate.getCuisineType(),
                    restaurantToUpdate.getAverageCheck(),
                    BigDecimal.valueOf(average)
            );
            restaurantRepository.save(updated);
        }
    }
}