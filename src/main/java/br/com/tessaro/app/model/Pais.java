package br.com.tessaro.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pais")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codigo;
	
	@Column(name = "tb_nome")
	private String nome;

	public Pais(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}