package service;

public interface InterestBearing {
    double interestRate();

    default double calculateInterest(long balance) {
        return balance * interestRate() / 100.0;
    }

    static boolean isValidRate(double rate) {
        return rate >= 0;
    }
}