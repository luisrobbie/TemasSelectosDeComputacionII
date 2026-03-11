package com.tienda.online.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.online.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{

}
