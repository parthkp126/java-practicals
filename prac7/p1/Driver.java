public class Driver {
    public static void main(String[] args) {
        SignupForm form = new SignupForm("", "a-very-long-email-address"
                + "-that-is-longer-than-thirty-characters@example.com");

        for (String error : FormValidator.validate(form)) {
            System.out.println(error);
        }
    }
}