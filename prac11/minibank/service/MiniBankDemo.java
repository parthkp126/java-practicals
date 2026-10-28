package service;

import java.nio.file.Path;
import java.nio.file.Paths;
import model.Account;
import model.SavingsAccount;

public class MiniBankDemo {
    public static void main(String[] args) {
        try {
            Account[] accounts = {
                new SavingsAccount("Riya", 5000, 1000),
                new SavingsAccount("Aman", 3000, 500)
            };

            Path accountsFile = Paths.get("data", "accounts.dat");
            StatePersister.save(accounts, accountsFile);

            Account[] loadedAccounts =
                    StatePersister.load(accountsFile);

            System.out.println("Reloaded accounts:");
            for (Account account : loadedAccounts) {
                System.out.println(account.getAccountNumber() + " | "
                        + account.getOwnerName() + " | "
                        + account.getBalance());
            }

            Path logFile = Paths.get("data", "logs", "transactions.log");

            TransactionLog.append(logFile, "DEPOSIT AC0001 500");
            TransactionLog.append(logFile, "WITHDRAW AC0002 200");

            String report = ReportGenerator.generate(
                    Paths.get("data", "logs"),
                    Paths.get("data", "report.txt")
            );

            System.out.println("\n" + report);
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}