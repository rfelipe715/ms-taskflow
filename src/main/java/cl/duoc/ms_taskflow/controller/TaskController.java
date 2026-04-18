package cl.duoc.ms_taskflow.controller;

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
    public ResponseEntity<Task> crear(@Valid @RequestBody Task task) {
        return ResponseEntity.ok(taskService.crear(task));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.obtener(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> actualizar(@PathVariable Long id, @Valid @RequestBody Task task) {
        return ResponseEntity.ok(taskService.actializar(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        taskService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    //TODO: Agregar métodos de filtro
}
