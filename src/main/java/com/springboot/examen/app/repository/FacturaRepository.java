package com.springboot.examen.app.repository;

import java.util.List;

import com.springboot.examen.app.models.Factura;

public interface FacturaRepository {
	
	public Factura findById(Long id);
	public List<Factura> findAll();
	public void save(Factura factura);
	public void delete(Long id);

}
