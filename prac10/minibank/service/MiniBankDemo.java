
package service;

import model.Account;
import model.SavingsAccount;

public class MiniBankDemo {
    public static void main(String[] args) throws InterruptedException {
        Account account = new SavingsAccount("Riya", 10000, 0);

        TransactionProcessor processor = new TransactionProcessor();

        for (int i = 0; i < 10; i++) {
            processor.submit(new TransactionTask(account, true, 500));
        }

        processor.submit(new TransactionTask(account, false, 1000));

        processor.stop();

        System.out.println("Final balance: " + account.getBalance());
    }
}