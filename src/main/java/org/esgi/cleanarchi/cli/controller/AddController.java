package org.esgi.cleanarchi.cli.controller;

import org.esgi.cleanarchi.cli.dto.AddDto;
import org.esgi.cleanarchi.cli.validator.ArgValidator;
import org.esgi.cleanarchi.domain.command.TaskCommandHandler;

public class AddController {
    private final ArgValidator<AddDto> validator;

    public AddController(ArgValidator<AddDto> validator) {
        this.validator = validator;
    }

    public void handle(AddDto dto) {
        if (validator.validate(dto)){
            //taskCommandHandler.createTask(new CreateTaskCommand(dto.content(), dto.dueDate()));
        }
    }
}
