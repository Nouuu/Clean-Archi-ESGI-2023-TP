package org.esgi.cleanarchi.domain.query;


import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.infra.InMemoryLogger;
import org.esgi.cleanarchi.infra.InMemoryTaskRepository;
import org.esgi.cleanarchi.kernel.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskQueryHandlerTest {
    TaskRepository taskRepository;
    TaskQueryHandler taskQueryHandler;
    Logger logger = new InMemoryLogger();

    @BeforeEach
    public void setUp() {
        this.taskRepository = new InMemoryTaskRepository();
        this.taskQueryHandler = new TaskQueryHandler(taskRepository, logger);
    }


    @Test
    void listAllTasksTestOrderedByCreationDateTest() {
        List<Task> tasks = this.taskQueryHandler.getAllTasksOrderByCreatedDate();

        assertEquals(3, tasks.size());
        assertEquals(3, tasks.get(0).id());
        assertEquals(2, tasks.get(1).id());
        assertEquals(1, tasks.get(2).id());
    }
}
