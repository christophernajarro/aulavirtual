package com.example.proyecto.infrastructure.controller;

import com.example.proyecto.domain.model.Curso;
import com.example.proyecto.domain.model.Profesor;
import com.example.proyecto.dto.CursoDTO;
import com.example.proyecto.service.CursoService;
import com.example.proyecto.service.ProfesorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;
    private final ProfesorService profesorService;

    @Autowired
    public CursoController(CursoService cursoService, ProfesorService profesorService) {
        this.cursoService = cursoService;
        this.profesorService = profesorService; // Y esta línea también
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> getAllCursos() {
        List<Curso> cursos = cursoService.findAllCursos();
        List<CursoDTO> cursosDTO = new ArrayList<>();
        for (Curso curso : cursos) {
            CursoDTO dto = new CursoDTO();
            dto.setIdCurso(curso.getIdCurso());
            dto.setNombreCurso(curso.getNombreCurso());
            dto.setDescripcionCurso(curso.getDescripcionCurso());
            dto.setIdProfesor(curso.getProfesor().getIdProfesor()); // Asumiendo que tienes un objeto Profesor dentro de Curso
            dto.setCosto(curso.getCosto());
            dto.setFechaInicio(curso.getFechaInicio());
            dto.setFechaFin(curso.getFechaFin());
            cursosDTO.add(dto);
        }
        return new ResponseEntity<>(cursosDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> getCursoById(@PathVariable Long id) {
        Optional<Curso> optionalCurso = cursoService.findCursoById(id);
        if (optionalCurso.isPresent()) {
            Curso curso = optionalCurso.get();
            CursoDTO dto = new CursoDTO();
            dto.setIdCurso(curso.getIdCurso());
            dto.setNombreCurso(curso.getNombreCurso());
            dto.setDescripcionCurso(curso.getDescripcionCurso());
            dto.setIdProfesor(curso.getProfesor().getIdProfesor()); // Asumiendo que Curso tiene una relación con Profesor
            dto.setCosto(curso.getCosto());
            dto.setFechaInicio(curso.getFechaInicio());
            dto.setFechaFin(curso.getFechaFin());
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CursoDTO> createCurso(@RequestBody CursoDTO cursoDTO) {
        Curso curso = new Curso(); // Asumiendo que tienes un constructor o métodos setter para cada uno de los campos
        curso.setNombreCurso(cursoDTO.getNombreCurso());
        curso.setDescripcionCurso(cursoDTO.getDescripcionCurso());
        Profesor profesor = new Profesor();
        profesor.setIdProfesor(cursoDTO.getIdProfesor());
        curso.setProfesor(profesor);
        curso.setCosto(cursoDTO.getCosto());
        curso.setFechaInicio(cursoDTO.getFechaInicio());
        curso.setFechaFin(cursoDTO.getFechaFin());
        Curso savedCurso = cursoService.saveCurso(curso);
        CursoDTO dto = new CursoDTO();
        dto.setIdCurso(savedCurso.getIdCurso());
        dto.setNombreCurso(savedCurso.getNombreCurso());
        dto.setDescripcionCurso(savedCurso.getDescripcionCurso());
        dto.setIdProfesor(savedCurso.getProfesor().getIdProfesor());
        dto.setCosto(savedCurso.getCosto());
        dto.setFechaInicio(savedCurso.getFechaInicio());
        dto.setFechaFin(savedCurso.getFechaFin());
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> updateCurso(@PathVariable Long id, @RequestBody CursoDTO cursoDTO) {
        Optional<Curso> cursoOptional = cursoService.findCursoById(id);
        if (cursoOptional.isPresent()) {
            Curso existingCurso = cursoOptional.get();
            existingCurso.setNombreCurso(cursoDTO.getNombreCurso());
            existingCurso.setDescripcionCurso(cursoDTO.getDescripcionCurso());
            // Asumiendo que tienes una manera de buscar el Profesor por ID antes de asignarlo.
            Profesor profesor = profesorService.findProfesorById(cursoDTO.getIdProfesor()).orElse(null);
            if (profesor != null) {
                existingCurso.setProfesor(profesor);
            }
            existingCurso.setCosto(cursoDTO.getCosto());
            existingCurso.setFechaInicio(cursoDTO.getFechaInicio());
            existingCurso.setFechaFin(cursoDTO.getFechaFin());
            Curso updatedCurso = cursoService.saveCurso(existingCurso);
            CursoDTO dto = new CursoDTO();
            dto.setIdCurso(updatedCurso.getIdCurso());
            dto.setNombreCurso(updatedCurso.getNombreCurso());
            dto.setDescripcionCurso(updatedCurso.getDescripcionCurso());
            dto.setIdProfesor(updatedCurso.getProfesor().getIdProfesor());
            dto.setCosto(updatedCurso.getCosto());
            dto.setFechaInicio(updatedCurso.getFechaInicio());
            dto.setFechaFin(updatedCurso.getFechaFin());
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        cursoService.deleteCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Otros endpoints según sea necesario
}
