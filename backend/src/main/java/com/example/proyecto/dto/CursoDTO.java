package com.example.proyecto.dto;

import java.time.LocalDate;

public class CursoDTO {

    private Long idCurso;
    private String nombreCurso;
    private String descripcionCurso;
    private Long idProfesor; // Clave foránea que relaciona con Profesor
    private Double costo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    public Long getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }
    public String getNombreCurso() {
        return nombreCurso;
    }
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    public String getDescripcionCurso() {
        return descripcionCurso;
    }
    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
    }
    public Long getIdProfesor() {
        return idProfesor;
    }
    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }
    public Double getCosto() {
        return costo;
    }
    public void setCosto(Double costo) {
        this.costo = costo;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    
}
