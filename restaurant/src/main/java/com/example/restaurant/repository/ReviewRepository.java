package com.example.restaurant.repository;

import com.example.restaurant.model.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.Getter;


@Getter
@Repository
public class ReviewRepository {

    private final List<Review> reviews = new ArrayList<>();

    public void save(Review review) {
        reviews.add(review);
    }

    public boolean remove(Review review) {
        return reviews.remove(review);
    }

    public Optional<Review> findById(Long id) {
        return reviews.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }

    public List<Review> findAll() {
        return new ArrayList<>(reviews);
    }
}