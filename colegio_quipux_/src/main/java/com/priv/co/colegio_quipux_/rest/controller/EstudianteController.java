package com.priv.co.colegio_quipux_.rest.controller;

import com.priv.co.colegio_quipux_.manager.EstudianteManager;
import com.priv.co.colegio_quipux_.persistence.entity.Estudiante;
import com.priv.co.colegio_quipux_.persistence.entity.Materia;
import com.priv.co.colegio_quipux_.rest.dto.CreateEstudianteRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteManager estudianteManager;

    public EstudianteController(EstudianteManager estudianteManager) {
        this.estudianteManager = estudianteManager;
    }

    @GetMapping("/{id}")
    public Estudiante getById(@PathVariable Long id) {
        return estudianteManager.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estudiante crear(@RequestBody CreateEstudianteRequest req) {
        return estudianteManager.crearEstudiante(req.getNombre(), req.getMateriaIds());
    }

    @GetMapping("/{id}/materias")
    public Set<Materia> materias(@PathVariable Long id) {
        return estudianteManager.materiasDeEstudiante(id);
    }
    @PutMapping("/{id}/materias")
    public Estudiante matricular(@PathVariable Long id, @RequestBody java.util.List<Long> materiaIds) {
        return estudianteManager.matricularMaterias(id, materiaIds);
    }

}
