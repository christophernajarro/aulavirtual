package com.example.proyecto.infrastructure.adapter;

import com.example.proyecto.domain.model.Curso;
import com.example.proyecto.domain.port.CursoRepositoryPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoJPARepository extends JpaRepository<Curso, Long>, CursoRepositoryPort {
    // Implementación por defecto y métodos personalizados
}