package org.esgi.cleanarchi.domain;

import org.esgi.cleanarchi.infra.io.exception.InputOutputException;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    void save(Task task) throws InputOutputException;

    Optional<Task> get(Integer id);

    List<Task> getAllOrderByCreatedDate();

    void delete(Integer id);

    Integer nextId();
}
