package com.clinic.clinic_psychology.controllers;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.clinic_psychology.dto.PacienteRequest;
import com.clinic.clinic_psychology.entities.Paciente;
import com.clinic.clinic_psychology.repositories.PacienteRepository;
import com.clinic.clinic_psychology.services.PacienteService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/pacientes")
public class PacienteController{
    
    private final PacienteService service;

    public PacienteController(PacienteService service, PacienteRepository pacienteRepository){
        this.service=service;
    }

    @GetMapping("/{id}")
    public Paciente patientForId(@PathVariable int id){
        return service.findById(id);
    }    

    @GetMapping
    public List<Paciente> showPatients() {
        return service.findAll();
    }

    @PostMapping
    public Paciente newPatient(@RequestBody PacienteRequest dto) {
        return service.newPatient(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePatient(@PathVariable int id, @RequestBody Paciente paciente) {
        Paciente actualizado= service.updatePatient(id, paciente);
        if (actualizado == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable int id) {
        boolean eliminado = service.deletePatient(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Paciente eliminado correctamente");
    }
}

