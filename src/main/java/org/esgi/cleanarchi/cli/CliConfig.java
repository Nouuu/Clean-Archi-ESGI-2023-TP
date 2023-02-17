package org.esgi.cleanarchi.cli;

import java.util.List;
import org.esgi.cleanarchi.cli.controller.AddController;
import org.esgi.cleanarchi.cli.controller.ListController;
import org.esgi.cleanarchi.cli.controller.RemoveController;
import org.esgi.cleanarchi.cli.controller.UpdateController;
import org.esgi.cleanarchi.cli.dto.*;
import org.esgi.cleanarchi.cli.validator.ListControllerValidator;

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

    public void parseArg(List<String> args){
        switch (args.get(0)) {
            case ("add"):
                AddDto dto = new AddDtoParser().parse(args);
                addController.handle(dto);
                break;
            case ("list"):
                listController.handle();
                break;
            case ("update"):
                UpdateDto updateDto = new UpdateDtoParser().parse(args);
                updateController.handle(updateDto);
                break;
            case ("remove"):
                RemoveDto removeDto = new RemoveDtoParser().parse(args);
                removeController.handle(removeDto);
                break;
        }
    }
}
