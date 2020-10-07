package br.com.tessaro.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.tessaro.app.model.Autor;
import br.com.tessaro.app.model.Obra;

public class AutorGetDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	
	private List<Obra> obras = new ArrayList<>();
	
	public AutorGetDTO(Autor autor) {
		this.nome = autor.getNome();
		for (Obra obra : autor.getObras()) {
			this.obras.add(obra);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Obra> getObras() {
		return obras;
	}

	public void setObras(List<Obra> obras) {
		this.obras = obras;
	}
	
}
