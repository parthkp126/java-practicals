package service;

import exception.InsufficientFundsException;
import exception.InvalidAmountException;
import model.Account;
import model.SavingsAccount;

public class MiniBankDemo {
    public static void main(String[] args) {
        Account account = new SavingsAccount("Riya", 1000, 0);

        try {
            account.withdraw(5000);
        } catch (InsufficientFundsException exception) {
            System.out.println("Withdrawal failed: short by "
                    + exception.getShortfall());
        } catch (InvalidAmountException exception) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("Balance: " + account.getBalance());
        }

        try (DemoResource resource = new DemoResource()) {
            System.out.println("Using demo resource.");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    static class DemoResource implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("Demo resource closed.");
        }
    }
}