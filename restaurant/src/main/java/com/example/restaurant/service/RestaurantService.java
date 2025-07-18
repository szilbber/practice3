package com.example.restaurant.service;

import com.example.restaurant.dto.RestaurantRequestDTO;
import com.example.restaurant.dto.RestaurantResponseDTO;
import com.example.restaurant.mapper.RestaurantMapper;
import com.example.restaurant.model.CuisineType;
import com.example.restaurant.model.Restaurant;
import com.example.restaurant.repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@Transactional
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    public List<RestaurantResponseDTO> findAll() {
        return restaurantRepository.findAll().stream()
                .map(restaurantMapper::toResponseDTO)
                .toList();
    }

    public RestaurantResponseDTO findById(Long id) {
        return restaurantMapper.toResponseDTO(
                restaurantRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Ресторан не найден")));
    }

    public RestaurantResponseDTO save(RestaurantRequestDTO dto) {
        return restaurantMapper.toResponseDTO(
                restaurantRepository.save(restaurantMapper.toEntity(dto)));
    }

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