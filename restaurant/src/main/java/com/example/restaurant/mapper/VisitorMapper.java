package com.example.restaurant.mapper;

import com.example.restaurant.dto.VisitorRequestDTO;
import com.example.restaurant.dto.VisitorResponseDTO;
import com.example.restaurant.model.Visitor;
import org.springframework.stereotype.Component;

@Component
public class VisitorMapper {

    public Visitor toEntity(VisitorRequestDTO dto) {
        return new Visitor(null, dto.getName(), dto.getAge(), dto.getGender());
    }

    public VisitorResponseDTO toResponseDTO(Visitor visitor) {
        return new VisitorResponseDTO(
                visitor.getId(),
                visitor.getName(),
                visitor.getAge(),
                visitor.getGender()
        );
    }
}