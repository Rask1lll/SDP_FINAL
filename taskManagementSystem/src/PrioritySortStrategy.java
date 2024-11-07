import java.util.Comparator;
import java.util.List;
public class PrioritySortStrategy implements SortStrategy {
    @Override
    public List<Task> sort(List<Task> tasks) {
        tasks.sort(Comparator.comparingInt(Task::getPriority).reversed());
        return tasks;
    }
}
