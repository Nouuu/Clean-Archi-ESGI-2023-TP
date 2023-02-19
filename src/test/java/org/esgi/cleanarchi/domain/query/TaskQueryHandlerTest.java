package org.esgi.cleanarchi.domain.query;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.infra.FakeLogger;
import org.esgi.cleanarchi.infra.MockReader;
import org.esgi.cleanarchi.infra.MockWriter;
import org.esgi.cleanarchi.infra.data.JsonTaskRepository;
import org.esgi.cleanarchi.infra.io.Writer;
import org.esgi.cleanarchi.kernel.Logger;
import org.esgi.cleanarchi.utils.ResourceUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskQueryHandlerTest {
    TaskRepository taskRepository;
    TaskQueryHandler taskQueryHandler;
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
        this.taskQueryHandler = new TaskQueryHandler(taskRepository);
    }

    @Test
    void listAllTasksTestOrderedByCreationDateTest() {
        List<Task> tasks = this.taskQueryHandler.getAllTasksOrderByCreatedDate();

        assertEquals(3, tasks.size());
        assertEquals(1, tasks.get(0).id());
        assertEquals(3, tasks.get(1).id());
        assertEquals(2, tasks.get(2).id());
    }
}
