package org.esgi.cleanarchi.domain.command;

import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.infrastructure.InMemoryLogger;
import org.esgi.cleanarchi.infrastructure.InMemoryTaskRepository;
import org.esgi.cleanarchi.kernel.Logger;
import org.junit.Before;
import org.junit.Test;

public class TaskCommandHandlerTest {

    TaskRepository taskRepository;
    TaskCommandHandler taskCommandHandler;
    Logger logger = new InMemoryLogger();

    @Before
    public void setUp() {
        this.taskRepository = new InMemoryTaskRepository();
        this.taskCommandHandler = new TaskCommandHandler(taskRepository, logger);
    }

    @Test
    public void createTaskTest() {
        int idCreated = this.taskCommandHandler.createTask(
                new CreateTaskCommand("description", null)
        );

        assert idCreated == 4;
    }
}
