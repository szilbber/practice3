package com.example.restaurant.repository;

import com.example.restaurant.model.Visitor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.Getter;

@Getter
@Repository
public class VisitorRepository {

    private final List<Visitor> visitors = new ArrayList<>();

    public Visitor save(Visitor visitor) {
        visitors.add(visitor);
        return visitor;
    }

    public void remove(Visitor visitor) {
        visitors.remove(visitor);
    }

    public List<Visitor> findAll() {
        return new ArrayList<>(visitors);
    }

    public Optional<Visitor> findById(Long id) {
        return findAll().stream()
                .filter(v -> v.getId() != null && v.getId().equals(id))
                .findFirst();
    }
}