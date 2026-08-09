public class driver {
    public static void main(String[] args) {

        passwordchecker pc = new passwordchecker();

        String[] passwords = {
            "abc",
            "password",
            "Abcd1234",
            "Abcd1234!",
            "Hello@1"
        };

        for (String pw : passwords) {
            System.out.println("Password: " + pw);
            System.out.println("Length >= 8: " + pc.haslength(pw));
            System.out.println("Has Uppercase: " + pc.hasuppercase(pw));
            System.out.println("Has Digit: " + pc.hasdigit(pw));
            System.out.println("Has Special Character: " + pc.hasspecial(pw));
            System.out.println("Strength: " + pc.strength(pw));
            System.out.println();
        }
    }
}