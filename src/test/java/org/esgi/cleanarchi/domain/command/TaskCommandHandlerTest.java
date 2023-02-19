package org.esgi.cleanarchi.domain.command;

import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.domain.TaskState;
import org.esgi.cleanarchi.infra.FakeLogger;
import org.esgi.cleanarchi.infra.MockReader;
import org.esgi.cleanarchi.infra.MockWriter;
import org.esgi.cleanarchi.infra.data.JsonTaskRepository;
import org.esgi.cleanarchi.infra.io.Reader;
import org.esgi.cleanarchi.infra.io.Writer;
import org.esgi.cleanarchi.kernel.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskCommandHandlerTest {

    TaskRepository taskRepository;
    TaskCommandHandler taskCommandHandler;

    Writer writer;
    MockReader reader;

    @BeforeEach
    public void setUp() throws IOException {
        Logger logger = new FakeLogger();
        reader = new MockReader();
        writer = new MockWriter();
        String fixture = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("taskFixture.json")).toString();
        reader.setNextContent(fixture);
        taskRepository = new JsonTaskRepository(reader, writer, logger);
        taskCommandHandler = new TaskCommandHandler(taskRepository, logger);
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
