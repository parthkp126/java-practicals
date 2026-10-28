public class AccountDemo {
    public static void main(String[] args) {
        Account[] accounts = {
            new SavingsAccount("Riya", 10000, 2000),
            new CurrentAccount("Aman", 5000, 3000),
            new FixedDepositAccount("Neha", 20000)
        };

        for (Account account : accounts) {
            System.out.println(account);
            System.out.println("Withdrawal of 4000 successful: "
                    + account.withdraw(4000));

            if (account instanceof SavingsAccount savings) {
                System.out.println("Minimum balance: "
                        + savings.getMinBalance());
            }

            System.out.println();
        }
    }
}