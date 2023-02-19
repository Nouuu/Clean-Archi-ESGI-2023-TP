package org.esgi.cleanarchi.infra.cli.controller;

import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.domain.TaskState;
import org.esgi.cleanarchi.domain.query.TaskQueryHandler;
import org.esgi.cleanarchi.infra.cli.response.TaskResponse;
import org.esgi.cleanarchi.infra.cli.response.TaskResponseAdapter;
import org.esgi.cleanarchi.infra.io.Writer;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ListController {

    private final TaskQueryHandler taskQueryHandler;
    private final Writer writer;
    public ListController(TaskQueryHandler taskQueryHandler, Writer writer) {
        this.taskQueryHandler = taskQueryHandler;
        this.writer = writer;
    }

    public Void handle() {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        //List<Task> result =  this.taskQueryHandler.getAllTasks();
        List<Task> result =  new ArrayList<Task>(Arrays.asList(
                Task.of(1, "init a project to create an app for my tasks", ZonedDateTime.parse("2022-02-15T22:14:30.486798+01:00", formatter), Optional.ofNullable(ZonedDateTime.parse("2022-02-15T22:14:30.486798+01:00", formatter)), null, TaskState.TODO, null),
                Task.of(2, "make a design of my needs to manage my tasks", ZonedDateTime.parse("2022-02-13T22:14:30.536023+01:00", formatter), Optional.ofNullable(ZonedDateTime.parse("2022-02-16T21:14:30.536024+01:00", formatter)), null, TaskState.PROGRESS, null),
                Task.of(3, "brainstorm on what project to work on", ZonedDateTime.parse("2022-01-16T22:14:30.536143+01:00", formatter), Optional.ofNullable(ZonedDateTime.parse("2022-02-16T21:14:30.536024+01:00", formatter)), Optional.ofNullable(ZonedDateTime.parse("2022-02-11T22:14:30.536144+01:00", formatter)), TaskState.CLOSED, null)
        ));

        List<TaskResponse> taskResponses = result.stream().map(TaskResponseAdapter::fromTask).toList();

        List<String> taskResponseJsonViews = taskResponses.stream().map(TaskResponse::toJsonView).toList();

        this.writer.write(String.valueOf(taskResponseJsonViews));

        System.out.print("\u001B[31m");
        System.out.println("Bonjour le monde");
        System.out.print("\u001B[0m");

        return null;
    }
}
