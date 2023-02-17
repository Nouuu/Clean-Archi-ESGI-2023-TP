package org.esgi.cleanarchi.cli.controller;

import org.esgi.cleanarchi.cli.dto.UpdateDto;
import org.esgi.cleanarchi.cli.validator.ArgValidator;

public class UpdateController {
    private final ArgValidator validator;

    public UpdateController(ArgValidator validator) {
        this.validator = validator;
    }

    public Void handle(UpdateDto updateDto) {
        this.validator.validate(updateDto);
        return null;
    }
}
