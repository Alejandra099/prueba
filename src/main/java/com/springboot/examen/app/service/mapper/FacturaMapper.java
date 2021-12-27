package com.springboot.examen.app.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.examen.app.models.Cliente;
import com.springboot.examen.app.models.Factura;

public class FacturaMapper implements RowMapper<Factura> {

	@Override
	public Factura mapRow(ResultSet rs, int rowNum) throws SQLException {
		Factura factura = new Factura();
		factura.setId(rs.getLong("id"));
		factura.setDescription(rs.getString("description"));
		Cliente cliente = new Cliente();
		cliente.setId(rs.getLong("cliente_id"));
		factura.setCliente(cliente);
		return factura;
	}

}
