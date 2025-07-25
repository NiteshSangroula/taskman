package com.nitesh.taskman.command;

import com.nitesh.taskman.manager.TaskManager;

public class DeleteCommand implements Command{
    private final int taskId;

    public DeleteCommand(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void execute(TaskManager taskmanager) {
        taskmanager.deleteTask(taskId);
    }
}
