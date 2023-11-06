package com.example.proyecto.domain.port;

import com.example.proyecto.domain.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoRepositoryPort {
    List<Curso> findAll();
    Optional<Curso> findById(Long id);
    Curso save(Curso curso);
    void deleteById(Long id);
    // Otros métodos que necesites, por ejemplo, encontrar cursos por profesor
}
