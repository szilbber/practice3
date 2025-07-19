package com.example.restaurant;

import com.example.restaurant.dto.ReviewRequestDTO;
import com.example.restaurant.dto.ReviewResponseDTO;
import com.example.restaurant.mapper.ReviewMapper;
import com.example.restaurant.model.Review;
import com.example.restaurant.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.restaurant.service.ReviewService;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private ReviewMapper reviewMapper;

    @InjectMocks
    private ReviewService reviewService;

    private Review review;
    private ReviewRequestDTO reviewRequestDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        review = new Review(1L, 5, "Хорошо", null, null);
        reviewRequestDTO = new ReviewRequestDTO(1L, 1L, 5, "Хорошо");
    }

    @Test
    public void testFindById() {
        when(reviewRepository.findById(1L)).thenReturn(Optional.of(review));
        when(reviewMapper.toResponseDTO(review)).thenReturn(new ReviewResponseDTO(1L, 1L, 1L, 5, "Хорошо"));

        ReviewResponseDTO result = reviewService.findById(1L);

        assertNotNull(result);
        assertEquals("Хорошо", result.getText());
    }

    @Test
    public void testSave() {
        when(reviewMapper.toEntity(reviewRequestDTO)).thenReturn(review);
        when(reviewRepository.save(review)).thenReturn(review);
        when(reviewMapper.toResponseDTO(review)).thenReturn(new ReviewResponseDTO(1L, 1L, 1L, 5, "Хорошо"));

        ReviewResponseDTO result = reviewService.save(reviewRequestDTO);

        assertNotNull(result);
        assertEquals(5, result.getRating());
    }
}