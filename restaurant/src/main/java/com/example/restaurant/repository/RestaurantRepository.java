package com.example.restaurant.repository;

import com.example.restaurant.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
@Repository
public class RestaurantRepository {

    private final List<Restaurant> restaurants = new ArrayList<>();

    public void save(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public boolean remove(Restaurant restaurant) {
        return restaurants.remove(restaurant);
    }

    public List<Restaurant> findAll() {
        return new ArrayList<>(restaurants);
    }
}
