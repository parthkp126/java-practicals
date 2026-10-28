import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

class SampleTests {
    @Run
    public void testAddition() {
        System.out.println("Addition test ran");
    }

    @Run
    public void testName() {
        System.out.println("Name test ran");
    }

    public void helperMethod() {
        System.out.println("This method is not a test");
    }
}

public class MiniTestRunner {
    public static int runTests(Object testObject)
            throws ReflectiveOperationException {
        int count = 0;

        for (Method method : testObject.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Run.class)) {
                method.invoke(testObject);
                count++;
            }
        }

        return count;
    }
}