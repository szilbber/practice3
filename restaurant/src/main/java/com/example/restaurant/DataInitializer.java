//package com.example.restaurant;
//
//import com.example.restaurant.model.CuisineType;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.example.restaurant.model.Visitor;
//import com.example.restaurant.model.Restaurant;
//import com.example.restaurant.model.Review;
//import com.example.restaurant.service.VisitorService;
//import com.example.restaurant.service.RestaurantService;
//import com.example.restaurant.service.ReviewService;
//
//@Component
//public class DataInitializer {
//
//    @Autowired
//    private VisitorService visitorService;
//
//    @Autowired
//    private RestaurantService restaurantService;
//
//    @Autowired
//    private ReviewService reviewService;
//
//    @PostConstruct
//    public void init() {
//        Visitor visitor1 = new Visitor(1L, "Иван", 30, "мужской");
//        Visitor visitor2 = new Visitor(2L, "Мария", 25, "женский");
////        visitorService.save(visitor1);
////        visitorService.save(visitor2);
////
////        Restaurant restaurant1 = new Restaurant(1L, "Пиццерия", "", CuisineType.ITALIAN, 500, null);
////        Restaurant restaurant2 = new Restaurant(2L, "Суши Мастер", "", CuisineType.JAPANESE, 700, null);
////        restaurantService.save(restaurant1);
////        restaurantService.save(restaurant2);
////
////        Review review1 = new Review(1L, visitor1.getId(), restaurant1.getId(), 5, "Великолепная пицца!");
////        Review review2 = new Review(2L, visitor2.getId(), restaurant2.getId(), 4, "Хорошо, но дорого");
////        Review review3 = new Review(3L, visitor2.getId(), restaurant2.getId(), 5, "Отличные суши");
////
////        reviewService.save(review1);
////        reviewService.save(review2);
////        System.out.println("\n--- Все рестораны с начальной оценкой ---");
////        restaurantService.findAll().forEach(r ->
////                System.out.println("Ресторан: " + r.getName() + ", Рейтинг: " + r.getRating()));
////        reviewService.save(review3);
//    }
//}