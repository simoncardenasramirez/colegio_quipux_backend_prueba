package com.priv.co.colegio_quipux_.persistence.entity;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=120)
    private String nombre;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "estudiante_materia",
            joinColumns = @JoinColumn(name = "estudiante_id"),
            inverseJoinColumns = @JoinColumn(name = "materia_id")
    )
    private Set<Materia> materias = new LinkedHashSet<>();

    public Estudiante() {}

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Set<Materia> getMaterias() { return materias; }
    public void setMaterias(Set<Materia> materias) { this.materias = materias; }
}

