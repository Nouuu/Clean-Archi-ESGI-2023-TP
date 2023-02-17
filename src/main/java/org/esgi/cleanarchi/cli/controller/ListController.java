package org.esgi.cleanarchi.cli.controller;

import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.query.TaskQueryHandler;

import java.util.List;

public class ListController {

    private final TaskQueryHandler taskQueryHandler;
    public ListController(TaskQueryHandler taskQueryHandler) {
        this.taskQueryHandler = taskQueryHandler;
    }

    public Void handle() {

        List<Task> result =  this.taskQueryHandler.getAllTasks();

    }
}
