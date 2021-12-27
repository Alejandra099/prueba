package com.springboot.examen.app.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.examen.app.models.Cliente;
import com.springboot.examen.app.repository.ClienteRepository;

@Repository
public class ClienteService implements ClienteRepository {

	private JdbcTemplate jdbcTemplate;
	
	public ClienteService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Cliente findById(Long id) {
		Object[] args = { id };

        return jdbcTemplate.queryForObject("select * from cliente where id = ?", clienteMapper, args);
	}

	@Override
	public List<Cliente> findAll() {
		return jdbcTemplate.query("select id, name from cliente", clienteMapper);
	}

	@Override
	public void save(Cliente cliente) {
		if (cliente.getId() != null) {
			jdbcTemplate.update("update cliente set name = ? where id = ?"
					,new Object[]{cliente.getName(), cliente.getId()} );
		} else {
			jdbcTemplate.update("insert into cliente(name) values (?)",
		               cliente.getName());
		}
	}

	@Override
	public void delete(Long id) {
		Object[] args = { id };
		jdbcTemplate.update("delete from cliente where id = ?", args);
	}

	private static RowMapper<Cliente> clienteMapper = (rs, rowNum) ->
	
	    new Cliente(
	        rs.getLong("id"),
	        rs.getString("name"));
}
