package org.esgi.cleanarchi.domain.query;


import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.infra.InMemoryLogger;
import org.esgi.cleanarchi.infra.InMemoryTaskRepository;
import org.esgi.cleanarchi.kernel.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TaskQueryCommandHandlerTest {
    TaskRepository taskRepository;
    TaskQueryHandler taskQueryHandler;
    Logger logger = new InMemoryLogger();

    @Before
    public void setUp() {
        this.taskRepository = new InMemoryTaskRepository();
        this.taskQueryHandler = new TaskQueryHandler(taskRepository, logger);
    }


    @Test
    public void listAllTasksTestOrderedByCreationDateTest() {
        List<Task> tasks = this.taskQueryHandler.getAllTasksOrderByCreatedDate();

        assert tasks.size() == 3;
        assert tasks.get(0).id() == 3;
        assert tasks.get(1).id() == 2;
        assert tasks.get(2).id() == 1;
    }
}
