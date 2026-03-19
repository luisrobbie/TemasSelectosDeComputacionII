package com.tienda.online.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "TBL_SUBCATEGORIAS",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = {"NID_CATEGORIA", "CNOMBRE"})
       })
public class Subcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NID_SUBCATEGORIA")
    private Integer idSubcategoria;

    @Column(name = "NID_CATEGORIA")
    private Integer idCategoria;

    @Column(name = "CNOMBRE", length = 100, nullable = false)
    private String nombre;

    @Column(name = "BHABILITADO", nullable = false)
    private Boolean habilitado = true;

    @Column(name = "DFECHA_ALTA", nullable = false,
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaAlta;

    @Column(name = "DFECHA_BAJA")
    private LocalDateTime fechaBaja;

    // Getters y Setters
    public Integer getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(Integer idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDateTime fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
}