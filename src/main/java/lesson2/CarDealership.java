package lesson2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.Collectors;

public class CarDealership {
    private final List<Car2> cars = new ArrayList<>();

    public boolean addCar(Car2 car) {
        if (!containsVin(car.getVin())) {
            cars.add(car);
            return true;
        }
        return false;
    }

    private boolean containsVin(String vin) {
        return cars.stream().anyMatch(car -> car.getVin().equals(vin));
    }

    public List<Car2> findCarsByManufacturer(String manufacturer) {
        return cars.stream()
                .filter(c -> c.getManufacturer().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());
    }

    public OptionalDouble averagePriceByType(CarType type) {
        return cars.stream()
                .filter(c -> c.getType() == type)
                .mapToDouble(Car2::getPrice)
                .average();
    }

    public List<Car2> getCarsSortedByYearDesc() {
        return cars.stream()
                .sorted(Comparator.comparingInt(Car2::getYear).reversed())
                .collect(Collectors.toList());
    }

    public Map<CarType, Long> countCarsByType() {
        return cars.stream()
                .collect(Collectors.groupingBy(Car2::getType, Collectors.counting()));
    }

    public Map<String, Car2> getOldestAndNewestCar() {
        Map<String, Car2> result = new HashMap<>();

        Optional<Car2> oldest = cars.stream()
                .min(Comparator.comparingInt(Car2::getYear));

        Optional<Car2> newest = cars.stream()
                .max(Comparator.comparingInt(Car2::getYear));

        result.put("Oldest", oldest.orElse(null));
        result.put("Newest", newest.orElse(null));

        return result;
    }

    public List<Car2> getAllCars() {
        return new ArrayList<>(cars);
    }
}