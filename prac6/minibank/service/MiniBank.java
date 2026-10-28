package service;

import model.Account;
import model.SavingsAccount;
import model.Premium;
import util.WithdrawRule;

public class MiniBank {
    public static void main(String[] args) {
        Account account = new SavingsAccount("Riya", 10000, 2000);

        WithdrawRule anonymousRule = new WithdrawRule() {
            @Override
            public boolean allow(Account account, long amount) {
                return amount > 0
                        && account.getBalance() - amount >= 2000;
            }
        };

        WithdrawRule lambdaRule = (acc, amount) ->
                amount > 0 && acc.getBalance() - amount >= 2000;

        System.out.println("Anonymous rule allows: "
                + anonymousRule.allow(account, 3000));
        System.out.println("Lambda rule allows: "
                + lambdaRule.allow(account, 3000));

        if (account instanceof Premium) {
            System.out.println("This is a premium account.");
        }
    }
}