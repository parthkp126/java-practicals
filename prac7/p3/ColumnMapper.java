import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

class StudentRow {
    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public StudentRow() {
    }

    @Override
    public String toString() {
        return name + ", age " + age;
    }
}

public class ColumnMapper {
    public static <T> T map(
            String[] headers,
            String[] values,
            Class<T> type
    ) throws ReflectiveOperationException {
        if (headers.length != values.length) {
            throw new IllegalArgumentException(
                    "Header and data column counts differ");
        }

        T object = type.getDeclaredConstructor().newInstance();

        for (Field field : type.getDeclaredFields()) {
            Column column = field.getAnnotation(Column.class);

            if (column == null) {
                continue;
            }

            int index = findHeader(headers, column.name());

            if (index == -1) {
                throw new IllegalArgumentException(
                        "Missing column: " + column.name());
            }

            field.setAccessible(true);

            if (field.getType() == int.class) {
                field.setInt(object, Integer.parseInt(values[index]));
            } else if (field.getType() == String.class) {
                field.set(object, values[index]);
            }
        }

        return object;
    }

    private static int findHeader(String[] headers, String name) {
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equalsIgnoreCase(name)) {
                return i;
            }
        }

        return -1;
    }
}