package cl.duoc.ms_taskflow.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Task {

    private Long id;

    @NotBlank(message = "La descripción es obligatorio")
    private String descripcion;

    @NotBlank(message = "La descripción es obligatorio")
    private String estado;

    @NotBlank(message = "La descripción es obligatorio")
    private String prioridad;

    @NotBlank(message = "La descripción es obligatorio")
    private String responsable;

    @NotBlank(message = "La descripción es obligatorio")
    private LocalDateTime fechaInicio;

    @NotBlank(message = "La descripción es obligatorio")
    private LocalDateTime fechaFin;

}
