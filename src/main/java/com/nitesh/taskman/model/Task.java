package com.nitesh.taskman.model;

import java.io.Serializable;

public class Task implements Serializable{
    //private static int idCounter = 1;
    private final int id;
    private String name;
    private String dueDate;
    private Priority priority;
    private boolean done;

    public Task(int id, String name, String dueDate, Priority priority) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
        this.done = false;

        //idCounter++;
    }
    //getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDueDate() { return dueDate; }
    public Priority getPriority() { return priority; }
    public boolean isDone() { return done; }

    public void setDone(boolean done) { this.done = done; }

    @Override
    public String toString() {
        return String.format("[%d] \"%s\" (Due: %s, Priority: %s, Status: %s)", 
            id,
            name,
            dueDate,
            priority,
            done ? "Done" : "Pending"
        );
    }


}
