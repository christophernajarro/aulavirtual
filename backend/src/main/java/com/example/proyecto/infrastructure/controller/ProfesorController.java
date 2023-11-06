package com.example.proyecto.infrastructure.controller;

import com.example.proyecto.domain.model.Profesor;
import com.example.proyecto.dto.ProfesorDTO;
import com.example.proyecto.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    @Autowired
    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping
    public ResponseEntity<List<ProfesorDTO>> getAllProfesores() {
        List<Profesor> profesores = profesorService.findAllProfesores();
        List<ProfesorDTO> profesoresDTO = new ArrayList<>();
        for (Profesor profesor : profesores) {
            ProfesorDTO dto = new ProfesorDTO();
            dto.setIdProfesor(profesor.getIdProfesor());
            dto.setNombre(profesor.getNombre());
            dto.setApellido(profesor.getApellido());
            dto.setEmail(profesor.getEmail());
            dto.setContraseña(profesor.getContraseña()); // Asegúrate de manejar la contraseña de forma segura
            dto.setEspecialidad(profesor.getEspecialidad());
            dto.setDescripcion(profesor.getDescripcion());
            dto.setGananciasTotales(profesor.getGananciasTotales());
            profesoresDTO.add(dto);
        }
        return new ResponseEntity<>(profesoresDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDTO> getProfesorById(@PathVariable Long id) {
        Optional<Profesor> profesorOptional = profesorService.findProfesorById(id);
        if (profesorOptional.isPresent()) {
            Profesor profesor = profesorOptional.get();
            ProfesorDTO dto = new ProfesorDTO();
            dto.setIdProfesor(profesor.getIdProfesor());
            dto.setNombre(profesor.getNombre());
            dto.setApellido(profesor.getApellido());
            dto.setEmail(profesor.getEmail());
            dto.setContraseña(profesor.getContraseña()); // Manejo seguro de la contraseña
            dto.setEspecialidad(profesor.getEspecialidad());
            dto.setDescripcion(profesor.getDescripcion());
            dto.setGananciasTotales(profesor.getGananciasTotales());
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ProfesorDTO> createProfesor(@RequestBody ProfesorDTO profesorDTO) {
        Profesor profesor = new Profesor();
        // Asumiendo que tienes un constructor o métodos setter para cada uno de los campos
        profesor.setNombre(profesorDTO.getNombre());
        profesor.setApellido(profesorDTO.getApellido());
        profesor.setEmail(profesorDTO.getEmail());
        profesor.setContraseña(profesorDTO.getContraseña()); // Asegúrate de encriptar esta contraseña
        profesor.setEspecialidad(profesorDTO.getEspecialidad());
        profesor.setDescripcion(profesorDTO.getDescripcion());
        // Omitir setGananciasTotales si es un valor que no debe ser establecido al crear
        Profesor savedProfesor = profesorService.saveProfesor(profesor);
        ProfesorDTO dto = new ProfesorDTO(savedProfesor);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorDTO> updateProfesor(@PathVariable Long id, @RequestBody ProfesorDTO profesorDTO) {
        Optional<Profesor> profesorOptional = profesorService.findProfesorById(id);
        if (profesorOptional.isPresent()) {
            Profesor existingProfesor = profesorOptional.get();
            existingProfesor.setNombre(profesorDTO.getNombre());
            existingProfesor.setApellido(profesorDTO.getApellido());
            existingProfesor.setEmail(profesorDTO.getEmail());
            // Asegúrate de encriptar la contraseña antes de guardarla
            existingProfesor.setContraseña(profesorDTO.getContraseña());
            existingProfesor.setEspecialidad(profesorDTO.getEspecialidad());
            existingProfesor.setDescripcion(profesorDTO.getDescripcion());
            // Asegúrate de que los tipos de datos de gananciasTotales sean consistentes
            existingProfesor.setGananciasTotales(profesorDTO.getGananciasTotales());
            Profesor updatedProfesor = profesorService.saveProfesor(existingProfesor);
            ProfesorDTO dto = new ProfesorDTO(updatedProfesor); // Asume que tienes un constructor que acepta un Profesor
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    }

