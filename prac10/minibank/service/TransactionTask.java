package service;

import exception.BankException;
import model.Account;

public class TransactionTask implements Runnable {
    private final Account account;
    private final boolean deposit;
    private final long amount;

    public TransactionTask(Account account, boolean deposit, long amount) {
        this.account = account;
        this.deposit = deposit;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            if (deposit) {
                account.deposit(amount);
                System.out.println("Deposited " + amount + " into "
                        + account.getAccountNumber());
            } else {
                account.withdraw(amount);
                System.out.println("Withdrew " + amount + " from "
                        + account.getAccountNumber());
            }
        } catch (BankException exception) {
            System.out.println("Transaction failed: "
                    + exception.getMessage());
        }
    }
}