package org.esgi.cleanarchi.infra.cli;

import org.esgi.cleanarchi.infra.cli.controller.AddController;
import org.esgi.cleanarchi.infra.cli.controller.ListController;
import org.esgi.cleanarchi.infra.cli.controller.RemoveController;
import org.esgi.cleanarchi.infra.cli.controller.UpdateController;
import org.esgi.cleanarchi.infra.cli.dto.AddDto;
import org.esgi.cleanarchi.infra.cli.dto.RemoveDto;
import org.esgi.cleanarchi.infra.cli.dto.UpdateDto;
import org.esgi.cleanarchi.infra.cli.dto.parser.AddDtoParser;
import org.esgi.cleanarchi.infra.cli.dto.parser.RemoveDtoParser;
import org.esgi.cleanarchi.infra.cli.dto.parser.UpdateDtoParser;
import org.esgi.cleanarchi.infra.cli.helper.CliHelper;

import java.util.List;

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

    public void parseArg(List<String> args) {
        if (args.size() == 0) {
            cliHelper.printHelpMessage();
            return;
        }
        List<String> dtoArgs = args.stream().skip(1).toList();
        switch (args.get(0)) {
            case ("add") -> {
                AddDto dto = new AddDtoParser().parse(dtoArgs);
                addController.handle(dto);
            }
            case ("list") -> listController.handle();
            case ("update") -> {
                UpdateDto updateDto = new UpdateDtoParser().parse(dtoArgs);
                updateController.handle(updateDto);
            }
            case ("remove") -> {
                RemoveDto removeDto = new RemoveDtoParser().parse(dtoArgs);
                removeController.handle(removeDto);
            }
            case ("help") -> {
                cliHelper.printHelpMessage();
            }
            default -> {
                cliHelper.printErrorCommandNotKnown();
                cliHelper.printHelpMessage();
            }
        }
    }
}
