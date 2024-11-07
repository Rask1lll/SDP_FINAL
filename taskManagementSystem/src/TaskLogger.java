public class TaskLogger implements Observer {
    @Override
    public void update(Task task) {
        System.out.println("Task updated: " + task);
    }
}
