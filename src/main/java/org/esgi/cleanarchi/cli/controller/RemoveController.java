package org.esgi.cleanarchi.cli.controller;

import org.esgi.cleanarchi.cli.dto.RemoveDto;
import org.esgi.cleanarchi.cli.validator.ArgValidator;

public class RemoveController{
    private final ArgValidator validator;

    public RemoveController(ArgValidator validator){
        this.validator = validator;
    }
    public Void handle(RemoveDto removeDto) {
        this.validator.validate(removeDto);
        return null;
    }
}
