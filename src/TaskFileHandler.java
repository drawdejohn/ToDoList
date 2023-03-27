import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskFileHandler {
    private static final String FILE_NAME = "tasks.txt";

    public List<Task> readTasksFromFile() {
        List<Task> tasks = new ArrayList<>();
        try {
            File file = new File(FILE_NAME);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                String name = parts[0];
                String description = parts[1];
                LocalDate dueDate = LocalDate.parse(parts[2]);
                boolean done = Boolean.parseBoolean(parts[3]);
                Task task = new Task(name, description, dueDate);
                task.setDone(done);
                tasks.add(task);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        return tasks;
    }

    public static void saveTasks(List<Task> tasks) {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            for (Task task : tasks) {
                String line = task.getName() + "|" + task.getDescription() + "|" +
                        task.getDueDate().toString() + "|" + task.isDone() + "\n";
                writer.write(line);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
