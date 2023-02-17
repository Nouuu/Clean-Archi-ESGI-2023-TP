package org.esgi.cleanarchi.domain;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class Task {
    private final Integer id;
    private final String description;
    private final ZonedDateTime createdDate;
    private final Optional<ZonedDateTime> dueDate;
    private final Optional<ZonedDateTime> closeDate;
    private final TaskState taskState;
    private final List<Task> subTasks;

    private Task(Integer id, String description, ZonedDateTime createdDate, Optional<ZonedDateTime> dueDate, Optional<ZonedDateTime> closeDate, TaskState taskState, List<Task> subTasks) {
        this.id = Objects.requireNonNull(id);
        this.description = Objects.requireNonNull(description);
        this.createdDate = Objects.requireNonNull(createdDate);
        this.dueDate = dueDate;
        this.closeDate = closeDate;
        this.taskState = taskState;
        this.subTasks = subTasks;
    }

    public static Task of(Integer id, String description, ZonedDateTime createdDate, Optional<ZonedDateTime> dueDate, Optional<ZonedDateTime> closeDate, TaskState taskState, List<Task> subTasks) {
        return new Task(id, description, createdDate, dueDate, closeDate, taskState, subTasks);
    }

    public Integer id() {
        return id;
    }

    public String description() {
        return description;
    }

    public ZonedDateTime createdDate() {
        return createdDate;
    }

    public Optional<ZonedDateTime> dueDate() {
        return dueDate;
    }

    public Optional<ZonedDateTime> closeDate() {
        return closeDate;
    }

    public TaskState taskState() {
        return taskState;
    }

    public List<Task> subTasks() {
        return subTasks;
    }
}
