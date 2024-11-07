import java.util.ArrayList;
import java.util.List;
public class TaskObserver {
    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void notifyObservers(Task task) {
        for (Observer observer : observers) {
            observer.update(task);
        }
    }
}