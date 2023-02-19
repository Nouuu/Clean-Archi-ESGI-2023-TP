package org.esgi.cleanarchi.infra.cli.controller;

import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.domain.query.TaskQueryHandler;
import org.esgi.cleanarchi.infra.cli.response.TaskResponse;
import org.esgi.cleanarchi.infra.cli.response.TaskResponseAdapter;
import org.esgi.cleanarchi.infra.io.Writer;

import java.util.List;

public class ListController {

    private final TaskQueryHandler taskQueryHandler;
    private final Writer writer;
    public ListController(TaskQueryHandler taskQueryHandler, Writer writer) {
        this.taskQueryHandler = taskQueryHandler;
        this.writer = writer;
    }

    public Void handle() {

        List<Task> result =  this.taskQueryHandler.getAllTasks();

        List<TaskResponse> taskResponses = result.stream().map(TaskResponseAdapter::fromTask).toList();

        List<String> taskResponseJsonViews = taskResponses.stream().map(TaskResponse::toJsonView).toList();

        this.writer.write(String.valueOf(taskResponseJsonViews));

        System.out.print("\u001B[31m");
        System.out.println("Bonjour le monde");
        System.out.print("\u001B[0m");

        return null;
    }
}
