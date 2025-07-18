package com.example.restaurant.service;


import org.springframework.stereotype.Service;
import com.example.restaurant.model.Visitor;
import com.example.restaurant.repository.VisitorRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorService {

    private final VisitorRepository visitorRepository;

    public void save(Visitor visitor) {
        visitorRepository.save(visitor);
    }

    public boolean remove(Visitor visitor) {
        return visitorRepository.remove(visitor);
    }

    public List<Visitor> findAll() {
        return visitorRepository.findAll();
    }
}