package org.esgi.cleanarchi.cli;

import org.esgi.cleanarchi.cli.controller.AddController;
import org.esgi.cleanarchi.cli.controller.Controller;
import org.esgi.cleanarchi.cli.controller.ListController;
import org.esgi.cleanarchi.cli.controller.RemoveController;
import org.esgi.cleanarchi.cli.controller.UpdateController;
import org.esgi.cleanarchi.cli.validator.AddControllerValidator;
import org.esgi.cleanarchi.cli.validator.ListControllerValidator;
import org.esgi.cleanarchi.cli.validator.RemoveControllerValidator;
import org.esgi.cleanarchi.cli.validator.UpdateControllerValidator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CliConfig {
    private final AddController addController;
    private final ListController listController;
    private final UpdateController updateController;
    private final RemoveController removeController;

    public CliConfig(AddController addController,ListController listController,
                     UpdateController updateController, RemoveController removeController){
        this.addController = addController;
        this.listController = listController;
        this.updateController = updateController;
        this.removeController = removeController;

    }

    public void parseArg(String[] args){
        switch (args[0]) {
            case ("add"):

                addController.handle(obj);
                break;
            case ("list"):
                listController.handle();
                break;
            case ("update"):
                updateController.handle();
                break;
            case ("list"):
                removeController.handle();
                break;
        }
    }
}
