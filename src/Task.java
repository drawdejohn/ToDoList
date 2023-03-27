// define three private instance variables to represent the task name, task description, and task due date
private String name;
private String description;
private LocalDate dueDate;

//Create a constructor for the Task class that takes in the task name, task description, and task due date as parameters and initializes the instance variables
public Task(String name, String description, LocalDate dueDate) {
    this.name = name;
    this.description = description;
    this.dueDate = dueDate;
}

//Create getter and setter methods for each of the instance variables
public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public LocalDate getDueDate() {
    return dueDate;
}

public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
}