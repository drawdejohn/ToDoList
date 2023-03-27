import java.time.LocalDate;

public class TestTaskManager {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task("Test task 1", "This is a test task", LocalDate.now());
        Task task2 = new Task("Test task 2", "This is another test task", LocalDate.now().plusDays(1));
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        // Test getTaskCount
        if (taskManager.getTaskCount() == 2) {
            System.out.println("Task count is 2");
        }

        // Test getTask
        if (taskManager.getTask(0).equals(task1)) {
            System.out.println("First task is task1");
        }
        if (taskManager.getTask(1).equals(task2)) {
            System.out.println("Second task is task2");
        }

        // Test removeTask
        taskManager.removeTask(0);
        if (taskManager.getTaskCount() == 1) {
            System.out.println("Expected task count is 1 after removing a task");
        }
        if (taskManager.getTask(0).equals(task2)) {
            System.out.println("Expected first task is task2 after removing a task");
        }

    }
}