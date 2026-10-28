public class PasswordChecker {
    public static boolean hasMinimumLength(String password) {
        return password.length() >= 8;
    }

    public static boolean hasUppercase(String password) {
        return password.matches(".*[A-Z].*");
    }

    public static boolean hasDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    public static boolean hasSpecialCharacter(String password) {
        return password.matches(".*[^a-zA-Z0-9].*");
    }

    public static String strength(String password) {
        int passedRules = 0;

        if (hasMinimumLength(password)) passedRules++;
        if (hasUppercase(password)) passedRules++;
        if (hasDigit(password)) passedRules++;
        if (hasSpecialCharacter(password)) passedRules++;

        if (passedRules <= 1) return "Weak";
        if (passedRules <= 3) return "Medium";
        return "Strong";
    }

    public static void showResults(String password) {
        System.out.println("\nPassword: " + password);
        System.out.println("Length rule: " + hasMinimumLength(password));
        System.out.println("Uppercase rule: " + hasUppercase(password));
        System.out.println("Digit rule: " + hasDigit(password));
        System.out.println("Special character rule: "
                + hasSpecialCharacter(password));
        System.out.println("Strength: " + strength(password));
    }
}