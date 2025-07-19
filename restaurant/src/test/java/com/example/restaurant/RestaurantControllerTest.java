package com.example.restaurant;

import com.example.restaurant.controller.RestaurantController;
import com.example.restaurant.dto.RestaurantRequestDTO;
import com.example.restaurant.dto.RestaurantResponseDTO;
import com.example.restaurant.service.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RestaurantService restaurantService;

    @Test
    public void testGetAllRestaurants() throws Exception {
        when(restaurantService.findAll()).thenReturn(List.of(
                new RestaurantResponseDTO(1L, "Пиццерия", "Итальянская", "ITALIAN", 500, 4.5),
                new RestaurantResponseDTO(2L, "Суши Мастер", "Японская", "JAPANESE", 700, 4.8)
        ));

        mockMvc.perform(get("/api/restaurants")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].name", is("Пиццерия")))
                .andExpect(jsonPath("$[1].name", is("Суши Мастер")));
    }

    @Test
    public void testGetRestaurantById() throws Exception {
        when(restaurantService.findById(1L)).thenReturn(new RestaurantResponseDTO(1L, "Пиццерия", "Итальянская", "ITALIAN", 500, 4.5));

        mockMvc.perform(get("/api/restaurants/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Пиццерия")))
                .andExpect(jsonPath("$.averageCheck", is(500)));
    }

    @Test
    public void testCreateRestaurant() throws Exception {
        RestaurantRequestDTO requestDTO = new RestaurantRequestDTO("Пиццерия", "Итальянская", "ITALIAN", 500);
        RestaurantResponseDTO responseDTO = new RestaurantResponseDTO(1L, "Пиццерия", "Итальянская", "ITALIAN", 500, null);

        when(restaurantService.save(requestDTO)).thenReturn(responseDTO);

        mockMvc.perform(post("/api/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Пиццерия")))
                .andExpect(jsonPath("$.averageCheck", is(500)));
    }

    @Test
    public void testUpdateRestaurant() throws Exception {
        RestaurantRequestDTO requestDTO = new RestaurantRequestDTO("Пиццерия", "Итальянская", "ITALIAN", 500);
        RestaurantResponseDTO responseDTO = new RestaurantResponseDTO(1L, "Пиццерия", "Итальянская", "ITALIAN", 500, 4.5);

        when(restaurantService.update(1L, requestDTO)).thenReturn(responseDTO);

        mockMvc.perform(put("/api/restaurants/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rating", is(4.5)));
    }

    @Test
    public void testDeleteRestaurant() throws Exception {
        doNothing().when(restaurantService).deleteById(1L);

        mockMvc.perform(delete("/api/restaurants/1"))
                .andExpect(status().isNoContent());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
