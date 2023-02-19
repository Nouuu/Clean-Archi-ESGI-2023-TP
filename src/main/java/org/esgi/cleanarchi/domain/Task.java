package org.esgi.cleanarchi.domain;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class Task {
    private final Integer id;
    private final Integer parentId;
    private final String description;
    private final ZonedDateTime createdDate;
    private final ZonedDateTime dueDate;
    private final ZonedDateTime closeDate;
    private final TaskState taskState;
    private final List<Task> subTasks;

    private Task(Integer id, Integer parentId, String description, ZonedDateTime createdDate, ZonedDateTime dueDate, ZonedDateTime closeDate, TaskState taskState, List<Task> subTasks) {
        this.id = Objects.requireNonNull(id);
        this.parentId = parentId;
        this.description = Objects.requireNonNull(description);
        this.createdDate = Objects.requireNonNull(createdDate);
        this.dueDate = dueDate;
        this.closeDate = closeDate;
        this.taskState = taskState;
        this.subTasks = subTasks;
    }

    public static Task of(Integer id, Integer parentId, String description, ZonedDateTime createdDate, ZonedDateTime dueDate, ZonedDateTime closeDate, TaskState taskState, List<Task> subTasks) {
        return new Task(id, parentId, description, createdDate, dueDate, closeDate, taskState, subTasks);
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
        return Optional.ofNullable(dueDate);
    }

    public Optional<ZonedDateTime> closeDate() {
        return Optional.ofNullable(closeDate);
    }

    public TaskState taskState() {
        return taskState;
    }

    public Optional<Integer> parentId() {
        return Optional.ofNullable(parentId);
    }

    public List<Task> subTasks() {
        return subTasks;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", dueDate=" + dueDate +
                ", closeDate=" + closeDate +
                ", taskState=" + taskState +
                ", subTasks=" + subTasks +
                '}';
    }


}
