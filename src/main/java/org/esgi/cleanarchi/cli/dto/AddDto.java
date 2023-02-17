package org.esgi.cleanarchi.cli.dto;

import java.time.ZonedDateTime;

public record AddDto(
    String content,
    ZonedDateTime dueDate
) {
}
