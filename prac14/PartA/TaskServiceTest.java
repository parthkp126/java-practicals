import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
    @Test
    void addingTaskIncreasesCount() {
        TaskService service = new TaskService();

        service.addTask("Finish practical");

        assertEquals(1, service.count());
    }

    @Test
    void blankTaskNameThrowsException() {
        TaskService service = new TaskService();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.addTask("")
        );
    }
}