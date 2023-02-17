package org.esgi.cleanarchi.cli.dto;

import java.util.Date;

public record UpdateDto(Integer id, String content, Date dueDate, StateDto state) {
}
