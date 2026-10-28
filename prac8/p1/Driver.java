import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean completed = false;

        while (!completed) {
            try {
                System.out.print("Enter first number: ");
                double first = input.nextDouble();

                System.out.print("Enter operator (+, -, *, /): ");
                char operator = input.next().charAt(0);

                System.out.print("Enter second number: ");
                double second = input.nextDouble();

                double result = GuardedCalculator.calculate(
                        first, second, operator);

                System.out.println("Result: " + result);
                completed = true;
            } catch (InputMismatchException exception) {
                System.out.println("Please enter valid numbers.");
                input.nextLine();
            } catch (GuardedCalculator.DivideByZeroException exception) {
                System.out.println(exception.getMessage());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            } finally {
                System.out.println("Calculation attempt finished.");
            }
        }

        input.close();
    }
}