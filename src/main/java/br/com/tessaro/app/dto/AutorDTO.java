package br.com.tessaro.app.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.tessaro.app.model.Autor;
import br.com.tessaro.app.model.Obra;
import br.com.tessaro.app.model.Pais;

public class AutorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	
	private String sexo;
	
	private String email;

	private LocalDate dataNascimento;

	private Pais pais;
	
	private String cpf;
	
	private List<Obra> obras = new ArrayList<>();

	public AutorDTO() {

	}
	
	public AutorDTO(Autor autor) {
		this.nome = autor.getNome();
		this.sexo = autor.getSexo();
		this.email = autor.getEmail();
		this.dataNascimento = autor.getDataNascimento();
		this.pais = autor.getPais();
		this.cpf = autor.getCpf();
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Obra> getObras() {
		return obras;
	}

	public void setObras(List<Obra> obras) {
		this.obras = obras;
	}

}
