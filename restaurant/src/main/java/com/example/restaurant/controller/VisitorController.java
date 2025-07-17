package com.example.restaurant.controller;

import com.example.restaurant.dto.VisitorRequestDTO;
import com.example.restaurant.dto.VisitorResponseDTO;
import com.example.restaurant.model.Visitor;
import com.example.restaurant.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class VisitorController {

    private final VisitorService visitorService;

    @GetMapping
    public List<VisitorResponseDTO> getAll() {
        return visitorService.findAll();
    }

    @GetMapping("/{id}")
    public VisitorResponseDTO getById(@PathVariable Long id) {
        return visitorService.findById(id);
    }

    @PostMapping
    public VisitorResponseDTO create(@RequestBody VisitorRequestDTO dto) {
        return visitorService.save(dto);
    }

    @PutMapping("/{id}")
    public VisitorResponseDTO update(@PathVariable Long id, @RequestBody VisitorRequestDTO dto) {
        return visitorService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Visitor visitor = new Visitor();
        visitor.setId(id);
        visitorService.remove(visitor);
    }
}