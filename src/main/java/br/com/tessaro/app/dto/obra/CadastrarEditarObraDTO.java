package br.com.tessaro.app.dto.obra;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.tessaro.app.dto.VisualizarNomeDTO;
import br.com.tessaro.app.service.annotations.ObraValido;
import br.com.tessaro.app.service.annotations.PeriodoDataValido;

@ObraValido
@PeriodoDataValido(dataPublicacao = "dataPublicacao", dataExposicao = "dataExposicao", message = "A data de publicação e a data de exposição não podem ser nulas ao mesmo tempo, devendo sempre uma ou outra ser informada.")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CadastrarEditarObraDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Nome da obra é obrigatorio")
	private String nome;

	@NotBlank(message = "Descrição da obra é obrigatoria")
	@Size(max = 240, message = "A descrição da obra deve conter no máximo {max} caracteres")
	private String descricao;

	private String dataPublicacao;

	private String dataExposicao;
	
	private List<VisualizarNomeDTO> autores = new ArrayList<>();

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

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getDataExposicao() {
		return dataExposicao;
	}

	public void setDataExposicao(String dataExposicao) {
		this.dataExposicao = dataExposicao;
	}
	
	public List<VisualizarNomeDTO> getAutores() {
		return autores;
	}

	public void setAutores(List<VisualizarNomeDTO> autores) {
		this.autores = autores;
	}

}
