import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI {
    private TaskManager taskManager;
    private Scanner scanner;

    // Define ANSI escape codes for text colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Define ANSI escape codes for text styles
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_UNDERLINE = "\u001B[4m";

    public ConsoleUI(TaskManager taskManager) {
        this.taskManager = taskManager;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println(ANSI_BOLD + ANSI_CYAN + "\nWhat would you like to do?" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "1. Display all tasks" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "2. Add a new task" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "3. Remove a task" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "4. Mark a task as done" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "5. Mark a task as not done" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "6. Display task details" + ANSI_RESET);
        System.out.println(ANSI_RED + "0. Exit" + ANSI_RESET);
    }

    public String getUserInput() {
        return scanner.nextLine();
    }

    public void displayTasks() {
        System.out.println(ANSI_BOLD + "Tasks:" + ANSI_RESET);
        for (Task task : taskManager.getTasks()) {
            if (task.isDone()) {
                System.out.println(ANSI_GREEN + "- " + task.getName() + " (DONE)" + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "- " + task.getName() + ANSI_RESET);
            }
        }
    }

    public void addTask() {
        System.out.println(ANSI_BOLD + "-- Add Task --" + ANSI_RESET);
        System.out.print(ANSI_YELLOW + "Name: " + ANSI_RESET);
        String name = scanner.nextLine();
        System.out.print(ANSI_YELLOW + "Description: " + ANSI_RESET);
        String description = scanner.nextLine();
        System.out.print(ANSI_YELLOW + "Due Date (yyyy-mm-dd): " + ANSI_RESET);
        LocalDate dueDate = LocalDate.parse(scanner.nextLine());
        Task task = new Task(name, description, dueDate);
        taskManager.addTask(task);
        System.out.println(ANSI_GREEN + "\nTask added successfully." + ANSI_RESET);
        TaskFileHandler.saveTasks(taskManager.getTasks());
    }

    public void removeTask() {
        System.out.print(ANSI_BOLD + ANSI_RED + "Enter the index of the task to remove: " + ANSI_RESET);
        int index = Integer.parseInt(scanner.nextLine());
        taskManager.removeTask(index);
        System.out.println(ANSI_GREEN + "Task removed." + ANSI_RESET);
        TaskFileHandler.saveTasks(taskManager.getTasks());
    }

    public void markTaskAsDone() {
        System.out.print(ANSI_BOLD + ANSI_YELLOW + "Enter the index of the task to mark as done: " + ANSI_RESET);
        int index = Integer.parseInt(scanner.nextLine());
        taskManager.markTaskAsDone(index);
        System.out.println(ANSI_GREEN + "Task marked as done." + ANSI_RESET);
        TaskFileHandler.saveTasks(taskManager.getTasks());
    }

    public void markTaskAsNotDone() {
        System.out.print(ANSI_BOLD + ANSI_YELLOW + "Enter the index of the task to mark as not done: " + ANSI_RESET);
        int index = Integer.parseInt(scanner.nextLine());
        taskManager.markTaskAsNotDone(index);
        System.out.println(ANSI_GREEN + "Task marked as not done." + ANSI_RESET);
        TaskFileHandler.saveTasks(taskManager.getTasks());
    }

    public void displayTaskDetails() {
        System.out.print(ANSI_BOLD + ANSI_YELLOW + "Enter the index of the task to display details for: " + ANSI_RESET);
        int index = Integer.parseInt(scanner.nextLine());
        Task task = taskManager.getTask(index);
        if (task != null) {
            System.out.println(ANSI_BOLD + "Task Details:" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "Name: " + ANSI_RESET + task.getName());
            System.out.println(ANSI_YELLOW + "Description: " + ANSI_RESET + task.getDescription());
            System.out.println(ANSI_YELLOW + "Due Date: " + ANSI_RESET + task.getDueDate());
            System.out.println(ANSI_YELLOW + "Status: " + ANSI_RESET + (task.isDone() ? ANSI_GREEN + "Done" + ANSI_RESET : ANSI_RED + "Not Done" + ANSI_RESET));
        } else {
            System.out.println(ANSI_RED + "Invalid index." + ANSI_RESET);
        }
    }
}
