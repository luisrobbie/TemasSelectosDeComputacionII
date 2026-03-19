package com.tienda.online.models;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "TBL_PRODUCTOS",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = {"NID_SUBCATEGORIA", "CNOMBRE"})
       })
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NID_PRODUCTO")
    private Integer idProducto;

    @Column(name = "CNOMBRE", length = 200, nullable = false)
    private String nombre;

    @Column(name = "CDESCRIPCION", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "MPRECIO", precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "NID_SUBCATEGORIA", nullable = false)
    private Integer idSubcategoria;

    @Column(name = "BHABILITADO", nullable = false)
    private Boolean habilitado = true;

    @Column(name = "DFECHA_ALTA", nullable = false,
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaAlta;

    @Column(name = "DFECHA_BAJA")
    private LocalDateTime fechaBaja;

    // Getters y Setters

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal  getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal  precio) {
        this.precio = precio;
    }

    public Integer getSubcategoria() {
        return idSubcategoria;
    }

    public void setSubcategoria( Integer idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
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
