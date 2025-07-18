package com.example.restaurant.repository;

import com.example.restaurant.model.Visitor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
@Repository
public class VisitorRepository {

    private final List<Visitor> visitors = new ArrayList<>();

    public void save(Visitor visitor) {
        visitors.add(visitor);
    }

    public boolean remove(Visitor visitor) {
        return visitors.remove(visitor);
    }

    public List<Visitor> findAll() {
        return new ArrayList<>(visitors);
    }
}