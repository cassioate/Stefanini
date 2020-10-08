package br.com.tessaro.app.dto.autor;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.tessaro.app.service.annotations.CpfValido;
import br.com.tessaro.app.service.annotations.DataValido;
import br.com.tessaro.app.service.annotations.EmailValido;
import br.com.tessaro.app.service.annotations.PaisValido;

@CpfValido @EmailValido @DataValido @PaisValido
public class CadastrarAutorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Nome é obrigatorio")
	private String nome;
	
	private String sexo;
	
	@Email
	private String email;
	
	@NotBlank(message = "Data é obrigatorio")
	private String dataNascimento;
	
	@NotBlank(message = "País é obrigatorio")
	private String pais;
	
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
