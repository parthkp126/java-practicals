import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {
        List<String> logins = Arrays.asList(
                "riya", "aman", "riya", "neha", "aman", "karan"
        );

        Set<String> uniqueUsers = new HashSet<>(logins);
        Set<String> firstSeenOrder = new LinkedHashSet<>(logins);

        System.out.println("Unique visitors: " + uniqueUsers.size());

        System.out.println("First three distinct visitors:");
        int printed = 0;

        for (String user : firstSeenOrder) {
            if (printed == 3) {
                break;
            }

            System.out.println(user);
            printed++;
        }
    }
}