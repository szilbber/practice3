package com.example.restaurant.repository;

import com.example.restaurant.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RestaurantRepository {

    private final List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant save(Restaurant restaurant) {
        Optional<Restaurant> existing = restaurants.stream()
                .filter(r -> r.getId() != null && r.getId().equals(restaurant.getId()))
                .findFirst();

        existing.ifPresent(restaurants::remove);

        restaurants.add(restaurant);
        return restaurant;
    }

    public List<Restaurant> findAll() {
        return new ArrayList<>(restaurants);
    }

    public Optional<Restaurant> findById(Long id) {
        return restaurants.stream()
                .filter(r -> r.getId() != null && r.getId().equals(id))
                .findFirst();
    }

    public void deleteById(Long id) {
        restaurants.removeIf(r -> r.getId() != null && r.getId().equals(id));
    }
}