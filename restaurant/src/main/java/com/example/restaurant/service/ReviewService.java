package com.example.restaurant.service;

import com.example.restaurant.dto.ReviewRequestDTO;
import com.example.restaurant.dto.ReviewResponseDTO;
import com.example.restaurant.mapper.ReviewMapper;
import com.example.restaurant.model.Review;
import com.example.restaurant.repository.RestaurantRepository;
import com.example.restaurant.repository.ReviewRepository;
import com.example.restaurant.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final VisitorRepository visitorRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    public List<ReviewResponseDTO> findAll() {
        return reviewRepository.findAll().stream()
                .map(reviewMapper::toResponseDTO)
                .toList();
    }

    public ReviewResponseDTO findById(Long id) {
        return reviewMapper.toResponseDTO(
                reviewRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Отзыв не найден"))
        );
    }

    public ReviewResponseDTO save(ReviewRequestDTO dto) {
        return reviewMapper.toResponseDTO(reviewRepository.save(reviewMapper.toEntity(dto)));
    }

    public ReviewResponseDTO update(Long id, ReviewRequestDTO dto) {
        Review existing = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Отзыв не найден"));

        existing.setRating(dto.getRating());
        existing.setText(dto.getText());
        existing.setVisitor(visitorRepository.findById(dto.getVisitorId()).orElseThrow());
        existing.setRestaurant(restaurantRepository.findById(dto.getRestaurantId()).orElseThrow());

        return reviewMapper.toResponseDTO(reviewRepository.save(existing));
    }

    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}