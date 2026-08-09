package minibank;

import java.util.Scanner;

public class minibank {

    public static void transfer(account from, account to, long amount) {

        if (from.withdraw(amount)) {
            to.deposit(amount);
            System.out.println("transfer successful");
        } else {
            System.out.println("transfer failed");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        bankinfo bank = new bankinfo("mini bank", "main branch");

        System.out.println("================================");
        System.out.println(bank.name());
        System.out.println(bank.branch());
        System.out.println("================================");

        account[] accounts = new account[3];

        accounts[0] = new account("parth", 5000);
        accounts[1] = new account("rahul");
        accounts[2] = new account("amit", 2000);

        accounts[0].deposit(1000);
        accounts[1].deposit(3000);
        accounts[2].withdraw(500);

        transfer(accounts[0], accounts[1], 1000);

        System.out.println();

        for (account a : accounts) {
            System.out.println(a.getaccountnumber() + "  " + a.getownername() + "  balance : " + a.getbalance());
        }

        while (true) {

            System.out.println("\n1. open account");
            System.out.println("2. deposit");
            System.out.println("3. withdraw");
            System.out.println("4. transfer");
            System.out.println("5. exit");

            System.out.print("enter choice : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("open account - to be implemented");
                    break;

                case 2:
                    System.out.println("deposit - to be implemented");
                    break;

                case 3:
                    System.out.println("withdraw - to be implemented");
                    break;

                case 4:
                    System.out.println("transfer - to be implemented");
                    break;

                case 5:
                    System.out.println("goodbye");
                    sc.close();
                    return;

                default:
                    System.out.println("invalid choice");
            }
        }
    }
}