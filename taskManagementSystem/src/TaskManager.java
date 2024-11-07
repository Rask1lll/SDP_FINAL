import java.util.ArrayList;
import java.util.List;
public class TaskManager {
    private static TaskManager instance;
    private List<Task> tasks;
    private TaskManager() {
        tasks = new ArrayList<>();
    }
    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }
    public void addTask(Task task) {
        tasks.add(task);
    }
    public void removeTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }
    public void updateTask(Task updatedTask) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == updatedTask.getId()) {
                tasks.set(i, updatedTask);
                break;
            }
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
