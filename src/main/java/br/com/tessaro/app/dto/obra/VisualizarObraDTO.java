package br.com.tessaro.app.dto.obra;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.tessaro.app.dto.VisualizarNomeDTO;
import br.com.tessaro.app.model.Obra;

public class VisualizarObraDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;

	private String descricao;

	private LocalDate dataPublicacao;

	private LocalDate dataExposicao;
	
	private List<VisualizarNomeDTO> autores = new ArrayList<>();
	
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

	public List<VisualizarNomeDTO> getAutores() {
		return autores;
	}

	public void setAutores(List<VisualizarNomeDTO> autores) {
		this.autores = autores;
	}

}
