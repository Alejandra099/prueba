package com.springboot.examen.app.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.examen.app.models.Factura;
import com.springboot.examen.app.repository.FacturaRepository;

@Repository
public class FacturaService implements FacturaRepository {
	
	JdbcTemplate jdbcTemplate;
	
	public FacturaService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Factura findById(Long id) {
		Object[] args = { id };

        return jdbcTemplate.queryForObject("select * from factura where id = ?", facturaMapper, args);
	}

	@Override
	public List<Factura> findAll() {
		
		return jdbcTemplate.query("select id, description from factura", facturaMapper);
	}

	@Override
	public void save(Factura factura) {
		
		if (factura.getId() != null) {
			jdbcTemplate.update("update factura set description = ?, cliente_id = ? where id = ?"
					,new Object[]{factura.getDescription(),factura.getCliente().getId(), factura.getId()} );
		} else {
			jdbcTemplate.update("insert into factura(description, cliente_id) values (?, ?)",
		               factura.getDescription(), factura.getCliente().getId());
		}
		
	}

	@Override
	public void delete(Long id) {
		Object[] args = { id };
		jdbcTemplate.update("delete from factura where id = ?", args);
		
	}

	private static RowMapper<Factura> facturaMapper = (rs, rowNum) ->
	
	    new Factura(
	        rs.getLong("id"),
	        rs.getString("description"));
}
