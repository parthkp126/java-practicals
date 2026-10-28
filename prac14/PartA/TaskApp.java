import java.util.Scanner;

public class TaskApp {
    public static void main(String[] args) {
        TaskService service = new TaskService();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a task name: ");
        String name = input.nextLine();

        try {
            service.addTask(name);
            System.out.println("Task added. Total: " + service.count());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        input.close();
    }
}