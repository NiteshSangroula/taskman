package com.nitesh.taskman.command;

import com.nitesh.taskman.manager.TaskManager;
import com.nitesh.taskman.model.Priority;

public class AddCommand implements Command{
    private String name;
    private String dueDate;
    private Priority priority;

    public AddCommand(String name, String dueDate, Priority priority) {
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    @Override
    public void execute(TaskManager taskmanager) {
        taskmanager.addTask(name, dueDate, priority);
    }

    
}
