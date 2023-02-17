package org.esgi.cleanarchi.infra.data;

import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.TaskState;

import java.util.List;
import java.util.Optional;

public class TaskEntityMapper {

    private TaskEntityMapper() {
    }
    static Task fromEntity(TaskEntity taskEntity) {
        return Task.of(
                taskEntity.id(),
                taskEntity.description(),
                taskEntity.createdDate(),
                Optional.ofNullable(taskEntity.dueDate()),
                Optional.ofNullable(taskEntity.closeDate()),
                TaskState.fromValue(taskEntity.taskState()),
                fromEntities(taskEntity.subTasks())
        );
    }

    static List<Task> fromEntities(List<TaskEntity> taskEntities) {
        if (taskEntities == null) {
            return List.of();
        }
        return taskEntities.stream()
                .map(TaskEntityMapper::fromEntity)
                .toList();
    }

    static TaskEntity toEntity(Task task) {
        return new TaskEntity(
                task.id(),
                task.description(),
                task.createdDate(),
                task.dueDate().orElse(null),
                task.closeDate().orElse(null),
                task.taskState().value(),
                toEntities(task.subTasks())
        );
    }

    static List<TaskEntity> toEntities(List<Task> tasks) {
        if (tasks == null) {
            return List.of();
        }
        return tasks.stream()
                .map(TaskEntityMapper::toEntity)
                .toList();
    }
}
