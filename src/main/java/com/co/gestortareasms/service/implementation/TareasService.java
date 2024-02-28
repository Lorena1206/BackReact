package com.co.gestortareasms.service.implementation;

import com.co.gestortareasms.dto.AddTareasDto;
import com.co.gestortareasms.dto.UpdateTareasDto;
import com.co.gestortareasms.jpa.entity.TareasEntity;
import com.co.gestortareasms.jpa.repository.TareasRepository;
import com.co.gestortareasms.service.ITareasService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class TareasService implements ITareasService {

    public final TareasRepository repository;

    @Override
    public List<TareasEntity> getTareas() {
        return repository.findAll();
    }

    @Override
    public String addTareas(AddTareasDto tareasDto) {
        ModelMapper mapper = new ModelMapper();
        TareasEntity tareasEntity = mapper.map(tareasDto, TareasEntity.class);
        tareasEntity.setId(UUID.randomUUID().toString());
        TareasEntity tareasEntitySave = repository.save(tareasEntity);
        return tareasEntitySave.getId();
    }

    @Override
    public String updateTareas(UpdateTareasDto tareasDto) throws Exception {
        ModelMapper mapper = new ModelMapper();
        TareasEntity tareasEntity = repository.findById(tareasDto.getId())
                .orElseThrow(() -> new Exception("Tarea no encontrada"));
        mapper.map(tareasDto, tareasEntity);
        TareasEntity tareasEntityUpdate = repository.save(tareasEntity);
        return tareasEntityUpdate.getId();
    }

    @Override
    public void deleteTarea(String id) {
        repository.deleteById(id);
    }
}
