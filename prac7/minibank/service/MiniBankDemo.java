package service;

import java.lang.reflect.Field;
import model.Account;
import model.SavingsAccount;
import util.AnnotationValidator;

public class MiniBankDemo {
    public static void main(String[] args) throws Exception {
        Account account = new SavingsAccount("Riya", 5000, 1000);

        Field balanceField =
                Account.class.getDeclaredField("balance");
        balanceField.setAccessible(true);
        balanceField.setLong(account, -100);

        String[] errors = AnnotationValidator.validate(account);

        for (String error : errors) {
            System.out.println(error);
        }
    }
}