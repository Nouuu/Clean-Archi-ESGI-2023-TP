package org.esgi.cleanarchi.infra.cli.response;

import org.esgi.cleanarchi.domain.Task;

public class TaskResponseAdapter {
    public static TaskResponse fromTask(Task task) {
        return new TaskResponse(
                task.id().toString(),
                task.description(),
                task.createdDate().toString(),
                task.closeDate().toString(),
                task.taskState().toString(),
                task.dueDate().toString(),
                task.subTasks().stream().map(TaskResponseAdapter::fromTask).toList()
        );
    }
}
