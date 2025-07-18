package com.example.restaurant.controller;

import com.example.restaurant.dto.VisitorRequestDTO;
import com.example.restaurant.dto.VisitorResponseDTO;
import com.example.restaurant.service.VisitorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "Посетители", description = "API для управления посетителями")
public class VisitorController {

    private final VisitorService visitorService;

    @GetMapping
    @Operation(summary = "Получить всех посетителей", description = "Возвращает список всех посетителей из базы данных")
    @ApiResponse(responseCode = "200", description = "Список посетителей успешно загружен",
            content = @Content(schema = @Schema(implementation = VisitorResponseDTO.class)))
    public List<VisitorResponseDTO> getAll() {
        return visitorService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить посетителя по ID", description = "Возвращает одного посетителя по указанному ID")
    @ApiResponse(responseCode = "200", description = "Посетитель найден",
            content = @Content(schema = @Schema(implementation = VisitorResponseDTO.class)))
    public VisitorResponseDTO getById(
            @Parameter(description = "ID посетителя", example = "1") @PathVariable Long id) {
        return visitorService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Создать нового посетителя", description = "Создаёт нового посетителя на основе переданных данных")
    @ApiResponse(responseCode = "201", description = "Посетитель успешно создан",
            content = @Content(schema = @Schema(implementation = VisitorResponseDTO.class)))
    public VisitorResponseDTO create(@RequestBody VisitorRequestDTO dto) {
        return visitorService.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить посетителя", description = "Обновляет данные существующего посетителя")
    @ApiResponse(responseCode = "200", description = "Посетитель успешно обновлён",
            content = @Content(schema = @Schema(implementation = VisitorResponseDTO.class)))
    public VisitorResponseDTO update(
            @PathVariable Long id,
            @RequestBody VisitorRequestDTO dto) {
        return visitorService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить посетителя", description = "Удаляет посетителя по указанному ID")
    @ApiResponse(responseCode = "204", description = "Посетитель успешно удалён")
    public void delete(@PathVariable Long id) {
        visitorService.deleteById(id);
    }
}