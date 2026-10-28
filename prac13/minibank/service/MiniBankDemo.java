package service;

import model.Account;
import model.SavingsAccount;

public class MiniBankDemo {
    public static void main(String[] args) {
        Repository<Account> accounts = new Repository<>();

        Account first = new SavingsAccount("Riya", 5000, 1000);
        Account second = new SavingsAccount("Aman", 2000, 500);
        Account third = new SavingsAccount("Neha", 9000, 1000);

        accounts.saveAll(first, second, third);

        String searchId = second.getAccountNumber();

        System.out.println("Account found:");
        System.out.println(accounts.findById(searchId));

        System.out.println("\nAll accounts:");
        for (Account account : accounts.findAll()) {
            System.out.println(account);
        }

        System.out.println("\nDeleted: "
                + accounts.delete(first.getAccountNumber()));
        System.out.println("Accounts remaining: "
                + accounts.findAll().size());
    }
}