package org.esgi.cleanarchi.infra.cli;

import java.util.List;
import org.esgi.cleanarchi.infra.cli.controller.AddController;
import org.esgi.cleanarchi.infra.cli.controller.ListController;
import org.esgi.cleanarchi.infra.cli.controller.RemoveController;
import org.esgi.cleanarchi.infra.cli.controller.UpdateController;
import org.esgi.cleanarchi.infra.cli.dto.AddDto;
import org.esgi.cleanarchi.infra.cli.dto.parser.AddDtoParser;
import org.esgi.cleanarchi.infra.cli.dto.parser.RemoveDtoParser;
import org.esgi.cleanarchi.infra.cli.dto.parser.UpdateDtoParser;
import org.esgi.cleanarchi.infra.cli.helper.CliHelper;
import org.esgi.cleanarchi.infra.cli.dto.RemoveDto;
import org.esgi.cleanarchi.infra.cli.dto.UpdateDto;

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
        if (args.size() == 0) {
            cliHelper.printHelpMessage();
            return;
        }
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
            case ("help") -> {
                cliHelper.printHelpMessage();
                return;
            }
            default -> {
                cliHelper.printErrorCommandNotKnown();
                cliHelper.printHelpMessage();
                return;
            }
        }
    }
}