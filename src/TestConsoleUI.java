public class TestConsoleUI {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        ConsoleUI consoleUI = new ConsoleUI(taskManager);

        consoleUI.displayMenu();
        String userInput = consoleUI.getUserInput();
        while (!userInput.equals("0")) {
            switch (userInput) {
                case "1":
                    consoleUI.displayTasks();
                    break;
                case "2":
                    consoleUI.addTask();
                    break;
                case "3":
                    consoleUI.removeTask();
                    break;
                case "4":
                    consoleUI.markTaskAsDone();
                    break;
                case "5":
                    consoleUI.markTaskAsNotDone();
                    break;
                case "6":
                    consoleUI.displayTaskDetails();
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
            consoleUI.displayMenu();
            userInput = consoleUI.getUserInput();
        }
    }
}