public class Driver {
    public static void main(String[] args) {
        Media[] returnedItems = {
            new Book("Java Basics"),
            new DVD("Learning Java"),
            new Magazine("Tech Monthly")
        };

        int[] lateDays = {3, 2, 4};
        double totalFees = 0;

        for (int i = 0; i < returnedItems.length; i++) {
            double fee = returnedItems[i].lateFee(lateDays[i]);

            System.out.println(returnedItems[i].title
                    + " late fee: " + fee);

            totalFees += fee;
        }

        System.out.println("Total late fees: " + totalFees);
    }
}