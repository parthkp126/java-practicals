public class Driver {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        String[] items = {"Pen", "Book", "Pen"};
        int[] quantities = {3, 8, 0};

        for (int i = 0; i < items.length; i++) {
            try {
                warehouse.issue(items[i], quantities[i]);
            } catch (Warehouse.OutOfStockException exception) {
                System.out.println(exception.getMessage());
                System.out.println("Shortfall: "
                        + exception.getShortfall());
            } catch (Warehouse.InvalidQuantityException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}