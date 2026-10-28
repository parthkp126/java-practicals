import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Task name is required.");
        }
        tasks.add(new Task(name));
    }

    public int count() {
        return tasks.size();
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }
}