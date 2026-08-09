package minibank;

public class account {

    private final String accountnumber;
    private String ownername;
    private long balance;
    private boolean active;

    private static int accountcounter = 1;

    private static String generateaccountnumber() {
        return String.format("AC%04d", accountcounter++);
    }

    public account(String ownername, long balance) {
        accountnumber = generateaccountnumber();
        this.ownername = ownername;
        this.balance = balance;
        active = true;
    }

    public account(String ownername) {
        this(ownername, 0);
    }

    public void deposit(long amount) {
        if (amount < 0) {
            return;
        }
        balance += amount;
    }

    public boolean withdraw(long amount) {
        if (amount < 0) {
            return false;
        }

        if (balance >= amount) {
            balance -= amount;
            return true;
        }

        return false;
    }

    public String getaccountnumber() {
        return accountnumber;
    }

    public String getownername() {
        return ownername;
    }

    public long getbalance() {
        return balance;
    }

    public boolean isactive() {
        return active;
    }
}