package cl.duoc.ms_taskflow.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateTaskDTO {

    @NotBlank(message = "La descripción es obligatorio")
    private String descripcion;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @NotBlank(message = "La prioridad es obligatorio")
    private String prioridad;

    @NotBlank(message = "El responsable es obligatorio")
    private String responsable;

}
