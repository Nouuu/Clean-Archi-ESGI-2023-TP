package org.esgi.cleanarchi.domain.command;

import java.util.ArrayList;
import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.domain.TaskState;
import org.esgi.cleanarchi.kernel.Logger;
import org.esgi.cleanarchi.kernel.exception.NotFoundException;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Optional;

public class TaskCommandHandler {

    private final TaskRepository taskRepository;
    private final Logger logger;

    public TaskCommandHandler(TaskRepository taskRepository, Logger logger) {
        this.taskRepository = taskRepository;
        this.logger = logger;
    }

    public Integer createTask(CreateTaskCommand command) {
        Integer id = taskRepository.nextId();
        Task task = Task.of(
                id,
                command.description(),
                null,
                Optional.ofNullable(command.dueDate()),
                Optional.empty(),
                TaskState.TODO,
                new ArrayList<>()
        );
        taskRepository.save(task);
        logger.log("[Create task] Task \"" + task.description() + "\" created with id " + id);
        return id;
    }

    public void updateTask(UpdateTaskCommand command) {
        Optional<Task> optionalTask = taskRepository.get(command.id());
        if (optionalTask.isEmpty()) {
            String message = "[Update task] Task with id " + command.id() + " does not exist";
            logger.logError(message);
            throw new NotFoundException(message);
        }
        Task task = optionalTask.get();
        Task updatedTask = Task.of(
                task.id(),
                task.description(),
                task.createdDate(),
                command.dueDate() == null ? task.dueDate() : Optional.of(command.dueDate()),
                getOptionalZonedDateTime(command, task),
                getTaskState(command, task),
                task.subTasks()
        );
        taskRepository.save(updatedTask);
        logger.log("[Update task] Task \"" + updatedTask.description() + "\" updated");
    }

    private Optional<ZonedDateTime> getOptionalZonedDateTime(UpdateTaskCommand command, Task task) {
        if (Objects.equals(command.taskState(), TaskState.CLOSED) && task.closeDate().isEmpty()) {
            return Optional.of(ZonedDateTime.now());
        }
        return task.closeDate();
    }

    private TaskState getTaskState(UpdateTaskCommand command, Task task) {
        if (command.taskState() != null && !Objects.equals(task.taskState(), TaskState.CLOSED)) {
            return command.taskState();
        }
        return task.taskState();
    }

    public void deleteTask(Integer id) {
        Optional<Task> optionalTask = taskRepository.get(id);
        if (optionalTask.isEmpty()) {
            String message = "[Delete task] Task with id " + id + " does not exist";
            logger.logError(message);
            throw new NotFoundException(message);
        }
        taskRepository.delete(id);
        logger.log("[Delete task] Task with id " + id + " deleted");
    }

}
