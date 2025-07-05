package com.nitesh.taskman.repl;

import java.util.HashMap;
import java.util.Map;

import com.nitesh.taskman.command.*;

import com.nitesh.taskman.model.Priority;

public class CommandParser {

    public static Command parse(String input) {
        String[] tokens = input.trim().split("\\s+");
        String command = tokens[0];

        Map<String, String> args = new HashMap<>();
        for (int i=1; i < tokens.length - 1; i += 2) {
            String flag = tokens[i];
            String value = tokens[i+1];
            args.put(flag, value);
        }

        if (command.equals("add")) {

            String name = args.get("-n");
            String date = args.get("-d");
            String pStr = args.get("-p");
            Priority priority = pStr != null ? Priority.valueOf(pStr.toUpperCase()) : Priority.MEDIUM;

            return new AddCommand(name, date, priority);

        } else if (command.equals("delete")) {

            int id = Integer.parseInt(args.get("-id"));
            return new DeleteCommand(id);

        } else if (command.equals("done")) {

            int id = Integer.parseInt(args.get("-id"));
            return new MarkCommand(id);

        } else if (command.equals("list")) {
            return new ListCommand();
        } else {
            return new NoOpCommand(command +" does not exist!");
        }

    }

}
