package cl.duoc.ms_taskflow.controller;

import cl.duoc.ms_taskflow.dto.CreateTaskDTO;
import cl.duoc.ms_taskflow.dto.UpdateTaskDTO;
import cl.duoc.ms_taskflow.model.Task;
import cl.duoc.ms_taskflow.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> listar() {
        return ResponseEntity.ok(taskService.listar());
    }

    @PostMapping
    public ResponseEntity<Task> crear(@Valid @RequestBody CreateTaskDTO task) {
        return ResponseEntity.ok(taskService.crear(task));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.obtener(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> actualizar(@PathVariable Long id, @Valid @RequestBody UpdateTaskDTO task) {
        return ResponseEntity.ok(taskService.actualizar(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        taskService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/prioridad/{prioridad}")
    public ResponseEntity<List<Task>> buscarPorPrioridad(@PathVariable String prioridad) {
        return ResponseEntity.ok(taskService.buscarPorPrioridad(prioridad));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Task>> buscarPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(taskService.buscarPorEstado(estado));
    }

    @GetMapping("/ordenar/estado")
    public ResponseEntity<List<Task>> obtenerOrdenadoPorEstado() {
        return ResponseEntity.ok(taskService.ordenarPorEstado());
    }
}
