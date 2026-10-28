public class StatementFormatter {
    public static String buildStatement(Account account) {
        StringBuilder statement = new StringBuilder();

        statement.append("------ Account Statement ------\n");
        statement.append("Account number: ")
                 .append(account.getAccountNumber())
                 .append('\n');
        statement.append("Owner: ")
                 .append(account.getOwnerName())
                 .append('\n');
        statement.append("Balance: ")
                 .append(account.getBalance())
                 .append('\n');
        statement.append("Active: ")
                 .append(account.isActive())
                 .append('\n');
        statement.append("-------------------------------");

        return statement.toString();
    }
}