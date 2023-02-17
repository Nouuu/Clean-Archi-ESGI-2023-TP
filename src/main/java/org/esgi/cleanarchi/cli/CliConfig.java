package org.esgi.cleanarchi.cli;

import java.util.List;
import org.esgi.cleanarchi.cli.controller.AddController;
import org.esgi.cleanarchi.cli.controller.ListController;
import org.esgi.cleanarchi.cli.controller.RemoveController;
import org.esgi.cleanarchi.cli.controller.UpdateController;
import org.esgi.cleanarchi.cli.dto.*;

public class CliConfig {
    private final AddController addController;
    private ListController listController;
    private UpdateController updateController;
    private RemoveController removeController;

    public CliConfig(AddController addController){
        this.addController = addController;

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
        }
    }
}
