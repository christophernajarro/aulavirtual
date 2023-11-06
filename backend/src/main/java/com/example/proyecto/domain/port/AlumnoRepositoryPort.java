package com.example.proyecto.domain.port;

import com.example.proyecto.domain.model.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoRepositoryPort {
    List<Alumno> findAll();
    Optional<Alumno> findById(Long id);
    Alumno save(Alumno alumno);
    void deleteById(Long id);
    // Otros métodos que necesites, por ejemplo, encontrar alumnos por curso
}
