package org.esgi.cleanarchi.infra.cli.controller;

import org.esgi.cleanarchi.domain.command.TaskCommandHandler;
import org.esgi.cleanarchi.infra.cli.dto.RemoveDto;
import org.esgi.cleanarchi.infra.cli.validator.ArgValidator;
import org.esgi.cleanarchi.infra.io.Writer;

public class RemoveController {
    private final ArgValidator<RemoveDto> validator;
    private final TaskCommandHandler taskCommandHandler;
    private final Writer writer;

    public RemoveController(ArgValidator<RemoveDto> validator, TaskCommandHandler taskCommandHandler, Writer writer) {
        this.validator = validator;
        this.taskCommandHandler = taskCommandHandler;
        this.writer = writer;
    }

    public void handle(RemoveDto removeDto) {
        if (this.validator.validate(removeDto)) {
            this.taskCommandHandler.deleteTask(removeDto.id());
        } else {
            this.writer.write("Error: Invalid arguments for the command remove");
        }
    }
}
