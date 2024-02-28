package com.co.gestortareasms.controller;


import com.co.gestortareasms.dto.AddTareasDto;
import com.co.gestortareasms.dto.MensajeOutDto;
import com.co.gestortareasms.dto.UpdateTareasDto;
import com.co.gestortareasms.jpa.entity.TareasEntity;
import com.co.gestortareasms.service.ITareasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("tareas")
@Slf4j
@AllArgsConstructor
public class TareasController {

    private final ITareasService tareasService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Operation(description = "Servicio que retorna el listado de tareas.")
    public ResponseEntity<MensajeOutDto> getTareas() {
        MensajeOutDto mensaje = new MensajeOutDto();
        mensaje.setError(false);
        mensaje.setDescripcion("Informacion obtenida correctamente");
        mensaje.setData(tareasService.getTareas());
        return new ResponseEntity<>(mensaje, HttpStatus.OK);

    }

    @PostMapping
    @ResponseBody
    @Operation(description = "Servicio permite la creacion de tareas.")
    public ResponseEntity<MensajeOutDto> addTareas(
            @Parameter(
                    name = "AddTareasDto",
                    required = true)
            @RequestBody AddTareasDto tareasDto) {
        MensajeOutDto mensaje = new MensajeOutDto();
        mensaje.setError(false);
        mensaje.setDescripcion("Tarea creada correctamente");
        mensaje.setData(tareasService.addTareas(tareasDto));
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PutMapping
    @ResponseBody
    @Operation(description = "Servicio que permite la edicion de tareas.")
    public ResponseEntity<MensajeOutDto> updateTareas(
            @Parameter(
                    name = "tareasDto",
                    example = "[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]",
                    required = true)
            @RequestBody
            UpdateTareasDto tareasDto) throws Exception {
        MensajeOutDto mensaje = new MensajeOutDto();
        mensaje.setError(false);
        mensaje.setDescripcion("Tarea actualizada correctamente");
        mensaje.setData(tareasService.updateTareas(tareasDto));
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @Operation(description = "Servicio que permite la eliminacion de tareas.")
    public ResponseEntity<MensajeOutDto> deleteTareas(@PathVariable("id")String id) {
        tareasService.deleteTarea(id);
        MensajeOutDto mensaje = new MensajeOutDto();
        mensaje.setError(false);
        mensaje.setDescripcion("Tarea actualizada correctamente");
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
}