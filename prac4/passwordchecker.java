public class passwordchecker {

    public boolean haslength(String password) {
        return password.length() >= 8;
    }

    public boolean hasuppercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasdigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasspecial(String password) {
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public String strength(String password) {

        int score = 0;

        if (haslength(password)) {
            score++;
        }

        if (hasuppercase(password)) {
            score++;
        }

        if (hasdigit(password)) {
            score++;
        }

        if (hasspecial(password)) {
            score++;
        }

        if (score == 4) {
            return "strong";
        } 
        else if (score >= 2) {
            return "medium";
        } 
        else {
            return "weak";
        }
    }
}