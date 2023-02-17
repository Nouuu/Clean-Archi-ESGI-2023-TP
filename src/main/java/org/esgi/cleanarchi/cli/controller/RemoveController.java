package org.esgi.cleanarchi.cli.controller;

import org.esgi.cleanarchi.cli.validator.ArgValidator;

public class RemoveController implements Controller<Void>{
    private final ArgValidator validator;

    public RemoveController(ArgValidator validator){
        this.validator = validator;
    }
    public Void handle(String[] args) {
        this.validator.validate(args);
        return null;
    }
}
