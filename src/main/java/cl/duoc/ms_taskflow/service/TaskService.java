package cl.duoc.ms_taskflow.service;

import cl.duoc.ms_taskflow.model.Task;
import cl.duoc.ms_taskflow.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> listar() {
        return taskRepository.findAll();
    }

    public Task crear(Task task) {
        return taskRepository.save(task);
    }

    public Task obtener(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }

    public Task actializar(Long id, Task task) {
        Task existente = obtener(id);

        existente.setDescripcion(task.getDescripcion());
        existente.setEstado(task.getEstado());
        existente.setPrioridad(task.getPrioridad());
        existente.setResponsable(task.getResponsable());
        existente.setFechaInicio(task.getFechaInicio());
        existente.setFechaFin(task.getFechaFin());

        return taskRepository.save(existente);
    }

    public void eliminar(Long id) {
        obtener(id);
        taskRepository.delete(id);
    }

    //TODO: agregar métodos de filtro
}
