package com.example.restaurant;

import com.example.restaurant.dto.RestaurantRequestDTO;
import com.example.restaurant.dto.RestaurantResponseDTO;
import com.example.restaurant.mapper.RestaurantMapper;
import com.example.restaurant.model.CuisineType;
import com.example.restaurant.model.Restaurant;
import com.example.restaurant.repository.RestaurantRepository;
import com.example.restaurant.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class RestaurantServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    @Mock
    private RestaurantMapper restaurantMapper;

    @InjectMocks
    private RestaurantService restaurantService;

    private Restaurant restaurant;
    private RestaurantRequestDTO restaurantRequestDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        restaurant = new Restaurant(1L, "Пиццерия", "Итальянская", CuisineType.valueOf("ITALIAN"), 500, BigDecimal.valueOf(4.5) );
        restaurantRequestDTO = new RestaurantRequestDTO("Пиццерия", "Итальянская", "ITALIAN", 500);
    }

    @Test
    public void testFindById() {
        when(restaurantRepository.findById(1L)).thenReturn(Optional.of(restaurant));
        when(restaurantMapper.toResponseDTO(restaurant)).thenReturn(new RestaurantResponseDTO(1L, "Пиццерия", "Итальянская", "ITALIAN", 500, null));

        RestaurantResponseDTO result = restaurantService.findById(1L);

        assertNotNull(result);
        assertEquals("Пиццерия", result.getName());
    }

    @Test
    public void testSave() {
        when(restaurantMapper.toEntity(restaurantRequestDTO)).thenReturn(restaurant);
        when(restaurantRepository.save(restaurant)).thenReturn(restaurant);
        when(restaurantMapper.toResponseDTO(restaurant)).thenReturn(new RestaurantResponseDTO(1L, "Пиццерия", "Итальянская", "ITALIAN", 500, null));

        RestaurantResponseDTO result = restaurantService.save(restaurantRequestDTO);

        assertNotNull(result);
        assertEquals("Пиццерия", result.getName());
    }
}
