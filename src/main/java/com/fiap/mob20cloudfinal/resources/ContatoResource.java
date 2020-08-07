package com.fiap.mob20cloudfinal.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.mob20cloudfinal.domain.Contato;
import com.fiap.mob20cloudfinal.repositories.ContatoRepository;
import com.fiap.mob20cloudfinal.services.ContatoService;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoResource {
	
	@Autowired
	private ContatoService service;

	@GetMapping(value = "/teste")
	public ResponseEntity<List<Contato>> teste() {
		Contato c = new Contato("0", "Teste", "teste@teste.com", "999999999");
		List<Contato> lista = new ArrayList<Contato>();
		lista.add(c);

		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/todos")
	public ResponseEntity<List<Contato>> buscarTodos() {
		List<Contato> lista = service.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@PostMapping("/adicionar")
    public ResponseEntity<Contato> adicionar(@RequestBody Contato contato) {
        Contato c = service.adicionar(contato);
        return ResponseEntity.ok().body(c);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Contato> buscar(@PathVariable String id) {
        Contato c = service.buscar(id);
        return ResponseEntity.ok().body(c);
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<String> deletar(@RequestBody Contato contato) {
         String s = service.deletar(contato);
         return ResponseEntity.ok().body(s);
    }
    
    @DeleteMapping("/deleta/{id}")
    public ResponseEntity<String> deletaPorId(@PathVariable String id) {
         String s = service.deletaPorId(id);
         return ResponseEntity.ok().body(s);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<String> atualizar(@RequestBody Contato contato) {
    	String s = service.atualizar(contato);
    	return ResponseEntity.ok().body(s);
    }

}
