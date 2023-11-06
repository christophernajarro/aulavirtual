package com.example.proyecto.domain.port;

import com.example.proyecto.domain.model.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorRepositoryPort {
    List<Profesor> findAll();
    Optional<Profesor> findById(Long id);
    Profesor save(Profesor profesor);
    void deleteById(Long id);
    Optional<Profesor> findByEmail(String email);
    // Otros métodos que necesites, por ejemplo, encontrar por especialidad
}
