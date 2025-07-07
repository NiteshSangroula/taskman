package com.nitesh.taskman.parser;

import java.util.HashMap;
import java.util.Map;

public class CommandParser {

    public static ParsedInput parse(String input) {

        //String[] tokens = input.trim().split("\\s+");

        String[] tokens = input.trim().split(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

        for (int i =0; i<tokens.length; i++) {
            tokens[i] = tokens[i].replace("\"", "");
        }
        String command = tokens[0];

        Map<String, String> args = new HashMap<>();
        for (int i=1; i < tokens.length - 1; i += 2) {
            String flag = tokens[i];
            String value = tokens[i+1];
            args.put(flag, value);
        }

        return new ParsedInput(command, args);


    }

}
