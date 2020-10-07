package br.com.tessaro.app.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.tessaro.app.model.Autor;
import br.com.tessaro.app.model.Obra;

public class ObraDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private String descricao;

	private LocalDate dataPublicacao;

	private LocalDate dataExposicao;
	
	private List<Autor> autores = new ArrayList<>();

	public ObraDTO() {
		
	}
	
	public ObraDTO (Obra obra) {
		super();
		this.nome = obra.getNome();
		this.descricao = obra.getDescricao();
		this.dataPublicacao = obra.getDataPublicacao();
		this.dataExposicao = obra.getDataExposicao();
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

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public LocalDate getDataExposicao() {
		return dataExposicao;
	}

	public void setDataExposicao(LocalDate dataExposicao) {
		this.dataExposicao = dataExposicao;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
}
