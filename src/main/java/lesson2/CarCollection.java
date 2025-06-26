package lesson2;

import java.util.*;

public class CarCollection {
    public static void main(String[] args) {

        List<String> carModels = new ArrayList<>(Arrays.asList(
                "Toyota Camry", "BMW X5", "Tesla Model S", "Honda Civic",
                "Tesla Model 3", "Ford Mustang", "BMW X5", "Toyota Corolla",
                "Tesla Model X", "Mercedes-Benz C-Class"
        ));

        System.out.println("Исходный список моделей:");
        System.out.println(carModels);

        Set<String> uniqueModels = new HashSet<>(carModels);
        List<String> sortedModels = new ArrayList<>(uniqueModels);
        sortedModels.sort(Collections.reverseOrder());

        System.out.println("\nСписок после удаления дубликатов и сортировки в обратном алфавитном порядке:");
        System.out.println(sortedModels);

        System.out.println("\nСписок после сохранения в Сет:");
        Set<String> sortedModelSet = new TreeSet<>(Collections.reverseOrder());
        sortedModelSet.addAll(sortedModels);
        System.out.println(sortedModelSet);

        List<String> modifiedList = new ArrayList<>();
        for (String model : sortedModelSet) {
            if (model.contains("Tesla")) {
                modifiedList.add("ELECTRO_CAR");
            } else {
                modifiedList.add(model);
            }
        }

        System.out.println("\nСписок после замены 'Tesla' на 'ELECTRO_CAR':");
        System.out.println(modifiedList);
    }
}