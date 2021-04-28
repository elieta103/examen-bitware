package com.elhg.bitware.spring.data.mongodb.service;

import com.elhg.bitware.spring.data.mongodb.dto.ClienteDTO;
import com.elhg.bitware.spring.data.mongodb.model.Cliente;

public interface ClienteService {

	  public ClienteDTO getAllClientes();
	  public ClienteDTO getClienteById(Integer id); 
	  public ClienteDTO createCliente(Cliente cliente);
	  public ClienteDTO updateCliente(Integer id, Cliente cliente);
	  public ClienteDTO deleteTutorial(Integer id);

}
