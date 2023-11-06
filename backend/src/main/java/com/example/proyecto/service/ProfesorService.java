package com.example.proyecto.service;

import com.example.proyecto.domain.model.Profesor;
import com.example.proyecto.domain.port.ProfesorRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProfesorService {

    private final ProfesorRepositoryPort profesorRepositoryPort;

    @Autowired
    public ProfesorService(ProfesorRepositoryPort profesorRepositoryPort) {
        this.profesorRepositoryPort = profesorRepositoryPort;
    }

    public List<Profesor> findAllProfesores() {
        return profesorRepositoryPort.findAll();
    }

    public Optional<Profesor> findProfesorById(Long id) {
        return profesorRepositoryPort.findById(id);
    }

    public Profesor saveProfesor(Profesor profesor) {
        return profesorRepositoryPort.save(profesor);
    }

    public void deleteProfesor(Long id) {
        profesorRepositoryPort.deleteById(id);
    }

    // Otros métodos específicos del negocio relacionados con los profesores
}
