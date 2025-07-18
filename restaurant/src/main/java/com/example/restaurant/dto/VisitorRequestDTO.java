package com.example.restaurant.dto;

import lombok.Value;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Запрос на создание или обновление посетителя")
@Value
public class VisitorRequestDTO {
    @Schema(description = "Имя посетителя", example = "Иван")
    String name;

    @Schema(description = "Возраст посетителя", example = "30")
    int age;

    @Schema(description = "Пол посетителя", example = "мужской")
    String gender;
}