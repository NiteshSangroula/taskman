package com.nitesh.taskman.manager;

import java.util.ArrayList;
import java.util.List;

import com.nitesh.taskman.model.Priority;
import com.nitesh.taskman.model.Task;
import com.nitesh.taskman.storage.Storagemanager;

public class TaskManager {
    private final List<Task> tasks;
    private final Storagemanager storagemanager;

    public TaskManager(Storagemanager storagemanager) {
        this.storagemanager = storagemanager;
        this.tasks = storagemanager.loadTasks();
    }

    public void addTask(String name, String dueDate, Priority priority){
        Task newTask = new Task(name, dueDate, priority);
        tasks.add(newTask);
        System.out.println("Task added: " + newTask);
        storagemanager.saveTasks(tasks);
    }

    public void deleteTask(int id) {
        boolean removed = tasks.removeIf(task -> task.getId() == id);
        if (removed) {
            System.out.println("Task deleted: " + id);
            storagemanager.saveTasks(tasks);
        } else {
            System.out.println("No task found with ID: " + id);
        }
    }

    public void markTask(int id) {
        for (Task task: tasks) {
            if (task.getId() == id) {
                task.setDone(true);
                System.out.println("Task marked as done: " + task);
                storagemanager.saveTasks(tasks);
                return;
            }
        }
        System.out.println("No task found with ID: " + id);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found!");
        }
        
        for (Task task: tasks) {
            System.out.println(task);
        }

    }
}
