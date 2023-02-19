package org.esgi.cleanarchi.infra.data;

import java.time.ZonedDateTime;
import java.util.List;

public record TaskEntity(
        Integer id,
        String description,
        ZonedDateTime createdDate,
        ZonedDateTime dueDate,
        ZonedDateTime closeDate,
        String taskState,
        List<TaskEntity> subTasks
) {
}
