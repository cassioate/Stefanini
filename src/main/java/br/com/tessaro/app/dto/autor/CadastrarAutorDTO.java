package br.com.tessaro.app.dto.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import br.com.tessaro.app.model.Pais;

public class CadastrarAutorDTO {
	
	@NotBlank(message = "Nome é obrigatorio")
	private String nome;
	
	private String sexo;
	
	@Email
	private String email;
	
	@NotBlank(message = "Data é obrigatorio")
	private String dataNascimento;
	
	@NotBlank(message = "Data é obrigatorio")
	private Pais pais;
	
	@CPF
	private String cpf;

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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
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

}
