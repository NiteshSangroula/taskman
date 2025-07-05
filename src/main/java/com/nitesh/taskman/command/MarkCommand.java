package com.nitesh.taskman.command;

import com.nitesh.taskman.manager.TaskManager;

public class MarkCommand implements Command {
    private final int taskId;

    public MarkCommand(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void execute(TaskManager taskmanager) {
        taskmanager.markTask(taskId);
    }
}
