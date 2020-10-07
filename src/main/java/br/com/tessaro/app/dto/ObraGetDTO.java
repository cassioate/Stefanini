package br.com.tessaro.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.tessaro.app.model.Autor;
import br.com.tessaro.app.model.Obra;

public class ObraGetDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	
	private String descricao;
	
	private List<Autor> autores = new ArrayList<>();
	
	public ObraGetDTO(Obra obra) {
		this.nome = obra.getNome();
		this.descricao = obra.getDescricao();
		for (Autor autor : obra.getAutores()) {
			this.autores.add(autor);
		}
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<Autor> getAutores() {
		return autores;
	}


	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
}
