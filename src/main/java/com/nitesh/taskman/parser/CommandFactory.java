package com.nitesh.taskman.parser;

import java.util.Map;

import com.nitesh.taskman.command.*;
import com.nitesh.taskman.model.Priority;

public class CommandFactory implements ICommandFactory{

    private Map<String, String> args;

    public CommandFactory(Map<String, String> args) {
        this.args = args;
    }


    public Command createAddCommand() {
        String name = args.get("-n");
        String date = args.get("-d");
        String pStr = args.get("-p");
        Priority priority = pStr != null ? Priority.valueOf(pStr.toUpperCase()) : Priority.MEDIUM;
        return new AddCommand(name, date, priority);
    }

    public Command createDeleteCommand() {
        int id = Integer.parseInt(args.get("-id"));
        return new DeleteCommand(id);
    }
    public Command createListCommand() {
        return new ListCommand();
    }
    public Command createMarkCommand() {
        int id = Integer.parseInt(args.get("-id"));
        return new MarkCommand(id);
    }
    public Command createNoCommand() {
        return new NoOpCommand("Command does not exist!");
    }

}
