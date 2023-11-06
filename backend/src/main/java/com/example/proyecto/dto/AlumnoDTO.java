package com.example.proyecto.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import java.util.Set;

public class AlumnoDTO {

    private Long idAlumno;

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotEmpty(message = "El apellido no puede estar vacío")
    private String apellido;

    @NotEmpty(message = "El email no puede estar vacío")
    @Email(message = "Debe ser una dirección de correo electrónico válida")
    private String email;

    @Length(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String contraseña;

    private Set<Long> cursosInscritos; // Suponiendo que guardas solo los IDs de los cursos
    
    public Long getIdAlumno() {
        return idAlumno;
    }
    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
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
    public Set<Long> getCursosInscritos() {
        return cursosInscritos;
    }
    public void setCursosInscritos(Set<Long> cursosInscritos) {
        this.cursosInscritos = cursosInscritos;
    }

    
}
