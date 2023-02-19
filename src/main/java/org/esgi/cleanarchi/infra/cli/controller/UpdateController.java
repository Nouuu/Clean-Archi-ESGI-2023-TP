package org.esgi.cleanarchi.infra.cli.controller;

import org.esgi.cleanarchi.infra.cli.dto.UpdateDto;
import org.esgi.cleanarchi.infra.cli.dto.adapter.StateDtoAdapter;
import org.esgi.cleanarchi.infra.cli.validator.ArgValidator;
import org.esgi.cleanarchi.domain.command.TaskCommandHandler;
import org.esgi.cleanarchi.domain.command.UpdateTaskCommand;
import org.esgi.cleanarchi.infra.io.Writer;

public class UpdateController {
    private final ArgValidator validator;
    private final TaskCommandHandler taskCommandHandler;
    private final Writer writer;

    public UpdateController(ArgValidator<UpdateDto> validator, TaskCommandHandler taskCommandHandler, Writer writer) {
        this.taskCommandHandler = taskCommandHandler;
        this.validator = validator;
        this.writer = writer;
    }

    public Void handle(UpdateDto updateDto) {
        if (this.validator.validate(updateDto)) {
            this.taskCommandHandler.updateTask(
                    new UpdateTaskCommand(
                            updateDto.id(),
                            updateDto.content(),
                            updateDto.dueDate(),
                            StateDtoAdapter.fromStateDtoToTaskState(updateDto.state())
                    )
            );
        } else {
            this.writer.write("Error: Invalid arguments for the command update");
        }
        return null;
    }
}
