package com.example.restaurant;

import com.example.restaurant.controller.ReviewController;
import com.example.restaurant.dto.ReviewRequestDTO;
import com.example.restaurant.dto.ReviewResponseDTO;
import com.example.restaurant.service.ReviewService;
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

@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ReviewService reviewService;

    @Test
    public void testGetAllReviews() throws Exception {
        when(reviewService.findAll()).thenReturn(List.of(
                new ReviewResponseDTO(1L, 1L, 1L, 5, "Отличная пицца!"),
                new ReviewResponseDTO(2L, 1L, 1L, 4, "Хорошо, но дорого")
        ));

        mockMvc.perform(get("/api/reviews")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].text", is("Отличная пицца!")))
                .andExpect(jsonPath("$[1].text", is("Хорошо, но дорого")));
    }

    @Test
    public void testGetReviewById() throws Exception {
        when(reviewService.findById(1L)).thenReturn(new ReviewResponseDTO(1L, 1L, 1L, 5, "Отличная пицца!"));

        mockMvc.perform(get("/api/reviews/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text", is("Отличная пицца!")));
    }

    @Test
    public void testCreateReview() throws Exception {
        ReviewRequestDTO requestDTO = new ReviewRequestDTO(1L, 1L, 5, "Отличная еда!");
        ReviewResponseDTO responseDTO = new ReviewResponseDTO(1L, 1L, 1L, 5, "Отличная еда!");

        when(reviewService.save(requestDTO)).thenReturn(responseDTO);

        mockMvc.perform(post("/api/reviews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text", is("Отличная еда!")));
    }

    @Test
    public void testUpdateReview() throws Exception {
        ReviewRequestDTO requestDTO = new ReviewRequestDTO(1L, 1L, 5, "Супер еда!");
        ReviewResponseDTO responseDTO = new ReviewResponseDTO(1L, 1L, 1L, 5, "Супер еда!");

        when(reviewService.update(1L, requestDTO)).thenReturn(responseDTO);

        mockMvc.perform(put("/api/reviews/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text", is("Супер еда!")));
    }

    @Test
    public void testDeleteReview() throws Exception {
        doNothing().when(reviewService).deleteById(1L);

        mockMvc.perform(delete("/api/reviews/1"))
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