package com.example.restaurant.service;

import com.example.restaurant.dto.ReviewRequestDTO;
import com.example.restaurant.dto.ReviewResponseDTO;
import com.example.restaurant.mapper.ReviewMapper;
import com.example.restaurant.model.Review;
import com.example.restaurant.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Transactional
    public ReviewResponseDTO save(ReviewRequestDTO dto) {
        Review review = reviewMapper.toEntity(dto);
        return reviewMapper.toResponseDTO(reviewRepository.save(review));
    }

    public List<ReviewResponseDTO> findAll() {
        return reviewRepository.findAll().stream()
                .map(reviewMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ReviewResponseDTO findById(Long id) {
        return reviewRepository.findById(id)
                .map(reviewMapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Отзыв не найден"));
    }

    @Transactional
    public ReviewResponseDTO update(Long id, ReviewRequestDTO dto) {
        Review existing = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Отзыв не найден"));

        existing.setVisitorId(dto.getVisitorId());
        existing.setRestaurantId(dto.getRestaurantId());
        existing.setRating(dto.getRating());
        existing.setText(dto.getText());

        return reviewMapper.toResponseDTO(reviewRepository.save(existing));
    }

    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}