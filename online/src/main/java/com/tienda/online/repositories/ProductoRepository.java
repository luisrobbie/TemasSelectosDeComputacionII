package com.tienda.online.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.online.models.Producto;

public interface ProductoRepository extends JpaRepository< Producto, Integer>{

}
