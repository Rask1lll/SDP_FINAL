import java.util.Comparator;
import java.util.List;

public class DateSortStrategy implements SortStrategy {
    @Override
    public List<Task> sort(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getDate));
        return tasks;
    }
}
