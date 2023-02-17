package org.esgi.cleanarchi.cli.controller;

import org.esgi.cleanarchi.cli.validator.ArgValidator;

public class AddController implements Controller<Void>{
    private final ArgValidator validator;

    public AddController(ArgValidator validator){
        this.validator = validator;
    }

    public Void handle(String[] args) {
        validator.validate(args);
        // do something zebi
        return null;
    }
}
