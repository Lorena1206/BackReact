package com.co.gestortareasms.jpa.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tareas")
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class TareasEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;

}