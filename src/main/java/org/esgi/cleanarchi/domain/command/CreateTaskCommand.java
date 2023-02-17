package org.esgi.cleanarchi.domain.command;

import java.time.ZonedDateTime;

public record CreateTaskCommand(
        String description,
        ZonedDateTime dueDate
) {
}
