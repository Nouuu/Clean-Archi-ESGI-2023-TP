package org.esgi.cleanarchi.domain.command;

import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.infra.InMemoryLogger;
import org.esgi.cleanarchi.infra.InMemoryTaskRepository;
import org.esgi.cleanarchi.kernel.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskCommandHandlerTest {

    TaskRepository taskRepository;
    TaskCommandHandler taskCommandHandler;
    Logger logger = new InMemoryLogger();

    @BeforeEach
    public void setUp() {
        this.taskRepository = new InMemoryTaskRepository();
        this.taskCommandHandler = new TaskCommandHandler(taskRepository, logger);
    }

    @Test
    void createTaskTest() {
        int idCreated = this.taskCommandHandler.createTask(
                new CreateTaskCommand("description", null)
        );

        assertEquals(4, idCreated);
    }

    @Test
    void updateTaskTest() {
        assertDoesNotThrow(() -> this.taskCommandHandler.updateTask(new UpdateTaskCommand(1, "description", null, null)));
    }

    @Test
    void removeTaskTest() {
        assertDoesNotThrow(() -> this.taskCommandHandler.deleteTask(1));
    }
}
