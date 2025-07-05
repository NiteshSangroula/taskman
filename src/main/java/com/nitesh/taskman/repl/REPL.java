package com.nitesh.taskman.repl;

import java.util.Scanner;

import com.nitesh.taskman.command.Command;
import com.nitesh.taskman.manager.TaskManager;

public class REPL {
    public void run() {
        TaskManager taskmanager = new TaskManager();
        try (Scanner sc = new Scanner(System.in)) {
            while(true) {
                System.out.print("> ");
                String input = sc.nextLine().trim().toLowerCase();

                if (input.equals("exit")) {
                    break;
                } else if (input.equals("help")) {
                    printHelp();
                } else {
                    Command cmd = CommandParser.parse(input);
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
