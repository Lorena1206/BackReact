package com.co.gestortareasms.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateTareasDto {

    public String id;

    @NotNull
    public String titulo;

    @NotNull
    public String descripcion;

    @NotNull
    public String estado;
}
