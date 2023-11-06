package com.example.proyecto.infrastructure.controller;

import com.example.proyecto.domain.model.Alumno;
import com.example.proyecto.dto.AlumnoDTO;
import com.example.proyecto.service.AlumnoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    @Autowired
    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> getAllAlumnos() {
        List<Alumno> alumnos = alumnoService.findAllAlumnos();
        List<AlumnoDTO> alumnosDTO = new ArrayList<>();
        for (Alumno alumno : alumnos) {
            AlumnoDTO dto = new AlumnoDTO();
            dto.setIdAlumno(alumno.getIdAlumno());
            dto.setNombre(alumno.getNombre());
            dto.setApellido(alumno.getApellido());
            dto.setEmail(alumno.getEmail());
            // Aquí asumimos que tienes un método para convertir la lista de Cursos en una lista de IDs de cursos o algo similar.
            // Por ejemplo, algo así como: dto.setCursosInscritosIds(alumno.getCursosInscritosIds());
            alumnosDTO.add(dto);
        }
        return new ResponseEntity<>(alumnosDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> getAlumnoById(@PathVariable Long id) {
        Optional<Alumno> optionalAlumno = alumnoService.findAlumnoById(id);
        if (optionalAlumno.isPresent()) {
            Alumno alumno = optionalAlumno.get();
            AlumnoDTO dto = new AlumnoDTO();
            dto.setIdAlumno(alumno.getIdAlumno());
            dto.setNombre(alumno.getNombre());
            dto.setApellido(alumno.getApellido());
            dto.setEmail(alumno.getEmail());
            // dto.setCursosInscritosIds(alumno.getCursosInscritosIds());
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AlumnoDTO> createAlumno(@RequestBody AlumnoDTO alumnoDTO) {
        Alumno alumno = new Alumno();
        // Asumiendo que tienes un constructor adecuado o métodos set para cada uno de los campos
        // o una manera de convertir un DTO a entidad.
        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setApellido(alumnoDTO.getApellido());
        alumno.setEmail(alumnoDTO.getEmail());
        // alumno.setCursosInscritos(alumnoDTO.getCursosInscritos());
        Alumno savedAlumno = alumnoService.saveAlumno(alumno);
        AlumnoDTO dto = new AlumnoDTO();
        dto.setIdAlumno(savedAlumno.getIdAlumno());
        dto.setNombre(savedAlumno.getNombre());
        dto.setApellido(savedAlumno.getApellido());
        dto.setEmail(savedAlumno.getEmail());
        // dto.setCursosInscritosIds(savedAlumno.getCursosInscritosIds());
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> updateAlumno(@PathVariable Long id, @RequestBody AlumnoDTO alumnoDTO) {
        Alumno alumno = alumnoService.findAlumnoById(id)
            .orElseThrow(() -> new RuntimeException("Alumno not found with id " + id));
        if (alumno != null) {
            alumno.setNombre(alumnoDTO.getNombre());
            alumno.setApellido(alumnoDTO.getApellido());
            alumno.setEmail(alumnoDTO.getEmail());
            // alumno.setCursosInscritos(alumnoDTO.getCursosInscritos());
            Alumno updatedAlumno = alumnoService.saveAlumno(alumno);
            AlumnoDTO dto = new AlumnoDTO();
            dto.setIdAlumno(updatedAlumno.getIdAlumno());
            dto.setNombre(updatedAlumno.getNombre());
            dto.setApellido(updatedAlumno.getApellido());
            dto.setEmail(updatedAlumno.getEmail());
            // dto.setCursosInscritosIds(updatedAlumno.getCursosInscritosIds());
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        alumnoService.deleteAlumno(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Otros endpoints según sea necesario
}
