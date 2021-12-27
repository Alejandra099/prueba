package com.springboot.examen.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.examen.app.models.Cliente;
import com.springboot.examen.app.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Cliente> clientes = clienteRepository.findAll();
		model.addAttribute("title", "Lista Clientes");
		model.addAttribute("clientes", clientes);
		return "cliente/listar";
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("title", "Formulario");
		model.addAttribute("cliente", cliente);
		return "cliente/form";
	}
	
	@PostMapping("/form")
	public String save(Cliente cliente) {
		clienteRepository.save(cliente);
		return "redirect:listar";
	}
	
	@GetMapping("/form/{id}")
	public String modificar(@PathVariable(name = "id")Long id, Model model) {
		Cliente cliente = clienteRepository.findById(id);
		model.addAttribute("cliente", cliente);
		return "cliente/form";
	}
	
	@GetMapping("/{id}")
	public String delete(@PathVariable(name = "id")Long id) {
		if (id > 0) {
			clienteRepository.delete(id);
		}
		return "redirect:/clientes/listar";
	}
}
