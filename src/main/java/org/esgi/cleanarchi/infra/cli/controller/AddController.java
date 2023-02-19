package org.esgi.cleanarchi.infra.cli.controller;

import org.esgi.cleanarchi.domain.command.CreateTaskCommand;
import org.esgi.cleanarchi.domain.command.TaskCommandHandler;
import org.esgi.cleanarchi.infra.cli.dto.AddDto;
import org.esgi.cleanarchi.infra.cli.validator.ArgValidator;
import org.esgi.cleanarchi.infra.io.Writer;

public class AddController {
    private final ArgValidator<AddDto> validator;
    private final TaskCommandHandler taskCommandHandler;
    private final Writer writer;

    public AddController(ArgValidator<AddDto> validator, TaskCommandHandler taskCommandHandler, Writer writer) {
        this.validator = validator;
        this.taskCommandHandler = taskCommandHandler;
        this.writer = writer;
    }

    public void handle(AddDto dto) {
        if (validator.validate(dto)) {
            this.taskCommandHandler.createTask(new CreateTaskCommand(dto.content(), dto.dueDate()));
        } else {
            this.writer.write("Error: Invalid arguments for the command add");
        }
    }
}
