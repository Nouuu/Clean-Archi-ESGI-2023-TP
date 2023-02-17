package org.esgi.cleanarchi.cli;

import java.util.List;
import org.esgi.cleanarchi.cli.controller.AddController;
import org.esgi.cleanarchi.cli.controller.ListController;
import org.esgi.cleanarchi.cli.controller.RemoveController;
import org.esgi.cleanarchi.cli.controller.UpdateController;
import org.esgi.cleanarchi.cli.dto.*;
import org.esgi.cleanarchi.cli.helper.CliHelper;

public class CliConfig {
    private final AddController addController;
    private final ListController listController;
    private final UpdateController updateController;
    private final RemoveController removeController;
    private final CliHelper cliHelper;

    public CliConfig(AddController addController, ListController listController,
                     UpdateController updateController, RemoveController removeController, CliHelper cliHelper) {
        this.addController = addController;
        this.listController = listController;
        this.updateController = updateController;
        this.removeController = removeController;
        this.cliHelper = cliHelper;
    }

    public void parseArg(List<String> args){
        switch (args.get(0)) {
            case ("add") -> {
                AddDto dto = new AddDtoParser().parse(args);
                addController.handle(dto);
            }
            case ("list") -> listController.handle();
            case ("update") -> {
                UpdateDto updateDto = new UpdateDtoParser().parse(args);
                updateController.handle(updateDto);
            }
            case ("remove") -> {
                RemoveDto removeDto = new RemoveDtoParser().parse(args);
                removeController.handle(removeDto);
            }
            default -> {
                cliHelper.printHelpMessage();
            }
        }
    }
}
