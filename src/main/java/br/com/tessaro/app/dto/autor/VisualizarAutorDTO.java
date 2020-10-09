package br.com.tessaro.app.dto.autor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.tessaro.app.dto.VisualizarNomeDTO;
import br.com.tessaro.app.model.Autor;

public class VisualizarAutorDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String sexo;
	
	private String cpf;
	
	private String nome;
	
	private String email;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	private String pais;
	
	List<VisualizarNomeDTO> obras = new ArrayList<>();
	
	public VisualizarAutorDTO() {
		
	}
	
	public VisualizarAutorDTO (Autor autor) {
		this.id = autor.getId();
		this.cpf = autor.getCpf();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.dataNascimento = autor.getDataNascimento();
		this.pais = autor.getPais();
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<VisualizarNomeDTO> getObras() {
		return obras;
	}

	public void setObras(List<VisualizarNomeDTO> obras) {
		this.obras = obras;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
