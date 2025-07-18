package com.example.restaurant.service;

import org.springframework.stereotype.Service;
import com.example.restaurant.model.Restaurant;
import com.example.restaurant.repository.RestaurantRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public void save(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public boolean remove(Restaurant restaurant) {
        return restaurantRepository.remove(restaurant);
    }

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }
}