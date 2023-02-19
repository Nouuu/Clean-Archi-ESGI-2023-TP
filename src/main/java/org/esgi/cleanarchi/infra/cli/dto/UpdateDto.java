package org.esgi.cleanarchi.infra.cli.dto;

import java.time.ZonedDateTime;

public record UpdateDto(Integer id, String content, ZonedDateTime dueDate, StateDto state) {
}
