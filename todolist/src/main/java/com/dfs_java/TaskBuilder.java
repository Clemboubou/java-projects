package com.dfs_java;

public class TaskBuilder {
    private int id;
    private String title;
    private String description;
    private boolean completed;
    private int userId;

    public TaskBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public TaskBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public TaskBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public TaskBuilder setCompleted(boolean completed) {
        this.completed = completed;
        return this;
    }

    public TaskBuilder setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public Task build() {
        return new Task(id, title, description, completed, userId);
    }
}
