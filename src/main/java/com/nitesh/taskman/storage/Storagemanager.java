package com.nitesh.taskman.storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nitesh.taskman.model.Task;

public class Storagemanager {

    private final Serializer<List<Task>> serializer;
    private final String filePath;

    public Storagemanager(String filePath) {
        this.serializer = new JavaSerializer<>();
        this.filePath = filePath;
    }

    public void saveTasks(List<Task> tasks) {
        try {
            serializer.save(tasks, filePath);
        } catch(IOException e) {
            System.out.println("Failed to save tasks: " + e.getMessage());
        }
    }

    public List<Task> loadTasks() {
        try {
            return serializer.load(filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous tasks found or failed to load: " + e.getMessage());
            return new ArrayList<>();

        }
    }

}
