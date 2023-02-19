package org.esgi.cleanarchi.domain.command;

import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.domain.TaskState;
import org.esgi.cleanarchi.infra.FakeLogger;
import org.esgi.cleanarchi.infra.MockReader;
import org.esgi.cleanarchi.infra.MockWriter;
import org.esgi.cleanarchi.infra.data.JsonTaskRepository;
import org.esgi.cleanarchi.kernel.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskCommandHandlerTest {

    TaskRepository taskRepository;
    TaskCommandHandler taskCommandHandler;

    @BeforeEach
    public void setUp() throws IOException {
        Logger logger = new FakeLogger();
        this.taskRepository = new JsonTaskRepository(new MockReader(), new MockWriter());
        this.taskCommandHandler = new TaskCommandHandler(taskRepository, logger);
        injectFixture();
    }

    private void injectFixture() {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        List<Task> tasks = List.of(
                Task.of(1, "init a project to create an app for my tasks", ZonedDateTime.parse("2022-02-15T22:14:30.486798+01:00", formatter), Optional.ofNullable(ZonedDateTime.parse("2022-02-15T22:14:30.486798+01:00", formatter)), Optional.empty(), TaskState.TODO, null),
                Task.of(2, "make a design of my needs to manage my tasks", ZonedDateTime.parse("2022-02-13T22:14:30.536023+01:00", formatter), Optional.ofNullable(ZonedDateTime.parse("2022-02-16T21:14:30.536024+01:00", formatter)), Optional.empty(), TaskState.PROGRESS, null),
                Task.of(3, "brainstorm on what project to work on", ZonedDateTime.parse("2022-01-16T22:14:30.536143+01:00", formatter), Optional.ofNullable(ZonedDateTime.parse("2022-02-16T21:14:30.536024+01:00", formatter)), Optional.ofNullable(ZonedDateTime.parse("2022-02-11T22:14:30.536144+01:00", formatter)), TaskState.CLOSED, null)
        );

        tasks.forEach(task -> taskRepository.save(task));
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
