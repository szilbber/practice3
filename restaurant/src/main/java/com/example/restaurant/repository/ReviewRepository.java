package com.example.restaurant.repository;

import com.example.restaurant.model.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReviewRepository {

    private final List<Review> reviews = new ArrayList<>();

    public Review save(Review review) {
        Optional<Review> existing = reviews.stream()
                .filter(r -> r.getId() != null && r.getId().equals(review.getId()))
                .findFirst();

        existing.ifPresent(reviews::remove);

        reviews.add(review);
        return review;
    }

    public List<Review> findAll() {
        return new ArrayList<>(reviews);
    }

    public Optional<Review> findById(Long id) {
        return reviews.stream()
                .filter(r -> r.getId() != null && r.getId().equals(id))
                .findFirst();
    }

    public void deleteById(Long id) {
        reviews.removeIf(r -> r.getId() != null && r.getId().equals(id));
    }
}