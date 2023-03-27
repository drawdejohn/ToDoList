import java.time.LocalDate;

public class TestTask {
    public static void main(String[] args) {
        Task task = new Task("Buy groceries", "Buy milk, eggs, and bread", LocalDate.now().plusDays(1));
        System.out.println("Task name: " + task.getName());
        System.out.println("Task description: " + task.getDescription());
        System.out.println("Task due date: " + task.getDueDate());
    }
}
