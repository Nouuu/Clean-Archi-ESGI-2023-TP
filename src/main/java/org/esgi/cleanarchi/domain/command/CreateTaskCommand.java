package org.esgi.cleanarchi.domain.command;

import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.TaskState;

import java.time.ZonedDateTime;
import java.util.List;

public record CreateTaskCommand(
        String description,
        ZonedDateTime createdDate,
        ZonedDateTime dueDate,
        ZonedDateTime closeDate,
        TaskState taskState,
        List<Task> subTasks
) {
}
