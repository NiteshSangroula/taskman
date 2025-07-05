package com.nitesh.taskman.command;

import com.nitesh.taskman.manager.TaskManager;

public class NoOpCommand implements Command{

    private final String message;
    public NoOpCommand(String message) {
        this.message = message;
    }

    @Override
    public void execute(TaskManager taskmanager) {
        System.out.println(message);
    }

}
