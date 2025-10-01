package com.priv.co.colegio_quipux_.rest.controller;


import com.priv.co.colegio_quipux_.persistence.entity.Materia;
import com.priv.co.colegio_quipux_.persistence.repository.MateriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    private final MateriaRepository materiaRepository;

    public MateriaController(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Materia crear(@RequestBody Materia req) {
        Materia m = new Materia();
        m.setNombre(req.getNombre());
        return materiaRepository.save(m);
    }

    @GetMapping
    public List<Materia> listar() {
        return materiaRepository.findAll();
    }
}
