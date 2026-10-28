interface PaymentMethod {
    boolean pay(double amount);

    default void printReceipt(double amount) {
        System.out.println("Payment received: " + amount);
    }
}

class CardPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        return amount > 0;
    }
}

class CashPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        return amount > 0;
    }

    @Override
    public void printReceipt(double amount) {
        System.out.println("Cash payment received: " + amount);
    }
}