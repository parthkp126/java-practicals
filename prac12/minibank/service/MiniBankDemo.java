package service;

import java.util.ArrayList;
import model.Account;
import model.SavingsAccount;

public class MiniBankDemo {
    public static void main(String[] args) {
        AccountStore store = new AccountStore();

        Account first = new SavingsAccount("Riya", 5000, 1000);
        Account second = new SavingsAccount("Aman", 2000, 500);
        Account third = new SavingsAccount("Neha", 9000, 1000);

        store.add(first);
        store.add(second);
        store.add(third);

        store.addTransaction("DEPOSIT " + first.getAccountNumber() + " 500");

        System.out.println("Account lookup:");
        System.out.println(store.get(first.getAccountNumber()));

        System.out.println("\nAccounts sorted by balance:");
        ArrayList<Account> sorted = store.sortedByBalance();

        for (Account account : sorted) {
            System.out.println(account.getAccountNumber() + " | "
                    + account.getOwnerName() + " | "
                    + account.getBalance());
        }

        System.out.println("\nTransaction history:");
        for (String transaction : store.getTransactionHistory()) {
            System.out.println(transaction);
        }

        TransactionProcessor processor = new TransactionProcessor();
        processor.addAccount(first);
        processor.addAccount(second);
        processor.addAccount(third);

        System.out.println("\nThread-safe lookup: "
                + processor.getAccount(first.getAccountNumber())
                        .getOwnerName());

        try {
            processor.stop();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}