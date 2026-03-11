package com.clinic.clinic_psychology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clinic.clinic_psychology.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}