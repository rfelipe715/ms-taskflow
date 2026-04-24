package cl.duoc.ms_taskflow.service;

import cl.duoc.ms_taskflow.dto.CreateTaskDTO;
import cl.duoc.ms_taskflow.dto.UpdateTaskDTO;
import cl.duoc.ms_taskflow.model.Task;
import cl.duoc.ms_taskflow.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> listar() {
        return taskRepository.findAll();
    }

    public Task crear(CreateTaskDTO createTaskDTO) {
        Task task = new Task(
                createTaskDTO.getDescripcion(),
                createTaskDTO.getEstado(),
                createTaskDTO.getPrioridad(),
                createTaskDTO.getResponsable()
                );
        return taskRepository.save(task);
    }

    public Task obtener(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }

    /**
     * La tarea solo actualizará el contenido que llega en el Request
     * @param id
     * @param task
     * @return
     */
    public Task actualizar(Long id, UpdateTaskDTO task) {
        Task existente = obtener(id);

        if (task.getDescripcion() != null) {
            existente.setDescripcion(task.getDescripcion());
        }
        if (task.getEstado() != null) {
            existente.setEstado(task.getEstado());
        }
        if (task.getPrioridad() != null) {
            existente.setPrioridad(task.getPrioridad());
        }
        if (task.getResponsable() != null) {
            existente.setResponsable(task.getResponsable());
        }

        existente.setFechaModificado(LocalDateTime.now());

        return taskRepository.save(existente);
    }

    public void eliminar(Long id) {
        obtener(id);
        taskRepository.delete(id);
    }

    public List<Task> buscarPorPrioridad(String prioridad) {
        return taskRepository.findAll().stream().filter(t -> t.getPrioridad().equalsIgnoreCase(prioridad)).toList();
    }

    public List<Task> buscarPorEstado(String estado) {
        return taskRepository.findAll().stream().filter(t -> t.getEstado().equalsIgnoreCase(estado)).toList();
    }

    public List<Task> ordenarPorEstado() {
        return taskRepository.findAll().stream().sorted(Comparator.comparing(Task::getEstado)).toList();
    }
}
