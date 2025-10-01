package com.priv.co.colegio_quipux_.manager;

import com.priv.co.colegio_quipux_.persistence.entity.Estudiante;
import com.priv.co.colegio_quipux_.persistence.entity.Materia;
import com.priv.co.colegio_quipux_.persistence.repository.EstudianteRepository;
import com.priv.co.colegio_quipux_.persistence.repository.MateriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class EstudianteManager {

    private final EstudianteRepository estudianteRepository;
    private final MateriaRepository materiaRepository;

    public EstudianteManager(EstudianteRepository estudianteRepository,
                             MateriaRepository materiaRepository) {
        this.estudianteRepository = estudianteRepository;
        this.materiaRepository = materiaRepository;
    }

    @Transactional(readOnly = true)
    public Estudiante getById(Long id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado: " + id));
    }

    @Transactional
    public Estudiante crearEstudiante(String nombre, List<Long> materiaIds) {
        Estudiante e = new Estudiante();
        e.setNombre(nombre);

        if (materiaIds != null && !materiaIds.isEmpty()) {
            List<Materia> materias = materiaRepository.findAllById(materiaIds);
            if (materias.size() != materiaIds.size()) {
                throw new IllegalArgumentException("Alguna materia no existe (revisa IDs).");
            }
            e.setMaterias(new LinkedHashSet<>(materias));
        }

        return estudianteRepository.save(e);
    }

    @Transactional(readOnly = true)
    public Set<Materia> materiasDeEstudiante(Long estudianteId) {
        Estudiante e = getById(estudianteId);
        // Forzar inicialización si es LAZY
        e.getMaterias().size();
        return e.getMaterias();
    }

    @Transactional
    public Estudiante matricularMaterias(Long estudianteId, List<Long> materiaIds) {
        Estudiante e = getById(estudianteId);
        if (materiaIds == null || materiaIds.isEmpty()) {
            return e;
        }
        var materias = materiaRepository.findAllById(materiaIds);
        if (materias.size() != materiaIds.size()) {
            throw new IllegalArgumentException("Alguna materia no existe (revisa IDs).");
        }
        e.getMaterias().addAll(materias);
        return e;
    }

}

