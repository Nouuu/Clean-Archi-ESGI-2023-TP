package org.esgi.cleanarchi.domain.query;

import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.kernel.Logger;
import org.esgi.cleanarchi.kernel.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public class TaskQueryHandler {
    private final TaskRepository taskRepository;

    public TaskQueryHandler(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasksOrderByCreatedDate() {
        return taskRepository.getAllOrderByCreatedDate();
    }
}
