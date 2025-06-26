package lesson2;

import java.util.Random;

public class CarArray {
    public static void main(String[] args) {
        int[] carYears = new int[50];
        Random rand = new Random();

        for (int i = 0; i < carYears.length; i++) {
            carYears[i] = 2000 + rand.nextInt(26);
        }

        System.out.println("Машины, выпущенные после 2015 года:");
        for (int year : carYears) {
            if (year > 2015) {
                System.out.print(year + " ");
            }
        }
        System.out.println();

        int currentYear = 2025;
        double totalAge = 0;
        for (int year : carYears) {
            totalAge += (currentYear - year);
        }
        double averageAge = totalAge / carYears.length;

        System.out.printf("Средний возраст автомобиля: %.2f лет%n", averageAge);
    }
}