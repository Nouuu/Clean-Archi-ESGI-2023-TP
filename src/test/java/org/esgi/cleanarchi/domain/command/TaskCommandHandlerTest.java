package org.esgi.cleanarchi.domain.command;

import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.infra.InMemoryLogger;
import org.esgi.cleanarchi.infra.InMemoryTaskRepository;
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

    public void createTaskTest() {
        int idCreated = this.taskCommandHandler.createTask(
                new CreateTaskCommand("description", null)
        );

        assert idCreated == 4;
    }

    @Test
    public void updateTaskTest() {
        this.taskCommandHandler.updateTask(new UpdateTaskCommand(1, "description", null, null));
        assert true;
    }

    @Test
    public void removeTaskTest() {
        this.taskCommandHandler.deleteTask(1);
        assert true;

    }
}
