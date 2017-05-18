package br.caelum.dao;

import java.util.List;

import br.caelum.model.Contato;

public interface ContatoDaoInterface {
	
	void addContato(Contato contato);
	
	void alterarContato(Contato contato);
	
	void excluirContato(Contato contato);
	
	List<Contato> getContatos();
	
}
