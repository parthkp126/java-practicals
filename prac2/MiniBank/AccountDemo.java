public class AccountDemo {
    public static void main(String[] args) {
        Account[] accounts = {
            new Account("Riya", 5000),
            new Account("Aman"),
            new Account("Neha", 3000)
        };

        accounts[0].deposit(2000);
        System.out.println("After deposit: " + accounts[0].getBalance());

        boolean firstWithdrawal = accounts[0].withdraw(3000);
        System.out.println("Withdraw 3000 successful: " + firstWithdrawal);
        System.out.println("Balance: " + accounts[0].getBalance());

        boolean secondWithdrawal = accounts[0].withdraw(10000);
        System.out.println("Withdraw 10000 successful: " + secondWithdrawal);
        System.out.println("Balance: " + accounts[0].getBalance());

        System.out.println("\nAll accounts:");
        for (Account account : accounts) {
            System.out.println(account.getAccountNumber() + " | "
                    + account.getOwnerName() + " | "
                    + account.getBalance());
        }
    }
}