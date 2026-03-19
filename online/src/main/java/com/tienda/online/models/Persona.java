package com.tienda.online.models;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NID_PERSONA")
    private Integer idPersona;

    @Column(name="NID_DIRECCION", nullable = false)
    private Integer idDireccion;
    
    @Column(name="NID_GENERO", nullable = false)
    private Integer idGenero;

    @Column(name="CNOMBRE", nullable = false)
    private String nombre;
    
    @Column(name="CAPELLIDO_PATERNO", nullable = false)
    private String apellidoPaterno;
    
    @Column(name="CAPELLIDO_MATERNO")
    private String apellidoMaterno;
    
    @Column(name="CCORREO", nullable = false)
    private String correo;

    @Column(name="CTELEFONO", nullable = false)
    private String telefono;
    
    @Column(name="BHABILITADO", nullable = false)
    private Boolean habilitado=true;

    @Column(name="DFECHA_ALTA", nullable = false,
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaAlta;
    
    @Column(name="DFECHA_BAJA")
    private LocalDateTime fechaBaja;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return apellidoPaterno;
    }

    public void setPrimerApellido(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getSegundoApellido() {
        return apellidoMaterno;
    }

    public void setSegundoApellido(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo(String correo) {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono(String telefono) {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

