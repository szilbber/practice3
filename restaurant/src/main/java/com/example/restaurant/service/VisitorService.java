package com.example.restaurant.service;

import com.example.restaurant.dto.VisitorRequestDTO;
import com.example.restaurant.dto.VisitorResponseDTO;
import com.example.restaurant.mapper.VisitorMapper;
import com.example.restaurant.model.Visitor;
import com.example.restaurant.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class VisitorService {

    private final VisitorRepository visitorRepository;
    private final VisitorMapper visitorMapper;

    public List<VisitorResponseDTO> findAll() {
        return visitorRepository.findAll().stream()
                .map(visitorMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public VisitorResponseDTO findById(Long id) {
        return visitorRepository.findById(id)
                .map(visitorMapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Посетитель не найден"));
    }

    public VisitorResponseDTO save(VisitorRequestDTO dto) {
        return visitorMapper.toResponseDTO(visitorRepository.save(visitorMapper.toEntity(dto)));
    }

    public void deleteById(Long id) {
        visitorRepository.deleteById(id);
    }

    public VisitorResponseDTO update(Long id, VisitorRequestDTO dto) {
        Visitor visitor = visitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Посетитель не найден"));

        visitor.setName(dto.getName());
        visitor.setAge(dto.getAge());
        visitor.setGender(dto.getGender());

        return visitorMapper.toResponseDTO(visitorRepository.save(visitor));
    }
}