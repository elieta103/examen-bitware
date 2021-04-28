package com.elhg.bitware.spring.data.mongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.elhg.bitware.spring.data.mongodb.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, Integer> {
  Optional<Cliente> findByClienteId(Integer clienteId);
  Optional<Cliente> findByNombreUsuario(String nombreUsuario);
  Optional<Cliente> findByCorreoElectronico(String correo);
}
