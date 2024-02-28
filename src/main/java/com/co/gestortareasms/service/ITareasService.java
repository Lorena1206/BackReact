package com.co.gestortareasms.service;

import com.co.gestortareasms.dto.AddTareasDto;
import com.co.gestortareasms.dto.UpdateTareasDto;
import com.co.gestortareasms.jpa.entity.TareasEntity;

import java.util.List;

public interface ITareasService {

    public List<TareasEntity> getTareas();

    public String addTareas(AddTareasDto tareasDto);

    public String updateTareas(UpdateTareasDto tareasDto) throws Exception;

    public void deleteTarea(String id);
}
