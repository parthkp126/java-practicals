public class MiniBankDemo {
    public static void main(String[] args) {
        System.out.println("Mobile valid: "
                + Validator.isValidMobile("9876543210"));
        System.out.println("Mobile valid: "
                + Validator.isValidMobile("12345"));

        System.out.println("Email valid: "
                + Validator.isValidEmail("riya@example.com"));
        System.out.println("PAN valid: "
                + Validator.isValidPan("ABCDE1234F"));
        System.out.println("IFSC valid: "
                + Validator.isValidIfsc("ABCD0123456"));

        Command command = CommandParser.parse("DEPOSIT AC0001 500");

        System.out.println("type=" + command.type());
        System.out.println("accountNumber=" + command.accountNumber());
        System.out.println("amount=" + command.amount());

        Account account = new Account("AC0001", "Riya", 4000);
        System.out.println(StatementFormatter.buildStatement(account));
    }
}