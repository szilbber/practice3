package com.example.restaurant.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
@Schema(description = "Ответ с данными отзыва")
public class ReviewResponseDTO {
    @Schema(description = "Уникальный идентификатор отзыва", example = "1")
    Long id;

    @Schema(description = "ID посетителя", example = "1")
    Long visitorId;

    @Schema(description = "ID ресторана", example = "1")
    Long restaurantId;

    @Schema(description = "Оценка", example = "5")
    Integer rating;

    @Schema(description = "Текст отзыва", example = "Отличное место, еда на высшем уровне")
    String text;
}