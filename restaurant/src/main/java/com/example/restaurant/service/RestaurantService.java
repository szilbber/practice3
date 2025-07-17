package com.example.restaurant.service;

import com.example.restaurant.dto.RestaurantRequestDTO;
import com.example.restaurant.dto.RestaurantResponseDTO;
import com.example.restaurant.mapper.RestaurantMapper;
import com.example.restaurant.model.CuisineType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.example.restaurant.model.Restaurant;
import com.example.restaurant.repository.RestaurantRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    @Transactional
    public RestaurantResponseDTO save(RestaurantRequestDTO dto) {
        Restaurant restaurant = restaurantMapper.toEntity(dto);
        return restaurantMapper.toResponseDTO(restaurantRepository.save(restaurant));
    }

    public List<RestaurantResponseDTO> findAll() {
        return restaurantRepository.findAll().stream()
                .map(restaurantMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public RestaurantResponseDTO findById(Long id) {
        return restaurantRepository.findById(id)
                .map(restaurantMapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Ресторан не найден"));
    }

    @Transactional
    public RestaurantResponseDTO update(Long id, RestaurantRequestDTO dto) {
        Restaurant existing = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ресторан не найден"));

        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setCuisineType(CuisineType.valueOf(dto.getCuisineType()));
        existing.setAverageCheck(dto.getAverageCheck());

        return restaurantMapper.toResponseDTO(restaurantRepository.save(existing));
    }

    public void deleteById(Long id) {
        restaurantRepository.deleteById(id);
    }
}