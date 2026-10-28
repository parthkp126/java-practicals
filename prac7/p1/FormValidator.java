import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class SignupForm {
    @NotBlank
    private String name;

    @NotBlank
    @MaxLength(30)
    private String email;

    SignupForm(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

public class FormValidator {
    public static List<String> validate(Object object) {
        List<String> errors = new ArrayList<>();

        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            try {
                Object value = field.get(object);
                String text = value == null ? "" : value.toString();

                if (field.isAnnotationPresent(NotBlank.class)
                        && text.isBlank()) {
                    errors.add(field.getName() + " must not be blank");
                }

                MaxLength maxLength =
                        field.getAnnotation(MaxLength.class);

                if (maxLength != null
                        && text.length() > maxLength.value()) {
                    errors.add(field.getName() + " is too long");
                }
            } catch (IllegalAccessException exception) {
                errors.add("Could not read " + field.getName());
            }
        }

        return errors;
    }
}