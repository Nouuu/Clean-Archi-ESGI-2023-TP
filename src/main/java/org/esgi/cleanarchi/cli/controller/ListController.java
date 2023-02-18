package org.esgi.cleanarchi.cli.controller;

import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.query.TaskQueryHandler;
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
        this.writer.write(result.toString());

        return null;
    }
}
