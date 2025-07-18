package com.example.restaurant.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
@Schema(description = "Данные для создания или обновления ресторана")
public class RestaurantRequestDTO {
    @Schema(description = "Название ресторана", example = "Пиццерия")
    String name;

    @Schema(description = "Описание ресторана", example = "Итальянская пиццерия")
    String description;

    @Schema(description = "Тип кухни", example = "ITALIAN")
    String cuisineType;

    @Schema(description = "Средний чек", example = "500")
    Integer averageCheck;
}