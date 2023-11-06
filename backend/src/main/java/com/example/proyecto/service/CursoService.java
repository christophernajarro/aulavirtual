package com.example.proyecto.service;

import com.example.proyecto.domain.model.Curso;
import com.example.proyecto.domain.port.CursoRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CursoService {

    private final CursoRepositoryPort cursoRepositoryPort;

    @Autowired
    public CursoService(CursoRepositoryPort cursoRepositoryPort) {
        this.cursoRepositoryPort = cursoRepositoryPort;
    }

    public List<Curso> findAllCursos() {
        return cursoRepositoryPort.findAll();
    }

    public Optional<Curso> findCursoById(Long id) {
        return cursoRepositoryPort.findById(id);
    }

    public Curso saveCurso(Curso curso) {
        return cursoRepositoryPort.save(curso);
    }

    public void deleteCurso(Long id) {
        cursoRepositoryPort.deleteById(id);
    }

    // Otros métodos específicos del negocio relacionados con los cursos
}
