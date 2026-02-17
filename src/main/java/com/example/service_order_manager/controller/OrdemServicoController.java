package com.example.service_order_manager.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PutMapping("/{id}")
	public ResponseEntity<OrdemServico> atualizar(@PathVariable Long id, @RequestBody OrdemServico osAtualizada) {
		return repo.findById(id)
			.map(os -> {
				os.setCliente(osAtualizada.getCliente());
				os.setEquipamento(osAtualizada.getEquipamento());
				os.setDescricao(osAtualizada.getDescricao());
				os.setStatus(osAtualizada.getStatus());
				os.setDataSaida(osAtualizada.getDataSaida());
				return ResponseEntity.ok(repo.save(os));
			})
			.orElse(ResponseEntity.notFound().build());
	}
}
