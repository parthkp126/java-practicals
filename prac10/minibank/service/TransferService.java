package service;

import exception.BankException;
import model.Account;

public class TransferService {
    public static void transferSafely(
            Account from,
            Account to,
            long amount
    ) throws BankException {
        Account first = from.getAccountNumber()
                .compareTo(to.getAccountNumber()) < 0 ? from : to;
        Account second = first == from ? to : from;

        synchronized (first) {
            synchronized (second) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }
}