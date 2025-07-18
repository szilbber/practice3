package com.example.restaurant.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private Long visitorId;
    @NonNull
    private Long restaurantId;
    @NonNull
    private int rating;

    private String text;
}