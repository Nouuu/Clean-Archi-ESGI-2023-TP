package org.esgi.cleanarchi.infra.cli.controller;

import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.query.TaskQueryHandler;
import org.esgi.cleanarchi.infra.cli.helper.CliHelper;
import org.esgi.cleanarchi.infra.cli.helper.OverdueTaskPredicate;

import java.util.ArrayList;
import java.util.List;

public class ListController {

    private final TaskQueryHandler taskQueryHandler;
    private final CliHelper cliHelper;
    private final OverdueTaskPredicate overdueTaskPredicate;

    public ListController(TaskQueryHandler taskQueryHandler, CliHelper cliHelper, OverdueTaskPredicate overdueTaskPredicate) {
        this.taskQueryHandler = taskQueryHandler;
        this.cliHelper = cliHelper;
        this.overdueTaskPredicate = overdueTaskPredicate;
    }

    public void handle() {
        List<Task> result = new ArrayList<>(this.taskQueryHandler.getAllTasksOrderByCreatedDate());

        List<Task> overdueTasks = result.stream()
                .filter(overdueTaskPredicate)
                .toList();
        overdueTasks.forEach(task -> cliHelper.displayOverdueTask(task, 0));
        result.removeAll(overdueTasks);
        result.forEach(task -> cliHelper.displayColoredTask(task, 0));
    }
}
