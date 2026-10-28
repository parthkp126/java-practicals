interface InterestBearing {
    double interestRate();

    default double calculateInterest(double balance) {
        return balance * interestRate() / 100.0;
    }

    default String interestMessage(double balance) {
        return format(calculateInterest(balance));
    }

    static boolean isValidRate(double rate) {
        return rate >= 0 && rate <= 100;
    }

    private String format(double interest) {
        return String.format("Interest amount: %.2f", interest);
    }
}

class Savings implements InterestBearing {
    @Override
    public double interestRate() {
        return 4.0;
    }
}