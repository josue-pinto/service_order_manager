package com.example.service_order_manager.controller;

import com.example.service_order_manager.model.Departamento;
import com.example.service_order_manager.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamento")
@CrossOrigin("*")
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository repo;

    @GetMapping
    public List<Departamento> listar() { return repo.findAll(); }

    @PostMapping
    public Departamento salvar(@RequestBody Departamento departamento) {
        departamento.setNome(departamento.getNome());
        departamento.setGerente(departamento.getGerente());
        departamento.setAndar(departamento.getAndar());
        departamento.setEmailSetor(departamento.getEmailSetor());
        departamento.setNomeExtenso(departamento.getNomeExtenso());

        return repo.save(departamento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id) {
        repo.deleteById(id);
    }

    @PutMapping("/{id}")
    public Departamento atualizar(@PathVariable Long id, @RequestBody Departamento departamentoAtualizada) {
        return repo.findById(id)
                .map(dep -> {
                    dep.setNome(departamentoAtualizada.getNome());
                    dep.setGerente(departamentoAtualizada.getGerente());
                    dep.setAndar(departamentoAtualizada.getAndar());
                    dep.setEmailSetor(departamentoAtualizada.getEmailSetor());
                    return ResponseEntity.ok(repo.save(dep));
                })
                .orElse(ResponseEntity.notFound().build()).getBody();
    }
}
