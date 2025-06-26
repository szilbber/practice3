package lesson2;

import java.util.*;
import java.util.OptionalDouble;

public class CarDealershipApp {
    public static void main(String[] args) {
        CarDealership dealership = new CarDealership();

        dealership.addCar(new Car2("V123", "Camry", "Toyota", 2020, 45000, 20000, CarType.SEDAN));
        dealership.addCar(new Car2("V456", "Model S", "Tesla", 2022, 15000, 90000, CarType.ELECTRIC));
        dealership.addCar(new Car2("V789", "X5", "BMW", 2019, 30000, 50000, CarType.SUV));
        dealership.addCar(new Car2("V101", "Civic", "Honda", 2021, 25000, 22000, CarType.SEDAN));
        dealership.addCar(new Car2("V112", "Rover", "Range Rover", 2017, 80000, 45000, CarType.SUV));
        dealership.addCar(new Car2("V1234", "Camry", "Toyota", 2018, 120000, 15000, CarType.SEDAN));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Автоцентр ===");
            System.out.println("1. Показать все машины");
            System.out.println("2. Добавить машину");
            System.out.println("3. Найти машины по производителю");
            System.out.println("4. Средняя цена по типу");
            System.out.println("5. Машины по убыванию года");
            System.out.println("6. Статистика по типам");
            System.out.println("7. Самая старая и новая машина");
            System.out.println("0. Выход");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nВсе машины:");
                    dealership.getAllCars().forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Введите VIN: "); String vin = scanner.nextLine();
                    System.out.print("Модель: "); String model = scanner.nextLine();
                    System.out.print("Производитель: "); String manufacturer = scanner.nextLine();
                    System.out.print("Год выпуска: "); int year = scanner.nextInt();
                    System.out.print("Пробег: "); int mileage = scanner.nextInt();
                    System.out.print("Цена: "); double price = scanner.nextDouble();
                    System.out.println("Тип (SEDAN, SUV, ELECTRIC и т.д.): ");
                    CarType type = CarType.valueOf(scanner.next().toUpperCase());

                    boolean added = dealership.addCar(new Car2(vin, model, manufacturer, year, mileage, price, type));
                    System.out.println(added ? "Машина добавлена." : "Ошибка: машина с таким VIN уже существует.");
                    break;

                case 3:
                    System.out.print("Введите производителя: ");
                    String manuf = scanner.next();
                    System.out.println("\nМашины производителя " + manuf + ":");
                    dealership.findCarsByManufacturer(manuf).forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Введите тип машины (например, SUV): ");
                    CarType typeInput = CarType.valueOf(scanner.next().toUpperCase());
                    OptionalDouble avg = dealership.averagePriceByType(typeInput);
                    if (avg.isPresent()) {
                        System.out.printf("Средняя цена для %s: %.2f$\n", typeInput, avg.getAsDouble());
                    } else {
                        System.out.println("Нет машин этого типа.");
                    }
                    break;

                case 5:
                    System.out.println("\nМашины по убыванию года:");
                    dealership.getCarsSortedByYearDesc().forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("\nКоличество машин по типам:");
                    dealership.countCarsByType().forEach((k, v) -> System.out.println(k + ": " + v));
                    break;

                case 7:
                    Map<String, Car2> stats = dealership.getOldestAndNewestCar();
                    System.out.println("\nСтатистика:");
                    System.out.println("Самая старая: " + stats.get("Oldest"));
                    System.out.println("Самая новая: " + stats.get("Newest"));
                    break;

                case 0:
                    System.out.println("Выход из программы.");
                    return;

                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}