package com.example.service_order_manager.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service_order_manager.model.OrdemServico;
import com.example.service_order_manager.repository.OrdemServicoRepository;

@RestController
@RequestMapping("/api/os")
@CrossOrigin("*")
public class OrdemServicoController {

	@Autowired
	private OrdemServicoRepository repo;

	@GetMapping
	public List<OrdemServico> listar() {
		return repo.findAll();
	}

	@PostMapping
	public OrdemServico criar(@RequestBody OrdemServico os) {
		os.setStatus("ABERTA");
		os.setDataEntrada(LocalDate.now());
		return repo.save(os);
	}
}
