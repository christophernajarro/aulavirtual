package com.example.proyecto.infrastructure.adapter;

import com.example.proyecto.domain.model.Profesor;
import com.example.proyecto.domain.port.ProfesorRepositoryPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorJPARepository extends JpaRepository<Profesor, Long>, ProfesorRepositoryPort {
    // Implementación por defecto y métodos personalizados
}