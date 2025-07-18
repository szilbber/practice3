package com.example.restaurant.controller;

import com.example.restaurant.dto.ReviewRequestDTO;
import com.example.restaurant.dto.ReviewResponseDTO;
import com.example.restaurant.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@Tag(name = "Отзывы", description = "API для управления отзывами посетителей")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    @Operation(
            summary = "Получить все отзывы",
            description = "Возвращает список всех отзывов о ресторанах",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Список отзывов успешно загружен", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReviewResponseDTO.class)))
            }
    )
    public List<ReviewResponseDTO> getAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Получить отзыв по ID",
            description = "Возвращает один отзыв по указанному ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Отзыв найден", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReviewResponseDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Отзыв не найден")
            }
    )
    public ReviewResponseDTO getById(
            @Parameter(description = "ID отзыва", example = "1") @PathVariable Long id) {
        return reviewService.findById(id);
    }

    @PostMapping
    @Operation(
            summary = "Создать новый отзыв",
            description = "Создаёт новый отзыв о ресторане от посетителя",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Отзыв успешно создан", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReviewResponseDTO.class)))
            }
    )
    public ReviewResponseDTO create(@RequestBody ReviewRequestDTO dto) {
        return reviewService.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Обновить отзыв",
            description = "Обновляет существующий отзыв по ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Отзыв успешно обновлён", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReviewResponseDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Отзыв не найден")
            }
    )
    public ReviewResponseDTO update(
            @PathVariable Long id,
            @RequestBody ReviewRequestDTO dto) {
        return reviewService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удалить отзыв",
            description = "Удаляет отзыв по указанному ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Отзыв успешно удалён")
            }
    )
    public void delete(@PathVariable Long id) {
        reviewService.deleteById(id);
    }
}