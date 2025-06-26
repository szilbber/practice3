package lesson2;

import java.util.*;
import java.util.stream.Collectors;

public class CarStreamExample {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("VIN123", "Camry", "Toyota", 2020, 45000, 200500),
                new Car("VIN456", "Model S", "Tesla", 2022, 15000, 90000),
                new Car("VIN134", "Camry", "Toyota", 2018, 120000, 150000),
                new Car("VIN789", "X5", "BMW", 2019, 30000, 50000),
                new Car("VIN564","Civic", "Honda", 2021, 25000, 22000),
                new Car("VIN753","A6", "Audi", 2017, 80000, 25000),
                new Car("VIN159","Model 3", "Tesla", 2021, 15000, 40000),
                new Car("VIN951","Mustang", "Ford", 2016, 90000, 28000));


        List<Car> filteredCars = cars.stream()
                .filter(car -> car.getMileage() < 50000)
                .toList();

        System.out.println("Машины с пробегом меньше 50 000 км:");
        filteredCars.forEach(System.out::println);
        System.out.println();


        List<Car> sortedByPriceDesc = filteredCars.stream()
                .sorted(Comparator.comparingDouble(Car::getPrice).reversed())
                .toList();

        System.out.println("Отсортировано по цене (по убыванию):");
        sortedByPriceDesc.forEach(System.out::println);
        System.out.println();


        List<Car> top3MostExpensive = sortedByPriceDesc.stream()
                .limit(3)
                .toList();

        System.out.println("Топ-3 самые дорогие машины:");
        top3MostExpensive.forEach(System.out::println);
        System.out.println();


        double averageMileage = cars.stream()
                .mapToInt(Car::getMileage)
                .average()
                .orElse(0);

        System.out.printf("Средний пробег всех машин: %.2f км%n%n", averageMileage);


        Map<String, List<Car>> carsByManufacturer = cars.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));

        System.out.println("Группировка по производителю:");
        carsByManufacturer.forEach((manufacturer, carList) -> {
            System.out.println("Производитель: " + manufacturer);
            carList.forEach(car -> System.out.println("  - " + car));
        });
    }
}
