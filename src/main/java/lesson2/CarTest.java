package lesson2;

import java.util.*;

public class CarTest {
    public static void main(String[] args) {
        Set<Car> cars = new HashSet<>();

        cars.add(new Car("VIN123", "Camry", "Toyota", 2020, 45000, 20000));
        cars.add(new Car("VIN456", "Model S", "Tesla", 2022, 15000, 90000));
        cars.add(new Car("VIN123", "Camry", "Toyota", 2018, 120000, 15000));
        cars.add(new Car("VIN789", "X5", "BMW", 2019, 30000, 50000));

        System.out.println("Машины в HashSet без дубликатов:");
        for (Car car : cars) {
            System.out.println(car);
        }

        List<Car> sortedCars = new ArrayList<>(cars);
        Collections.sort(sortedCars);

        System.out.println("\nОтсортированные машины (по году выпуска, от новых к старым):");
        for (Car car : sortedCars) {
            System.out.println(car);
        }
    }
}
