package com.nitesh.taskman.parser;

import com.nitesh.taskman.command.Command;

public interface ICommandFactory {

    Command createAddCommand();
    Command createDeleteCommand();
    Command createListCommand();
    Command createMarkCommand();
    Command createNoCommand();
}
