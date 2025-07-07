package com.nitesh.taskman.parser;

import java.util.Map;

public class ParsedInput {
    private final String command;
    private final Map<String, String> args;

    public ParsedInput(String command, Map<String, String> args) {
        this.command = command;
        this.args = args;

    }

    public String getCommand() {
        return command;
    }

    public Map<String, String> getArgs() {
        return args;
    }
}
