import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        String[] logs = {
            "10:05 alice Hello there",
            "10:06 bob Need help with the assignment",
            "This line is malformed"
        };

        Scanner input = new Scanner(System.in);
        System.out.print("Enter keyword: ");
        String keyword = input.nextLine();

        ChatFilter.filterLogs(logs, keyword);

        input.close();
    }
}