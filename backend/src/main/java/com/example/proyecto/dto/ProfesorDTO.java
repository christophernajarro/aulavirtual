package com.example.proyecto.dto;

import java.math.BigDecimal;

import com.example.proyecto.domain.model.Profesor;

public class ProfesorDTO {

    private Long idProfesor;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    private String especialidad;
    private String descripcion;
    private BigDecimal gananciasTotales;
    
    public ProfesorDTO(Profesor profesor) {
        this.idProfesor = profesor.getIdProfesor();
        this.nombre = profesor.getNombre();
        this.apellido = profesor.getApellido();
        this.email = profesor.getEmail();
        this.contraseña = profesor.getContraseña();
        this.especialidad = profesor.getEspecialidad();
        this.descripcion = profesor.getDescripcion();
        this.gananciasTotales = profesor.getGananciasTotales();
    }

    public ProfesorDTO() {
        // Empty constructor
    }

    public Long getIdProfesor() {
        return idProfesor;
    }
    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public BigDecimal getGananciasTotales() {
        return gananciasTotales;
    }

    public void setGananciasTotales(BigDecimal gananciasTotales) {
        this.gananciasTotales = gananciasTotales;
    }

    
}
