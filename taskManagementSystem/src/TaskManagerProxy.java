import java.util.List;
public class TaskManagerProxy {
    private TaskManager taskManager;
    private String userRole;
    public TaskManagerProxy(String userRole) {
        this.userRole = userRole;
        this.taskManager = TaskManager.getInstance();
    }
    public void addTask(Task task) {
        if (userRole.equals("admin")) {
            taskManager.addTask(task);
            System.out.println("Task added: " + task);
        } else {
            System.out.println("Access denied: Only admins can add tasks.");
        }
    }
    public void updateTask(Task updatedTask) {
        if (userRole.equals("admin")) {
            taskManager.updateTask(updatedTask);
            System.out.println("Task updated: " + updatedTask);
        } else {
            System.out.println("Access denied: Only admins can update tasks.");
        }
    }
    public List<Task> getTasks() {
        return taskManager.getTasks();
    }
}
