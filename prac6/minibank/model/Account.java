package model;

public abstract class Account {
    private final String accountNumber;
    private String ownerName;
    protected long balance;
    private boolean active;

    private static int accountCounter = 0;

    private static String generateAccountNumber() {
        accountCounter++;
        return String.format("AC%04d", accountCounter);
    }

    protected Account(String ownerName, long openingBalance) {
        this.accountNumber = generateAccountNumber();
        this.ownerName = ownerName;
        this.balance = Math.max(0, openingBalance);
        this.active = true;
    }

    public synchronized void deposit(long amount) {
        if (amount > 0 && active) {
            balance += amount;
        }
    }

    public synchronized boolean withdraw(long amount) {
        if (amount <= 0 || !active || !canWithdraw(amount)) {
            return false;
        }

        balance -= amount;
        return true;
    }

    public abstract double interestRate();

    public abstract boolean canWithdraw(long amount);

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public synchronized long getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }
}