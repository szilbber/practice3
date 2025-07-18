package com.example.restaurant.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
@Schema(description = "Данные для создания отзыва")
public class ReviewRequestDTO {
    @Schema(description = "ID посетителя", example = "1")
    Long visitorId;

    @Schema(description = "ID ресторана", example = "1")
    Long restaurantId;

    @Schema(description = "Оценка (от 1 до 5)", example = "5")
    Integer rating;

    @Schema(description = "Текст отзыва", example = "Отличное место, еда на высшем уровне")
    String text;
}