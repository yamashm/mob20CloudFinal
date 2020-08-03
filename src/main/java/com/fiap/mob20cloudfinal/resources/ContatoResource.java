package com.fiap.mob20cloudfinal.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.mob20cloudfinal.domain.Contato;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoResource {
	
	@GetMapping(value = "/teste")
	public ResponseEntity<List<Contato>> teste(){
		Contato c = new Contato("0", "Teste", "teste@teste.com", "999999999");
		List<Contato> lista = new ArrayList<Contato>();
		lista.add(c);
		
		return ResponseEntity.ok().body(lista); 
	}
	
	@GetMapping(value = "/todos")
	public ResponseEntity<List<Contato>> buscarTodos(){
		List<Contato> lista = new ArrayList<Contato>();
		return ResponseEntity.ok().body(lista); 
	}
	
	
}
