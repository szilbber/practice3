package com.example.restaurant.service;


import com.example.restaurant.dto.VisitorRequestDTO;
import com.example.restaurant.dto.VisitorResponseDTO;
import com.example.restaurant.mapper.VisitorMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.example.restaurant.model.Visitor;
import com.example.restaurant.repository.VisitorRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitorService {

    private final VisitorRepository visitorRepository;
    private final VisitorMapper visitorMapper;

    @Transactional
    public VisitorResponseDTO save(VisitorRequestDTO dto) {
        Visitor visitor = visitorMapper.toEntity(dto);
        return visitorMapper.toResponseDTO(visitorRepository.save(visitor));
    }

    public void remove(Visitor visitor) {
        visitorRepository.remove(visitor);
    }
    public VisitorResponseDTO findById(Long id) {
        return visitorRepository.findById(id)
                .map(visitorMapper::toResponseDTO)
                .orElse(null);
    }
    public List<VisitorResponseDTO> findAll() {
        return visitorRepository.findAll().stream()
                .map(visitorMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public VisitorResponseDTO update(Long id, VisitorRequestDTO dto) {
        Visitor existing = visitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Посетитель не найден"));

        existing.setName(dto.getName());
        existing.setAge(dto.getAge());
        existing.setGender(dto.getGender());

        return visitorMapper.toResponseDTO(visitorRepository.save(existing));
    }
}
