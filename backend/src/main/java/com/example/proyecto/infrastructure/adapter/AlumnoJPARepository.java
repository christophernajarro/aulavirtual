package com.example.proyecto.infrastructure.adapter;

import com.example.proyecto.domain.model.Alumno;
import com.example.proyecto.domain.port.AlumnoRepositoryPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoJPARepository extends JpaRepository<Alumno, Long>, AlumnoRepositoryPort {
    // La implementación de los métodos viene por defecto con JpaRepository
    // Puedes agregar métodos personalizados si es necesario
}