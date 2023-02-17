package org.esgi.cleanarchi.cli.controller;

import org.esgi.cleanarchi.cli.dto.AddDto;
import org.esgi.cleanarchi.cli.validator.ArgValidator;

public class AddController{
    private final ArgValidator validator;

    public AddController(ArgValidator validator){
        this.validator = validator;
    }

    public Void handle(AddDto dto) {
        validator.validate(dto);

        return null;
    }
}
