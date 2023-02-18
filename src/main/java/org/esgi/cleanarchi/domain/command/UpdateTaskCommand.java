package org.esgi.cleanarchi.domain.command;

import org.esgi.cleanarchi.domain.TaskState;

import java.time.ZonedDateTime;
import java.util.Optional;

public record UpdateTaskCommand(
        Integer id,

        String content,
        ZonedDateTime dueDate,
        TaskState taskState
) {
}
