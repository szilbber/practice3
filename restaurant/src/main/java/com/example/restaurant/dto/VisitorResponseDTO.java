package com.example.restaurant.dto;

import lombok.Value;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ с данными посетителя")
@Value
public class VisitorResponseDTO {
    @Schema(description = "Уникальный идентификатор посетителя", example = "1")
    Long id;

    @Schema(description = "Имя посетителя", example = "Иван")
    String name;

    @Schema(description = "Возраст посетителя", example = "30")
    int age;

    @Schema(description = "Пол посетителя", example = "мужской")
    String gender;
}