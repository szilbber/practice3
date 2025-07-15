package lesson4;

public class TestsAnnotation {
    public static void main(String[] args) throws IllegalAccessException {

        System.out.println("Пункт 1");
        AnnotationProcessor.process(OldClass.class);
        System.out.println();

        System.out.println("Пункт 2");
        User user = new User(1, "john_doe", "john@example.com");
        String json = JsonFieldSerializer.toJson(user);
        System.out.println(json);
    }
}
