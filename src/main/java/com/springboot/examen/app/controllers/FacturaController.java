package com.springboot.examen.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.examen.app.models.Cliente;
import com.springboot.examen.app.models.Factura;
import com.springboot.examen.app.repository.ClienteRepository;
import com.springboot.examen.app.repository.FacturaRepository;

@Controller
public class FacturaController {

	@Autowired
	private FacturaRepository facturaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Factura> facturas = facturaRepository.findAll();
		model.addAttribute("title", "Lista Facturas");
		model.addAttribute("facturas", facturas);
		return "listar";
	}
	
	@GetMapping("{id}/listar")
	public String listarPorCliente(@PathVariable(name = "id")Long id, Model model) {
		List<Factura> facturas = facturaRepository.findAllForCliente(id);
		Cliente cliente = clienteRepository.findById(id);
		model.addAttribute("title", "Lista Facturas");
		model.addAttribute("facturas", facturas);
		model.addAttribute("cliente", cliente);
		return "cliente/info";
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		Factura factura = new Factura();
		List<Cliente> cliente = clienteRepository.findAll();
		model.addAttribute("title", "Formulario");
		model.addAttribute("factura", factura);
		model.addAttribute("clientes", cliente);
		return "form";
	}
	
	@PostMapping("/form")
	public String save(Factura factura) {
		facturaRepository.save(factura);
		return "redirect:listar";
	}
	
	@GetMapping("/form/{id}")
	public String modificar(@PathVariable(name = "id")Long id, Model model) {
		Factura factura = facturaRepository.findById(id);
		List<Cliente> cliente = clienteRepository.findAll();
		model.addAttribute("factura", factura);
		model.addAttribute("clientes", cliente);
		return "form";
	}
	
	@GetMapping("/{id}")
	public String delete(@PathVariable(name = "id")Long id) {
		if (id > 0) {
			facturaRepository.delete(id);
		}
		return "redirect:/listar";
	}
}
