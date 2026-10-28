package util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import model.annotation.Id;
import model.annotation.Positive;
import model.annotation.MaxLength;

public class AnnotationValidator {
    public static String[] validate(Object object) {
        List<String> errors = new ArrayList<>();

        Class<?> current = object.getClass();

        while (current != null) {
            for (Field field : current.getDeclaredFields()) {
                field.setAccessible(true);

                try {
                    Object value = field.get(object);

                    if (field.isAnnotationPresent(Id.class)
                            && (value == null || value.toString().isBlank())) {
                        errors.add(field.getName() + " must not be blank");
                    }

                    Positive positive = field.getAnnotation(Positive.class);

                    if (positive != null
                            && value instanceof Number number
                            && number.longValue() <= 0) {
                        errors.add(field.getName() + " "
                                + positive.message());
                    }

                    MaxLength maxLength =
                            field.getAnnotation(MaxLength.class);

                    if (maxLength != null
                            && value instanceof String text
                            && text.length() > maxLength.value()) {
                        errors.add(field.getName()
                                + " must be at most "
                                + maxLength.value() + " characters");
                    }
                } catch (IllegalAccessException exception) {
                    errors.add("Could not validate " + field.getName());
                }
            }

            current = current.getSuperclass();
        }

        return errors.toArray(new String[0]);
    }
}