package org.esgi.cleanarchi.cli.controller;

import org.esgi.cleanarchi.cli.dto.RemoveDto;
import org.esgi.cleanarchi.cli.validator.ArgValidator;
import org.esgi.cleanarchi.domain.command.TaskCommandHandler;
import org.esgi.cleanarchi.infra.io.Writer;

public class RemoveController {
    private final ArgValidator validator;
    private final TaskCommandHandler taskCommandHandler;
    private final Writer writer;

    public RemoveController(ArgValidator<RemoveDto> validator, TaskCommandHandler taskCommandHandler, Writer writer){
        this.validator = validator;
        this.taskCommandHandler = taskCommandHandler;
        this.writer = writer;
    }
    public Void handle(RemoveDto removeDto) {
        if (this.validator.validate(removeDto)) {
            this.taskCommandHandler.deleteTask(removeDto.id());
        } else {
            this.writer.write("Error: Invalid arguments for the command remove");
        }
        return null;
    }
}
