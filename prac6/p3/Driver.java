public class Driver {
    public static void main(String[] args) {
        InterestBearing account = new Savings();

        System.out.println(account.interestMessage(10000));
        System.out.println("Valid rate: "
                + InterestBearing.isValidRate(account.interestRate()));
    }
}