import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private static final String FILE_NAME = "tasks.dat";

    public TaskManager() {
        tasks = new ArrayList<>();
        loadTasks();
    }

    public void addTask(Task task) {
        tasks.add(task);
        saveTasks();
    }

    public void removeTask(int index) {
        tasks.remove(index);
        saveTasks();
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
            saveTasks();
        }
    }

    public void markTaskAsNotDone(int index) {
        Task task = getTask(index);
        if (task != null) {
            task.setDone(false);
            saveTasks();
        }
    }
    
    @SuppressWarnings("unchecked")
    private void loadTasks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            tasks = (List<Task>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No saved tasks found.");
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

    private void saveTasks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}
