import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskManagerProxy taskManagerProxy = new TaskManagerProxy("admin");
        TaskFactory taskFactory = new TaskFactory();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date1 = dateFormat.parse("05-11-2024");
            Date date2 = dateFormat.parse("10-11-2024");

            Task task1 = taskFactory.createTask(1, "Buy groceries", "Buy vegetables and fruits", 2, date1);
            Task task2 = taskFactory.createTask(2, "Prepare report", "Weekly report", 5, date2);

            taskManagerProxy.addTask(task1);
            taskManagerProxy.addTask(task2);

            Task urgentTask = new UrgentTaskDecorator(task2);
            taskManagerProxy.updateTask(urgentTask);

            TaskObserver taskObserver = new TaskObserver();
            TaskLogger taskLogger = new TaskLogger();
            taskObserver.addObserver(taskLogger);

            taskObserver.notifyObservers(task1);
            taskObserver.notifyObservers(task2);

            SortStrategy prioritySortStrategy = new PrioritySortStrategy();
            List<Task> sortedTasks = prioritySortStrategy.sort(taskManagerProxy.getTasks());
            System.out.println("Tasks sorted by priority:");
            for (Task task : sortedTasks) {
                System.out.println(task);
            }

            SortStrategy dateSortStrategy = new DateSortStrategy();
            List<Task> dateSortedTasks = dateSortStrategy.sort(taskManagerProxy.getTasks());
            System.out.println("\nTasks sorted by date:");
            for (Task task : dateSortedTasks) {
                System.out.println(task);
            }

            System.out.println("\nAll tasks:");
            for (Task task : taskManagerProxy.getTasks()) {
                System.out.println(task);
            }

        } catch (ParseException e) {
            System.out.println("Date format error: " + e.getMessage());
        }
    }
}
