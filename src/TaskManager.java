import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int index) {
        tasks.remove(index);
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public int getTaskCount() {
        return tasks.size();
    }


    public void markTaskAsDone(int index) {
        Task task = getTask(index);
        if (task != null) {
            task.setDone(true);
        }
    }

    public void markTaskAsNotDone(int index) {
        Task task = getTask(index);
        if (task != null) {
            task.setDone(false);
        }
    }
}