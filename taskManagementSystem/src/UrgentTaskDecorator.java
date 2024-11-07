public class UrgentTaskDecorator extends TaskDecorator {
    private boolean isUrgent;

    public UrgentTaskDecorator(Task task) {
        super(task);
        this.isUrgent = true;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    @Override
    public String toString() {
        return super.toString() + ", urgent task=" + isUrgent();
    }
}