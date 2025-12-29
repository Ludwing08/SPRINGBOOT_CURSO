package com.example.practica01.models;

import com.example.practica01.utils.EstadoType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TODO")
public class TodoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This line is the fix
    private Long id;

    private String descripcion;

    private EstadoType estado;

    private Integer prioridad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoType getEstado() {
        return estado;
    }

    public void setEstado(EstadoType estado) {
        this.estado = estado;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
}
