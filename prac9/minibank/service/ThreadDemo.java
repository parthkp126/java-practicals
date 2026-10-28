package service;

import model.Account;
import model.SavingsAccount;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Account account = new SavingsAccount("Riya", 0, 0);

        int workerCount = 10;
        int depositsPerWorker = 1000;

        Thread[] threads = new Thread[workerCount];

        for (int i = 0; i < workerCount; i++) {
            AccountWorker worker =
                    new AccountWorker(account, depositsPerWorker, 1);

            threads[i] = new Thread(worker, "Worker-" + (i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}