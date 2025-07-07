package com.nitesh.taskman.parser;

import java.util.Map;

import com.nitesh.taskman.command.*;
import com.nitesh.taskman.model.Priority;

public class CommandFactory {

    public static Command getCommand(ParsedInput input) {
        return buildCommand(input.getCommand(), input.getArgs());
    }

    public static Command buildCommand(String command, Map<String, String> args) {
        switch (command.toLowerCase()) {
            case "add" -> {
                String name = args.get("-n");
                String date = args.get("-d");
                String pStr = args.get("-p");
                Priority priority = pStr != null ? Priority.valueOf(pStr.toUpperCase()) : Priority.MEDIUM;
                return new AddCommand(name, date, priority);
            }

            case "delete" -> {
                int id = Integer.parseInt(args.get("-id"));
                return new DeleteCommand(id);
            }

            case "done" -> {
                int id = Integer.parseInt(args.get("-id"));
                return new MarkCommand(id);
            }

            case "list" -> {
                return new ListCommand();
            }

            default -> {
                return new NoOpCommand(command + " does not exist!");
            }
        }

    }
}
