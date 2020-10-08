package br.com.tessaro.app.dto.autor;

import java.time.LocalDate;

import br.com.tessaro.app.model.Autor;

public class VisualizarAutorDTO {

	private Long id;
	
	private String cpf;
	
	private String nome;
	
	private String email;
	
	private LocalDate dataNascimento;
	
	private String pais;
	
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

}
