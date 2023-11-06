package com.example.proyecto.service;

import com.example.proyecto.domain.model.Alumno;
import com.example.proyecto.domain.port.AlumnoRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    private final AlumnoRepositoryPort alumnoRepositoryPort;

    @Autowired
    public AlumnoService(AlumnoRepositoryPort alumnoRepositoryPort) {
        this.alumnoRepositoryPort = alumnoRepositoryPort;
    }

    public List<Alumno> findAllAlumnos() {
        return alumnoRepositoryPort.findAll();
    }

    public Optional<Alumno> findAlumnoById(Long id) {
        return alumnoRepositoryPort.findById(id);
    }

    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepositoryPort.save(alumno);
    }

    public void deleteAlumno(Long id) {
        alumnoRepositoryPort.deleteById(id);
    }

    // Aquí puedes agregar métodos adicionales si es necesario
}
