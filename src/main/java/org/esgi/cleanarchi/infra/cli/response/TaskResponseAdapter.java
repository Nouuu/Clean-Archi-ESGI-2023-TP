package org.esgi.cleanarchi.infra.cli.response;

import org.esgi.cleanarchi.domain.Task;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

public class TaskResponseAdapter {
    public static TaskResponse fromTask(Task task) {

        return new TaskResponse(
                task.id().toString(),
                task.description(),
                task.createdDate().toString(),
                task.closeDate() != null ? task.closeDate().map(ZonedDateTime::toString).orElse("") : "",
                task.taskState().toString(),
                task.dueDate() != null ? task.dueDate().map(ZonedDateTime::toString).orElse("") : "",
                task.subTasks() != null ? task.subTasks().stream().map(TaskResponseAdapter::fromTask).toList() : List.of()
        );
    }
}
