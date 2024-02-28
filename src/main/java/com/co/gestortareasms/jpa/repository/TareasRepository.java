package com.co.gestortareasms.jpa.repository;

import com.co.gestortareasms.jpa.entity.TareasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareasRepository extends JpaRepository<TareasEntity,String> {
}
