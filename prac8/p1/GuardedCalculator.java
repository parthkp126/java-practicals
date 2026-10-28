public class GuardedCalculator {
    public static class DivideByZeroException extends Exception {
        public DivideByZeroException(String message) {
            super(message);
        }
    }

    public static double calculate(double a, double b, char operator)
            throws DivideByZeroException {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new DivideByZeroException(
                            "Cannot divide by zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException(
                        "Unknown operator: " + operator);
        }
    }
}