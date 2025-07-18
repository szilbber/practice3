package com.example.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.restaurant.service.VisitorService;
import com.example.restaurant.service.RestaurantService;
import com.example.restaurant.service.ReviewService;

@Component
public class ServiceTester implements CommandLineRunner {

    @Autowired
    private VisitorService visitorService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private ReviewService reviewService;

    @Override
    public void run(String... args) {
        System.out.println("\n--- Проверка сервисов через CommandLineRunner ---");
        System.out.println("Посетители: " + visitorService.findAll().size());
        System.out.println("Рестораны: " + restaurantService.findAll().size());
        System.out.println("Отзывы: " + reviewService.findAll().size());

        System.out.println("\n--- Все посетители ---");
        visitorService.findAll().forEach(v ->
                System.out.println("Имя: " + v.getName() + ", Возраст: " + v.getAge()));

        System.out.println("\n--- Все отзывы ---");
        reviewService.findAll().forEach(r ->
                System.out.println("Оценка: " + r.getRating() + ", Текст: " + r.getText()));

        System.out.println("\n--- Все рестораны с обновленной оценкой---");
        restaurantService.findAll().forEach(r ->
                System.out.println("Ресторан: " + r.getName() + ", Рейтинг: " + r.getRating()));
    }
}
