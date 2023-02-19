package org.esgi.cleanarchi;

import org.esgi.cleanarchi.cli.CliConfig;
import org.esgi.cleanarchi.cli.controller.AddController;
import org.esgi.cleanarchi.cli.controller.ListController;
import org.esgi.cleanarchi.cli.controller.RemoveController;
import org.esgi.cleanarchi.cli.controller.UpdateController;
import org.esgi.cleanarchi.cli.helper.CliHelper;
import org.esgi.cleanarchi.cli.validator.AddControllerValidator;
import org.esgi.cleanarchi.cli.validator.RemoveControllerValidator;
import org.esgi.cleanarchi.cli.validator.UpdateControllerValidator;
import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.domain.command.TaskCommandHandler;
import org.esgi.cleanarchi.domain.query.TaskQueryHandler;
import org.esgi.cleanarchi.infra.data.JsonTaskRepository;
import org.esgi.cleanarchi.infra.io.ConsoleWriter;
import org.esgi.cleanarchi.infra.io.FileReader;
import org.esgi.cleanarchi.infra.io.FileWriter;
import org.esgi.cleanarchi.infra.io.Writer;
import org.esgi.cleanarchi.kernel.ConsoleLogger;
import org.esgi.cleanarchi.kernel.Logger;

import java.io.IOException;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws IOException {
        Logger logger = new ConsoleLogger();
        Writer writer = new FileWriter("data.json", logger);
        TaskRepository taskRepository = new JsonTaskRepository(new FileReader("data.json", logger), writer);
        TaskCommandHandler taskCommandHandler = new TaskCommandHandler(taskRepository, logger);
        TaskQueryHandler taskQueryHandler = new TaskQueryHandler(taskRepository, logger);


        AddController addController = new AddController(new AddControllerValidator(), taskCommandHandler);
        ListController listController = new ListController(taskQueryHandler, new ConsoleWriter());
        RemoveController removeController = new RemoveController(new RemoveControllerValidator(), taskCommandHandler);
        UpdateController updateController = new UpdateController(new UpdateControllerValidator(), taskCommandHandler);
        CliHelper cliHelper = new CliHelper(new ConsoleWriter());

        CliConfig cliConfig = new CliConfig(addController, listController, updateController, removeController, cliHelper);
        cliConfig.parseArg(Arrays.asList(args));
    }
}
