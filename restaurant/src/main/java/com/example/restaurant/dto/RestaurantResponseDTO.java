package com.example.restaurant.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
@Schema(description = "Данные ресторана, возвращаемые API")
public class RestaurantResponseDTO {
    @Schema(description = "Уникальный идентификатор", example = "1")
    Long id;

    @Schema(description = "Название ресторана", example = "Пиццерия")
    String name;

    @Schema(description = "Описание", example = "Итальянская пиццерия")
    String description;

    @Schema(description = "Тип кухни", example = "ITALIAN")
    String cuisineType;

    @Schema(description = "Средний чек", example = "500")
    Integer averageCheck;

    @Schema(description = "Рейтинг ресторана", example = "4.5")
    Double rating;
}