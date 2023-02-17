package org.esgi.cleanarchi.cli.dto;

import java.util.Date;

public record AddDto(
    String content,
    Date dueDate
) {
}
