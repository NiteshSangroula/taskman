package com.nitesh.taskman.repl;

import java.util.Scanner;

import com.nitesh.taskman.command.Command;
import com.nitesh.taskman.manager.TaskManager;
import com.nitesh.taskman.parser.*;
import com.nitesh.taskman.storage.Storagemanager;
import com.nitesh.taskman.util.AppPaths;

public class REPL {
    public void run() {
        String filePath = AppPaths.getDataFilePath("tasks.ser");
        TaskManager taskmanager = new TaskManager(new Storagemanager(filePath));

        try (Scanner sc = new Scanner(System.in)) {
            while(true) {
                System.out.print("> ");
                String input = sc.nextLine().trim().toLowerCase();

                if (input.equals("exit")) {
                    break;
                } else if (input.equals("help")) {
                    printHelp();
                } else {
                    ParsedInput parsedInput = CommandParser.parse(input);
                    CommandFactory factory = new CommandFactory(parsedInput.getArgs());
                    Command cmd = switch(parsedInput.getCommand()){
                        case "add" -> factory.createAddCommand();
                        case "delete" -> factory.createDeleteCommand();
                        case "done" -> factory.createMarkCommand();
                        case "list" -> factory.createListCommand();
                        default -> factory.createNoCommand();
                    };
                    cmd.execute(taskmanager);
                }
                
            }
        }
    }
    private void printHelp() {
        System.out.println("\n=== TaskMan Help Menu ===");
        System.out.println("Available commands:");
        System.out.println();
        System.out.println("  add -n <name> -d <due_date> [-p <priority>] [-c <category>]");
        System.out.println("      Adds a new task.");
        System.out.println();
        System.out.println("  list [--sort <date|priority>] [--filter <category|status>]");
        System.out.println("      Lists all tasks. Optional sorting/filtering.");
        System.out.println();
        System.out.println("  delete -id <task_id>");
        System.out.println("      Deletes the task with the given ID.");
        System.out.println();
        System.out.println("  done -id <task_id>");
        System.out.println("      Marks a task as completed.");
        System.out.println();
        System.out.println("  help");
        System.out.println("      Displays this help menu.");
        System.out.println();
        System.out.println("  exit");
        System.out.println("      Exits TaskMan.");
        System.out.println();
    }
}
