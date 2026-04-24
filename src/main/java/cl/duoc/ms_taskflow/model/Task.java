package cl.duoc.ms_taskflow.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
@ToString
public class Task {

    private Long id;

    private String descripcion;
    private String estado;
    private String prioridad;
    private String responsable;

    private LocalDateTime fechaCreado;
    private LocalDateTime fechaModificado;

    // Para manejo de id incremental
    private static Long globalId = 1L;


    public Task() {}

    public Task(String descripcion, String estado, String prioridad, String responsable) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.responsable = responsable;

        this.id = generateId();
        this.fechaCreado = LocalDateTime.now();
        this.fechaModificado = LocalDateTime.now();
    }


    private static Long generateId() {
        return globalId++;
    }
}
