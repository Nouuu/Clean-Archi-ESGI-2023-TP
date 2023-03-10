package org.esgi.cleanarchi.infra.data;

import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.TaskState;

import java.util.List;

public class TaskEntityMapper {

    private TaskEntityMapper() {
    }

    static Task fromEntity(TaskEntity taskEntity) {
        return Task.of(
                taskEntity.id(),
                taskEntity.parentId(),
                taskEntity.description(),
                taskEntity.createdDate(),
                taskEntity.dueDate(),
                taskEntity.closeDate(),
                TaskState.valueOf(taskEntity.taskState()),
                taskEntity.subTasks().stream().map(TaskEntityMapper::fromEntity).toList()
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
                task.parentId().orElse(null),
                task.description(),
                task.createdDate(),
                task.dueDate().orElse(null),
                task.closeDate().orElse(null),
                task.taskState().name(),
                List.of()
        );
    }

    static TaskEntity withSubTasks(TaskEntity taskEntity, List<TaskEntity> subTasks) {
        return new TaskEntity(
                taskEntity.id(),
                taskEntity.parentId(),
                taskEntity.description(),
                taskEntity.createdDate(),
                taskEntity.dueDate(),
                taskEntity.closeDate(),
                taskEntity.taskState(),
                subTasks
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
