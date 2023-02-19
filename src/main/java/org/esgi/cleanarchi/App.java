package org.esgi.cleanarchi;

import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.domain.TaskState;
import org.esgi.cleanarchi.domain.command.TaskCommandHandler;
import org.esgi.cleanarchi.domain.query.TaskQueryHandler;
import org.esgi.cleanarchi.infra.DefaultLogger;
import org.esgi.cleanarchi.infra.cli.CliConfig;
import org.esgi.cleanarchi.infra.cli.controller.AddController;
import org.esgi.cleanarchi.infra.cli.controller.ListController;
import org.esgi.cleanarchi.infra.cli.controller.RemoveController;
import org.esgi.cleanarchi.infra.cli.controller.UpdateController;
import org.esgi.cleanarchi.infra.cli.helper.CliHelper;
import org.esgi.cleanarchi.infra.cli.helper.OverdueTaskPredicate;
import org.esgi.cleanarchi.infra.cli.validator.AddControllerValidator;
import org.esgi.cleanarchi.infra.cli.validator.RemoveControllerValidator;
import org.esgi.cleanarchi.infra.cli.validator.UpdateControllerValidator;
import org.esgi.cleanarchi.infra.data.JsonTaskRepository;
import org.esgi.cleanarchi.infra.io.ConsoleErrorWriter;
import org.esgi.cleanarchi.infra.io.ConsoleWriter;
import org.esgi.cleanarchi.infra.io.FileReader;
import org.esgi.cleanarchi.infra.io.FileWriter;
import org.esgi.cleanarchi.infra.io.Writer;
import org.esgi.cleanarchi.kernel.Logger;
import org.esgi.cleanarchi.kernel.PropertiesLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws IOException {
        Properties config = PropertiesLoader.loadProperties();
        String applicationFolder = config.getProperty("application.folder");
        String userHome = System.getProperty("user.home");
        Files.createDirectories(Paths.get(userHome, applicationFolder));

        String datafilePath = Paths.get(userHome, applicationFolder, config.getProperty("application.datafile")).toString();
        String logFilePath = Paths.get(userHome, applicationFolder, config.getProperty("application.logfile")).toString();

        Writer consoleWriter = new ConsoleWriter();
        Writer consoleErrorWriter = new ConsoleErrorWriter();

        Logger consoleLogger = new DefaultLogger(consoleWriter, consoleErrorWriter);
        Writer loggerWriterDestFile = new FileWriter(logFilePath, consoleLogger, true);
        Logger fileLogger = new DefaultLogger(loggerWriterDestFile);
        Writer dataWriter = new FileWriter(datafilePath, fileLogger);


        TaskRepository taskRepository = new JsonTaskRepository(new FileReader(datafilePath, fileLogger), dataWriter, fileLogger);
        TaskCommandHandler taskCommandHandler = new TaskCommandHandler(taskRepository, fileLogger);
        TaskQueryHandler taskQueryHandler = new TaskQueryHandler(taskRepository, fileLogger);

        CliHelper cliHelper = new CliHelper(new ConsoleWriter());

        AddController addController = new AddController(new AddControllerValidator(), taskCommandHandler, consoleWriter);
        UpdateController updateController = new UpdateController(new UpdateControllerValidator(), taskCommandHandler, consoleWriter);
        RemoveController removeController = new RemoveController(new RemoveControllerValidator(), taskCommandHandler, consoleWriter);
        OverdueTaskPredicate overdueTaskPredicate = new OverdueTaskPredicate();
        ListController listController = new ListController(taskQueryHandler, cliHelper, overdueTaskPredicate);

        CliConfig cliConfig = new CliConfig(addController, listController, updateController, removeController, cliHelper);
        cliConfig.parseArg(Arrays.asList(args));
    }
}
