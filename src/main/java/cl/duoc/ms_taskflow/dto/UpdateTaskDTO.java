package cl.duoc.ms_taskflow.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateTaskDTO {

    private String descripcion;

    private String estado;

    private String prioridad;

    private String responsable;

}
