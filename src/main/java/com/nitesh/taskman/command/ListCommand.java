package com.nitesh.taskman.command;

import com.nitesh.taskman.manager.TaskManager;

public class ListCommand implements Command {
    @Override
    public void execute(TaskManager taskmanager) {
        taskmanager.listTasks();
    }
    
}
