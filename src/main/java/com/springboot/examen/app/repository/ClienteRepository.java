package com.springboot.examen.app.repository;

import java.util.List;

import com.springboot.examen.app.models.Cliente;

public interface ClienteRepository {

	public Cliente findById(Long id);
	public List<Cliente> findAll();
	public void save(Cliente cliente);
	public void delete(Long id);
	
}
