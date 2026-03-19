package com.tienda.online.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tienda.online.models.Imagen;

public interface ImagenRepository extends MongoRepository<Imagen,String>{
}
