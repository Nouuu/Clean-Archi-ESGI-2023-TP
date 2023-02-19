package org.esgi.cleanarchi.domain.query;

import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.kernel.Logger;
import org.esgi.cleanarchi.kernel.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public class TaskQueryHandler {
    private final TaskRepository taskRepository;
    private final Logger logger;

    public TaskQueryHandler(TaskRepository taskRepository, Logger logger) {
        this.taskRepository = taskRepository;
        this.logger = logger;
    }

    public Task getTaskById(Integer id) {
        Optional<Task> task = taskRepository.get(id);
        if (task.isEmpty()) {
            String message = "Task with id " + id + " not found";
            logger.logError(message);
            throw new NotFoundException(message);
        }
        return task.get();
    }

    public List<Task> getAllTasksOrderByCreatedDate() {
        return taskRepository.getAllOrderByCreatedDate();
    }
}
