package com.fiap.mob20cloudfinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.mob20cloudfinal.domain.Contato;
import com.fiap.mob20cloudfinal.repositories.ContatoRepository;
import com.fiap.mob20cloudfinal.services.exception.ObjectNotFoundException;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repo;

	public List<Contato> buscarTodos() {
		return (List<Contato>) repo.findAll();
	}

	public Contato adicionar(Contato contato) {
		return repo.add(contato);
	}

	public Contato buscar(String id) {
		Contato c = repo.findById(id);
		if(c == null)
			throw new ObjectNotFoundException("Contato não encontrado");
		else
			return c;
	}

	public String deletaPorId(String id) {
		String retorno = repo.deleteById(id);

		if (retorno == "-1")
			throw new ObjectNotFoundException("Contato não encontrado");
		else
			return retorno;
	}

	public String deletar(Contato contato) {
		return repo.delete(contato);
	}

	public String atualizar(Contato contato) {
		return repo.edit(contato);
	}
}
