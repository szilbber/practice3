package lesson4;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestsLambda {
    public static void main(String[] args) {

        //Пункт 1
        System.out.println("Пункт 1");
        Printable printable = () -> System.out.println("Привет, я печатаю!");
        printable.print();
        System.out.println();

        //Пункт 2
        System.out.println("Пункт 2");
        Predicate<String> isNotNull = s -> s != null;
        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        Predicate<String> isValid = isNotNull.and(isNotEmpty);

        String str1 = "Привет";
        String str2 = "";
        String str3 = null;

        System.out.println("str1 валидна? " + isValid.test(str1));
        System.out.println("str2 валидна? " + isValid.test(str2));
        System.out.println("str3 валидна? " + isValid.test(str3));
        System.out.println();

        //Пункт 3
        System.out.println("Пункт 3");
        Predicate<String> startsWithJOrN = s -> s != null && (s.startsWith("J") || s.startsWith("N"));
        Predicate<String> endsWithA = s -> s != null && (s.endsWith("A"));
        Predicate<String> isGood = startsWithJOrN.and(endsWithA);

        String[] testStrings = {"JAVA", "NINA", "DONNA", null, "NA"};

        for (String str : testStrings) {
            System.out.println("Строка: " + str + " → валидна? " + isGood.test(str));
        }
        System.out.println();

        //Пункт 4
        System.out.println("Пункт 4");
        HeavyBox box = new HeavyBox(16);
        Consumer<HeavyBox> shipBox = b -> System.out.println("Отгрузили ящик с весом " + b.getWeight());
        Consumer<HeavyBox> sendBox = b -> System.out.println("Отправляем ящик с весом " + b.getWeight());
        shipBox.andThen(sendBox).accept(box);
        System.out.println();

        //Пункт 5
        System.out.println("Пункт 5");
        Function<Integer, String> classifyNumber = number -> {
            if (number > 0) return "Положительное число";
            else if (number < 0) return "Отрицательное число";
            else return "Ноль";
        };

        System.out.println("5 → " + classifyNumber.apply(5));
        System.out.println("-1 → " + classifyNumber.apply(-1));
        System.out.println("0 → " + classifyNumber.apply(0));
        System.out.println();

        //Пункт 6
        System.out.println("Пункт 6");
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(11);

        System.out.println("Случайное число: " + randomSupplier.get());
        System.out.println("Еще одно случайное число: " + randomSupplier.get());
        System.out.println();

    }
}