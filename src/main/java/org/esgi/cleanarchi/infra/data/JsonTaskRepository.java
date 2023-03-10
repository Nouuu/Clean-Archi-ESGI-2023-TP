package org.esgi.cleanarchi.infra.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.infra.io.Reader;
import org.esgi.cleanarchi.infra.io.Writer;
import org.esgi.cleanarchi.infra.io.exception.InputOutputException;
import org.esgi.cleanarchi.kernel.Logger;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class JsonTaskRepository implements TaskRepository {

    Map<Integer, TaskEntity> tasks = new HashMap<>();

    private final Reader reader;
    private final Writer writer;

    private final Logger logger;

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(ZonedDateTime.class, new ZoneDateTimeTypeAdapter())
            .create();
    private Integer nextId;

    public JsonTaskRepository(Reader reader, Writer writer, Logger logger) throws InputOutputException {
        this.reader = reader;
        this.writer = writer;
        this.logger = logger;
        load();
    }

    private void load() throws InputOutputException {
        String json;
        try {
            json = reader.read();
        } catch (InputOutputException e) {
            logger.logError("Seems like the file don't exist yet, init empty db in memory");
            json = "[]";
        }
        TaskEntity[] taskEntities = gson.fromJson(json, TaskEntity[].class);
        for (TaskEntity taskEntity : taskEntities) {
            tasks.put(taskEntity.id(), taskEntity);
        }
        nextId = tasks.keySet().stream().max(Integer::compareTo).orElse(0) + 1;
    }

    private void save() throws InputOutputException {
        String json = gson.toJson(tasks.values());
        writer.write(json);
    }

    @Override
    public void save(Task task) throws InputOutputException {
        tasks.put(task.id(), TaskEntityMapper.toEntity(task));
        save();
    }

    @Override
    public Optional<Task> get(Integer id) {
        return Optional.ofNullable(tasks.get(id))
                .map(TaskEntityMapper::fromEntity);
    }

    @Override
    public List<Task> getAllOrderByCreatedDate() {
        return TaskEntityMapper.fromEntities(
                List.copyOf(
                                tasks.values()
                                        .stream()
                                        .filter(taskEntity -> taskEntity.parentId() == null)
                                        .map(taskEntity -> TaskEntityMapper
                                                .withSubTasks(taskEntity, fromParentId(taskEntity.id()))
                                        )
                                        .toList()
                        )
                        .stream()
                        .sorted(Comparator.comparing(TaskEntity::createdDate))
                        .toList()
        );
    }

    private List<TaskEntity> fromParentId(Integer parentId) {
        if (parentId == null) {
            return List.of();
        }
        return List.copyOf(tasks.values())
                .stream()
                .filter(taskEntity -> Objects.equals(parentId, taskEntity.parentId()))
                .map(taskEntity -> TaskEntityMapper
                        .withSubTasks(taskEntity, fromParentId(taskEntity.id()))
                )
                .toList();
    }

    @Override
    public void delete(Integer id) {
        fromParentId(id)
                .stream()
                .map(TaskEntity::id)
                .forEach(this::delete);
        tasks.remove(id);
        save();
    }

    @Override
    public Integer nextId() {
        return nextId++;
    }
}
