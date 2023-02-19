package org.esgi.cleanarchi.infra.cli.dto;

import java.time.ZonedDateTime;

public record AddDto(
        String content,
        ZonedDateTime dueDate,

        Integer parentId
) {
}
