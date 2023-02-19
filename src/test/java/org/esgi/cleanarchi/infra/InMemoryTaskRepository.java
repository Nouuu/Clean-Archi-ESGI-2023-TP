package org.esgi.cleanarchi.infra;

import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.domain.TaskState;
import org.esgi.cleanarchi.infra.io.exception.InputOutputException;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class InMemoryTaskRepository implements TaskRepository {
    DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    private final List<Task> tasks = new ArrayList<Task>(Arrays.asList(
            Task.of(1, "init a project to create an app for my tasks", ZonedDateTime.parse("2022-02-15T22:14:30.486798+01:00", formatter), Optional.ofNullable(ZonedDateTime.parse("2022-02-15T22:14:30.486798+01:00", formatter)), null, TaskState.TODO, null),
            Task.of(2, "make a design of my needs to manage my tasks", ZonedDateTime.parse("2022-02-13T22:14:30.536023+01:00", formatter), Optional.ofNullable(ZonedDateTime.parse("2022-02-16T21:14:30.536024+01:00", formatter)), null, TaskState.PROGRESS, null),
            Task.of(3, "brainstorm on what project to work on", ZonedDateTime.parse("2022-01-16T22:14:30.536143+01:00", formatter), Optional.ofNullable(ZonedDateTime.parse("2022-02-16T21:14:30.536024+01:00", formatter)), Optional.ofNullable(ZonedDateTime.parse("2022-02-11T22:14:30.536144+01:00", formatter)), TaskState.CLOSED, null)
    ));
    @Override
    public void save(Task task) throws InputOutputException {
        this.tasks.add(task);
    }

    @Override
    public Optional<Task> get(Integer id) {
        return this.tasks.stream().filter(task -> task.id().equals(id)).findFirst();
    }

    @Override
    public List<Task> getAll() {
        return this.tasks;
    }

    @Override
    public List<Task> getAllOrderByCreatedDate() {
        return this.tasks.stream().sorted(Comparator.comparing(Task::createdDate)).toList();
    }

    @Override
    public void delete(Integer id) {
        this.tasks.removeIf(task -> task.id().equals(id));
    }

    @Override
    public Integer nextId() {
        int max = this.tasks.stream().max(Comparator.comparing(Task::id)).get().id();
        System.out.println(max + 1);
        return max + 1;
    }
}
