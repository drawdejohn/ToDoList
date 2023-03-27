public static void main(String[] args) {
    // create a new Task object
    Task task = new Task("Buy groceries", "Buy milk, eggs, and bread", LocalDate.now().plusDays(1));

    // test the getName method
    System.out.println("Task name: " + task.getName());

    // test the getDescription method
    System.out.println("Task description: " + task.getDescription());

    // test the getDueDate method
    System.out.println("Task due date: " + task.getDueDate());

    // test the setName method
    task.setName("Go shopping");
    System.out.println("New task name: " + task.getName());

    // test the setDescription method
    task.setDescription("Buy clothes and shoes");
    System.out.println("New task description: " + task.getDescription());

    // test the setDueDate method
    task.setDueDate(LocalDate.now().plusDays(2));
    System.out.println("New task due date: " + task.getDueDate());
}