package com.example.restaurant.controller;

import com.example.restaurant.dto.ReviewRequestDTO;
import com.example.restaurant.dto.ReviewResponseDTO;
import com.example.restaurant.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewResponseDTO> getAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewResponseDTO getById(@PathVariable Long id) {
        return reviewService.findById(id);
    }

    @PostMapping
    public ReviewResponseDTO create(@RequestBody ReviewRequestDTO dto) {
        return reviewService.save(dto);
    }

    @PutMapping("/{id}")
    public ReviewResponseDTO update(@PathVariable Long id, @RequestBody ReviewRequestDTO dto) {
        return reviewService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.deleteById(id);
    }
}