package cl.duoc.ms_taskflow.repository;

import cl.duoc.ms_taskflow.model.Task;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class TaskRepository {

    private Map<Long, Task> data = new HashMap<>();

    public List<Task> findAll() {
        return new ArrayList<>(data.values());
    }

    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(data.get(id));
    }

    public Task save(Task task) {
        // Se agregan fechas actuales
        task.setFechaCreado(LocalDateTime.now());
        task.setFechaCreado(LocalDateTime.now());

        data.put(task.getId(), task);
        return task;
    }

    public void delete(Long id) {
        data.remove(id);
    }

}
