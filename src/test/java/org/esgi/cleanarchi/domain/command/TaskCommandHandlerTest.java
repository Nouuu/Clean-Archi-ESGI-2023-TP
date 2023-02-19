package org.esgi.cleanarchi.domain.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.infra.FakeLogger;
import org.esgi.cleanarchi.infra.MockReader;
import org.esgi.cleanarchi.infra.MockWriter;
import org.esgi.cleanarchi.infra.data.JsonTaskRepository;
import org.esgi.cleanarchi.infra.io.Writer;
import org.esgi.cleanarchi.kernel.Logger;
import org.esgi.cleanarchi.utils.ResourceUtils;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskCommandHandlerTest {

    TaskRepository taskRepository;
    TaskCommandHandler taskCommandHandler;

    Writer writer;
    MockReader reader;

    @BeforeEach
    public void setUp() {
        Logger logger = new FakeLogger();
        reader = new MockReader();
        writer = new MockWriter();
        String fixture = ResourceUtils.getContentStringFromResource("/taskFixture.json");
        reader.setNextContent(fixture);
        taskRepository = new JsonTaskRepository(reader, writer, logger);
        taskCommandHandler = new TaskCommandHandler(taskRepository, logger);
    }

    @Test
    void createTaskTest() {
        int idCreated = this.taskCommandHandler.createTask(
            new CreateTaskCommand("description", null, null)
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
