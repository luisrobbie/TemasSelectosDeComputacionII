package com.tienda.online.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.online.entities.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}