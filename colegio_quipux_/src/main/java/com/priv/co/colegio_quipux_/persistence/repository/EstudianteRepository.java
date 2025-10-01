package com.priv.co.colegio_quipux_.persistence.repository;

import com.priv.co.colegio_quipux_.persistence.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}

