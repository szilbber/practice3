package com.example.restaurant.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    @NonNull
    private CuisineType cuisineType;

    @NonNull
    private Integer averageCheck;
    @NonNull
    private BigDecimal rating;
}