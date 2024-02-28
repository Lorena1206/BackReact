package com.co.gestortareasms.dto;

import lombok.Data;

@Data
public class MensajeOutDto {

    boolean isError;

    String descripcion;

    Object data;
}
