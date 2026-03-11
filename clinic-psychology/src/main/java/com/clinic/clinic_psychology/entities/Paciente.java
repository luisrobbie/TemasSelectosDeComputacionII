package com.clinic.clinic_psychology.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_personas")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NID_PERSONA")
    private Integer idPersona;

    @Column(name = "NID_GENERO")
    private Integer idGenero;

    @Column(name = "NID_DIRECCION")
    private Integer idDireccion;

    @Column(name = "CNOMBRE", length = 200)
    private String nombre;

    @Column(name = "CPRIMER_APELLIDO", length = 200)
    private String primerApellido;

    @Column(name = "CSEGUNDO_APELLIDO", length = 200)
    private String segundoApellido;

    @Column(name = "CNUMERO_TELEFONO", length = 15)
    private String numeroTelefono;

    @Column(name = "CNUMERO_TELEFONO_ALTERNATIVO", length = 15)
    private String numeroTelefonoAlternativo;

    @Column(name = "CCORREO_ELECTRONICO", length = 50)
    private String correoElectronico;

    @Column(name = "DFECHA_NACIMIENTO")
    private LocalDateTime fechaNacimiento;

    @Column(name = "BHABILITADO")
    private Boolean habilitado;

    @Column(name = "DFECHA_ALTA")
    private LocalDateTime fechaAlta;

    @Column(name = "DFECHA_BAJA")
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
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getNumeroTelefonoAlternativo() {
        return numeroTelefonoAlternativo;
    }

    public void setNumeroTelefonoAlternativo(String numeroTelefonoAlternativo) {
        this.numeroTelefonoAlternativo = numeroTelefonoAlternativo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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