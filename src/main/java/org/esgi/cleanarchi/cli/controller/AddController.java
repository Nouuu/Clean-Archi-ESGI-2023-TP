package org.esgi.cleanarchi.cli.controller;

import org.esgi.cleanarchi.cli.dto.AddDto;
import org.esgi.cleanarchi.cli.validator.ArgValidator;
import org.esgi.cleanarchi.domain.command.CreateTaskCommand;
import org.esgi.cleanarchi.domain.command.TaskCommandHandler;

public class AddController {
    private final ArgValidator<AddDto> validator;

    private final TaskCommandHandler taskCommandHandler;

    public AddController(ArgValidator<AddDto> validator, TaskCommandHandler taskCommandHandler) {
        this.validator = validator;
        this.taskCommandHandler = taskCommandHandler;
    }

    public void handle(AddDto dto) {
        if (validator.validate(dto)){
            this.taskCommandHandler.createTask(new CreateTaskCommand(dto.content(), dto.dueDate()));
        }
    }
}
