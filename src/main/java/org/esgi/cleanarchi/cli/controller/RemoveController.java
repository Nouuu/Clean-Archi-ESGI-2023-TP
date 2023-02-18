package org.esgi.cleanarchi.cli.controller;

import org.esgi.cleanarchi.cli.dto.RemoveDto;
import org.esgi.cleanarchi.cli.validator.ArgValidator;
import org.esgi.cleanarchi.domain.command.TaskCommandHandler;

public class RemoveController {
    private final ArgValidator validator;
    private final TaskCommandHandler taskCommandHandler;

    public RemoveController(ArgValidator<RemoveDto> validator, TaskCommandHandler taskCommandHandler){
        this.validator = validator;
        this.taskCommandHandler = taskCommandHandler;
    }
    public Void handle(RemoveDto removeDto) {
        if (this.validator.validate(removeDto)) {
            this.taskCommandHandler.deleteTask(removeDto.id());
        }
        return null;
    }
}
