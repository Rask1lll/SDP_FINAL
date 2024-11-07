public abstract class TaskDecorator extends Task {
    protected Task task;

    public TaskDecorator(Task task) {
        super(task.getId(), task.getTitle(), task.getDescription(), task.getPriority(), task.getDate());
        this.task = task;
    }

    @Override
    public String toString() {
        return task.toString();
    }
}
