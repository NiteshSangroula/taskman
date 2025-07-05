package com.nitesh.taskman.command;

import com.nitesh.taskman.manager.TaskManager;

public interface Command {
    void execute(TaskManager taskmanager);
}
