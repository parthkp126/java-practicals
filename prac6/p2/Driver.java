public class Driver {
    public static void main(String[] args) {
        PaymentMethod card = new CardPayment();
        PaymentMethod cash = new CashPayment();

        if (card.pay(500)) {
            card.printReceipt(500);
        }

        if (cash.pay(250)) {
            cash.printReceipt(250);
        }
    }
}