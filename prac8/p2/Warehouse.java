import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<String, Integer> stock = new HashMap<>();

    public Warehouse() {
        stock.put("Pen", 10);
        stock.put("Book", 5);
    }

    public void issue(String item, int quantity)
            throws OutOfStockException, InvalidQuantityException {
        if (quantity <= 0) {
            throw new InvalidQuantityException(
                    "Quantity must be greater than zero.");
        }

        int available = stock.getOrDefault(item, 0);

        if (quantity > available) {
            throw new OutOfStockException(
                    item, quantity - available);
        }

        stock.put(item, available - quantity);
        System.out.println("Issued " + quantity + " " + item);
    }

    static class OutOfStockException extends Exception {
        private int shortfall;

        OutOfStockException(String item, int shortfall) {
            super("Not enough " + item + " in stock.");
            this.shortfall = shortfall;
        }

        public int getShortfall() {
            return shortfall;
        }
    }

    static class InvalidQuantityException extends Exception {
        InvalidQuantityException(String message) {
            super(message);
        }
    }
}