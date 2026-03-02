package com.clinic.clinic_psychology.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.clinic.clinic_psychology.dto.PacienteRequest;
import com.clinic.clinic_psychology.entities.Paciente;
import com.clinic.clinic_psychology.repositories.PacienteRepository;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<Paciente> findAll() {
        return repository.findAll();
    }

    public Paciente findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Paciente newPatient(PacienteRequest dto) {
        Paciente p = new Paciente();
        p.setNombre(dto.getNombre());
        p.setPrimerApellido(dto.getPrimerApellido());
        p.setSegundoApellido(dto.getSegundoApellido());
        p.setNumeroTelefono(dto.getNumeroTelefono());
        p.setCorreoElectronico(dto.getCorreoElectronico());
        p.setFechaNacimiento(LocalDateTime.now());
        p.setHabilitado(true);
        p.setFechaAlta(LocalDateTime.now());
        return repository.save(p);
    }

    public Paciente updatePatient(int id, Paciente datos){
        Paciente existente = repository.findById(id).orElse(null);
        if (existente == null){
            return null;
        }

        existente.setNombre(datos.getNombre());
        existente.setPrimerApellido(datos.getPrimerApellido());
        existente.setSegundoApellido(datos.getSegundoApellido());
        existente.setCorreoElectronico(datos.getCorreoElectronico());
        existente.setNumeroTelefono(datos.getNumeroTelefono());

        return repository.save(existente);
    }

    public boolean deletePatient(int id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}