package com.priv.co.colegio_quipux_.rest.dto;

import java.util.List;

public class CreateEstudianteRequest {
    private String nombre;
    private List<Long> materiaIds;

    public CreateEstudianteRequest() {}

    public CreateEstudianteRequest(String nombre, List<Long> materiaIds) {
        this.nombre = nombre;
        this.materiaIds = materiaIds;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Long> getMateriaIds() { return materiaIds; }
    public void setMateriaIds(List<Long> materiaIds) { this.materiaIds = materiaIds; }
}

