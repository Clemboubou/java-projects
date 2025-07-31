package com.dfs_java;

import java.util.ArrayList;
import java.util.List;

public class DataBaseAccess {
    private static DataBaseAccess instance;
    private List<Task> tasks;
    private List<User> users;

    private DataBaseAccess() {
        this.tasks = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public static synchronized DataBaseAccess getInstance() {
        if (instance == null) {
            instance = new DataBaseAccess();
        }
        return instance;
    }

    // --- TASKS ---
    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task findTaskById(int id) throws ElementNotFoundException {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ElementNotFoundException("Task with id " + id + " not found"));
    }

    public void removeTaskById(int id) throws ElementNotFoundException {
        Task toRemove = findTaskById(id);
        tasks.remove(toRemove);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    // --- USERS ---
    public void addUser(User user) {
        users.add(user);
    }

    public User findUserById(int id) throws ElementNotFoundException {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ElementNotFoundException("User with id " + id + " not found"));
    }

    public void removeUserById(int id) throws ElementNotFoundException {
        User toRemove = findUserById(id);
        users.remove(toRemove);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    // Pour initialiser avec des données simulées
    public void initialize(List<Task> tasks, List<User> users) {
        this.tasks = new ArrayList<>(tasks);
        this.users = new ArrayList<>(users);
    }
}
