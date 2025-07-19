package com.example.restaurant.controller;

import com.example.restaurant.dto.RestaurantRequestDTO;
import com.example.restaurant.dto.RestaurantResponseDTO;
import com.example.restaurant.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
@Tag(name = "Рестораны", description = "API для управления ресторанами")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    @Operation(summary = "Получить все рестораны", description = "Возвращает список всех ресторанов")
    @ApiResponse(responseCode = "200", description = "Список ресторанов успешно загружен",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestaurantResponseDTO.class)))
    public List<RestaurantResponseDTO> getAllRestaurants() {
        return restaurantService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить ресторан по ID", description = "Возвращает один ресторан по указанному ID")
    @ApiResponse(responseCode = "200", description = "Ресторан найден",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestaurantResponseDTO.class)))
    public RestaurantResponseDTO getRestaurantById(
            @Parameter(description = "ID ресторана", example = "1") @PathVariable Long id) {
        return restaurantService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Создать новый ресторан", description = "Создаёт новый ресторан на основе переданных данных")
    @ApiResponse(responseCode = "201", description = "Ресторан успешно создан",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestaurantResponseDTO.class)))
    public RestaurantResponseDTO createRestaurant(@RequestBody RestaurantRequestDTO dto) {
        return restaurantService.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить ресторан", description = "Обновляет данные существующего ресторана")
    @ApiResponse(responseCode = "200", description = "Ресторан успешно обновлён",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestaurantResponseDTO.class)))
    public RestaurantResponseDTO updateRestaurant(
            @PathVariable Long id,
            @RequestBody RestaurantRequestDTO dto) {
        return restaurantService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить ресторан", description = "Удаляет ресторан по указанному ID")
    @ApiResponse(responseCode = "204", description = "Ресторан успешно удалён")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteById(id);
    }
}