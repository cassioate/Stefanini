package br.com.tessaro.app.dto.autor;

import java.time.LocalDate;

import br.com.tessaro.app.model.Autor;
import br.com.tessaro.app.model.Pais;

public class VisualizarAutorDTO {

	private String nome;
	
	private String email;
	
	private LocalDate dataNascimento;
	
	private Pais pais;
	
	public VisualizarAutorDTO() {
		
	}
	
	public VisualizarAutorDTO (Autor autor) {
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
