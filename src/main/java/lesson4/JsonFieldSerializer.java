package lesson4;
import java.lang.reflect.Field;

public class JsonFieldSerializer {

    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        Class<?> clazz = obj.getClass();

        Field[] fields = clazz.getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);

                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonName = annotation.name();
                Object value = field.get(obj);

                if (!first) {
                    jsonBuilder.append(", ");
                }

                jsonBuilder.append("\"").append(jsonName).append("\": ");

                if (value instanceof String) {
                    jsonBuilder.append("\"").append(value).append("\"");
                } else if (value instanceof Number || value instanceof Boolean) {
                    jsonBuilder.append(value);
                } else {
                    jsonBuilder.append("\"").append(value.toString()).append("\"");
                }

                first = false;
            }
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}