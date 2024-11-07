import java.util.Date;

public class TaskFactory {
    public Task createTask(int id, String title, String description, int priority, Date date) {
        return new Task(id, title, description, priority, date);
    }
}
