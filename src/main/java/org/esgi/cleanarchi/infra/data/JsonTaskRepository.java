package org.esgi.cleanarchi.infra.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.esgi.cleanarchi.infra.io.Reader;
import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.domain.TaskRepository;
import org.esgi.cleanarchi.infra.io.Writer;
import org.esgi.cleanarchi.infra.io.exception.InputOutputException;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JsonTaskRepository implements TaskRepository {

    Map<Integer, TaskEntity> tasks = new HashMap<>();

    private final Reader reader;
    private final Writer writer;

    private final Gson gson = new GsonBuilder().create();
    private Integer nextId;

    public JsonTaskRepository(Reader reader, Writer writer) throws IOException {
        this.reader = reader;
        this.writer = writer;
        load();
    }

    private void load() throws IOException {
        String json = reader.read();
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
    public List<Task> getAll() {
        return TaskEntityMapper.fromEntities(List.copyOf(tasks.values()));
    }

    @Override
    public List<Task> getAllOrderByCreatedDate() {
        return TaskEntityMapper.fromEntities(
                List.copyOf(tasks.values())
                        .stream()
                        .sorted(Comparator.comparing(TaskEntity::createdDate))
                        .toList()
        );
    }

    @Override
    public void delete(Integer id) {
        tasks.remove(id);
        save();
    }

    @Override
    public Integer nextId() {
        return nextId++;
    }
}
