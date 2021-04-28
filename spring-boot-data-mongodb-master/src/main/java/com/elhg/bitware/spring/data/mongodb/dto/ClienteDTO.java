package com.elhg.bitware.spring.data.mongodb.dto;

import java.util.List;

import com.elhg.bitware.spring.data.mongodb.model.Cliente;

public class ClienteDTO {
	private Integer cveError;
	private String cveMensaje;
	
	private List<Cliente> clientes;
	
	
	

	public ClienteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClienteDTO(Integer cveError, String cveMensaje, List<Cliente> clientes) {
		super();
		this.cveError = cveError;
		this.cveMensaje = cveMensaje;
		this.clientes = clientes;
	}

	public Integer getCveError() {
		return cveError;
	}

	public void setCveError(Integer cveError) {
		this.cveError = cveError;
	}

	public String getCveMensaje() {
		return cveMensaje;
	}

	public void setCveMensaje(String cveMensaje) {
		this.cveMensaje = cveMensaje;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	

	
}
