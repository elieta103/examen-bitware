package com.elhg.bitware.spring.data.mongodb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elhg.bitware.spring.data.mongodb.dto.ClienteDTO;
import com.elhg.bitware.spring.data.mongodb.model.Cliente;
import com.elhg.bitware.spring.data.mongodb.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public ClienteDTO getAllClientes() {
		ClienteDTO clienteDTO = new ClienteDTO();
		try {
			List<Cliente> listClientes = new ArrayList<Cliente>();
			listClientes = clienteRepository.findAll();

			if (listClientes.isEmpty()) {
				clienteDTO.setCveError(0);
				clienteDTO.setCveMensaje("No se encontraron registros!");
				clienteDTO.setClientes(listClientes);
			} else {
				clienteDTO.setCveError(0);
				clienteDTO.setCveMensaje("Registros encontrados !");
				clienteDTO.setClientes(listClientes);
			}
		} catch (Exception e) {
			clienteDTO.setCveError(-1);
			clienteDTO.setCveMensaje("Error al obtener listados de cliente: " + e.getMessage());
			clienteDTO.setClientes(new ArrayList<Cliente>());
		}
		return clienteDTO;
	}

	@Override
	public ClienteDTO getClienteById(Integer id) {
		ClienteDTO clienteDTO = new ClienteDTO();
		try {
			Optional<Cliente> cliente = clienteRepository.findByClienteId(id);
			if (cliente.isPresent()) {
				clienteDTO.setCveError(0);
				clienteDTO.setCveMensaje("Registro encontrado !");
				List<Cliente> clientes = new ArrayList<Cliente>();
				clientes.add(cliente.get());
				clienteDTO.setClientes(clientes);
			} else {
				clienteDTO.setCveError(0);
				clienteDTO.setCveMensaje("No se encontraron registros!");
				clienteDTO.setClientes(new ArrayList<Cliente>());
			}
		} catch (Exception e) {
			clienteDTO.setCveError(-1);
			clienteDTO.setCveMensaje("Error al consultar cliente: " + e.getMessage());
			clienteDTO.setClientes(new ArrayList<Cliente>());
		}
		return clienteDTO;
	}

	@Override
	public ClienteDTO createCliente(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		try {

			Optional<Cliente> clienteCorreo = clienteRepository.findByCorreoElectronico(cliente.getCorreoElectronico());
			Optional<Cliente> clienteNomUser = clienteRepository.findByNombreUsuario(cliente.getNombreUsuario());

			if (!clienteCorreo.isPresent()) {
				if (!clienteNomUser.isPresent()) {
					Cliente _cliente = clienteRepository.save(cliente);
					List<Cliente> clientes = new ArrayList<Cliente>();
					clientes.add(_cliente);

					clienteDTO.setCveError(0);
					clienteDTO.setCveMensaje("Cliente guardado con exito !");
					clienteDTO.setClientes(clientes);

				} else {
					clienteDTO.setCveError(0);
					clienteDTO.setCveMensaje("Ya existe un cliente con ese nombre de usuario !");
					clienteDTO.setClientes(new ArrayList<Cliente>());
				}
			} else {
				clienteDTO.setCveError(0);
				clienteDTO.setCveMensaje("Ya existe un cliente con ese correo electrónico !");
				clienteDTO.setClientes(new ArrayList<Cliente>());
			}

		} catch (Exception e) {
			clienteDTO.setCveError(-1);
			clienteDTO.setCveMensaje("Error al guardar cliente: " + e.getMessage());
			clienteDTO.setClientes(new ArrayList<Cliente>());
		}
		return clienteDTO;
	}

	@Override
	public ClienteDTO updateCliente(Integer id, Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		List<Cliente> listClientes = new ArrayList<Cliente>();
		try {
			Optional<Cliente> clienteData = clienteRepository.findById(id);
			if (clienteData.isPresent()) {
				Cliente _cliente = clienteData.get();
				_cliente.setApellidos(cliente.getApellidos());
				_cliente.setContrasenia(cliente.getContrasenia());
				_cliente.setCorreoElectronico(cliente.getCorreoElectronico());
				_cliente.setEdad(cliente.getEdad());
				_cliente.setEstatura(cliente.getEstatura());
				_cliente.setEta(cliente.getEta());
				_cliente.setGeb(cliente.getGeb());
				_cliente.setImc(cliente.getImc());
				_cliente.setNombre(cliente.getNombre());
				_cliente.setNombreUsuario(cliente.getNombreUsuario());
				_cliente.setPeso(cliente.getPeso());
				_cliente.setFechaActualizacion(cliente.getFechaActualizacion());
				_cliente.setFechaCreacion(cliente.getFechaCreacion());

				clienteRepository.save(_cliente);

				clienteDTO.setCveError(0);
				clienteDTO.setCveMensaje("Registro para actualizado con éxito! ");
				listClientes.add(_cliente);
				clienteDTO.setClientes(listClientes);
			} else {
				clienteDTO.setCveError(0);
				clienteDTO.setCveMensaje("No se encontró registro para actualizar ! ");
				clienteDTO.setClientes(new ArrayList<Cliente>());
			}

		} catch (Exception e) {
			clienteDTO.setCveError(-1);
			clienteDTO.setCveMensaje("Error al actualizar cliente: " + e.getMessage());
			clienteDTO.setClientes(new ArrayList<Cliente>());
		}
		return clienteDTO;
	}

	@Override
	public ClienteDTO deleteTutorial(Integer id) {
		ClienteDTO clienteDTO = new ClienteDTO();

		try {
			Optional<Cliente> cliente = clienteRepository.findByClienteId(id);
			if (cliente.isPresent()) {
				clienteRepository.deleteById(id);
				clienteDTO.setCveError(0);
				clienteDTO.setCveMensaje("Registro eliminado con éxito ! ");
				clienteDTO.setClientes(new ArrayList<Cliente>());
			} else {
				clienteDTO.setCveError(0);
				clienteDTO.setCveMensaje("No existe el registro que desea eliminar ! ");
				clienteDTO.setClientes(new ArrayList<Cliente>());
			}
		} catch (Exception e) {
			clienteDTO.setCveError(-1);
			clienteDTO.setCveMensaje("Error al borrar cliente: " + e.getMessage());
			clienteDTO.setClientes(new ArrayList<Cliente>());
		}

		return clienteDTO;
	}

}
