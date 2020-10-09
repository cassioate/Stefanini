package br.com.tessaro.app.dto;

import java.io.Serializable;

public class VisualizarNomeDTO implements Serializable{
	private static final long serialVersionUID = 4864997029610681641L;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
