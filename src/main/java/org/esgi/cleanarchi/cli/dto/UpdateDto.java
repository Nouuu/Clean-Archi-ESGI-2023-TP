package org.esgi.cleanarchi.cli.dto;

import java.time.ZonedDateTime;
import java.util.Date;

public record UpdateDto(Integer id, String content, ZonedDateTime dueDate, StateDto state) {
}
