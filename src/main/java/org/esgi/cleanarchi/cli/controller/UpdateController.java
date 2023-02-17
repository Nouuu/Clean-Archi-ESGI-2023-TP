package org.esgi.cleanarchi.cli.controller;

import org.esgi.cleanarchi.cli.dto.AddDto;
import org.esgi.cleanarchi.cli.dto.UpdateDto;
import org.esgi.cleanarchi.cli.dto.adapter.StateDtoAdapter;
import org.esgi.cleanarchi.cli.validator.ArgValidator;
import org.esgi.cleanarchi.domain.command.TaskCommandHandler;
import org.esgi.cleanarchi.domain.command.UpdateTaskCommand;

public class UpdateController {
    private final ArgValidator validator;

    private final TaskCommandHandler taskCommandHandler;

    public UpdateController(ArgValidator<UpdateDto> validator, TaskCommandHandler taskCommandHandler) {
        this.taskCommandHandler = taskCommandHandler;
        this.validator = validator;
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
        }
        return null;
    }
}
