package br.com.tessaro.app.dto.obra;

import java.time.LocalDate;

import br.com.tessaro.app.model.Obra;

public class VisualizarObraDTO {
	
	private Long id;
	
	private String nome;

	private String descricao;

	private LocalDate dataPublicacao;

	private LocalDate dataExposicao;
	
	public VisualizarObraDTO() {
		
	}
	
	public VisualizarObraDTO (Obra obra) {
		this.id = obra.getId();
		this.nome = obra.getNome();
		this.descricao = obra.getDescricao();
		this.dataPublicacao = obra.getDataPublicacao();
		this.dataExposicao = obra.getDataExposicao();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
