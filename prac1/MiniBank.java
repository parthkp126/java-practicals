import java.util.Scanner;

public class MiniBank {
    record BankInfo(String name, String branch) {}

    enum MenuOption {
        OPEN_ACCOUNT, DEPOSIT, WITHDRAW, TRANSFER, EXIT
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        BankInfo bank = new BankInfo("MiniBank", "Main Branch");
        System.out.println("Welcome to " + bank.name());
        System.out.println("Branch: " + bank.branch());

        boolean running = true;

        while (running) {
            System.out.println("\n1. Open account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!input.hasNextInt()) {
                System.out.println("Please enter a number from 1 to 5.");
                input.next();
                continue;
            }

            int choice = input.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            MenuOption option = MenuOption.values()[choice - 1];

            String message = switch (option) {
                case OPEN_ACCOUNT -> "Open account - to be implemented later.";
                case DEPOSIT -> "Deposit - to be implemented later.";
                case WITHDRAW -> "Withdraw - to be implemented later.";
                case TRANSFER -> "Transfer - to be implemented later.";
                case EXIT -> "Goodbye!";
            };

            System.out.println(message);

            if (option == MenuOption.EXIT) {
                running = false;
            }
        }

        input.close();
    }
}