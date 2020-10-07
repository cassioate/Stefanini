package br.com.tessaro.app.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_obra")
public class Obra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "tb_nome")
	private String nome;
	
	@NotNull
	@Length(max = 240)
	@Column(name = "tb_descricao")
	private String descricao;
	
	@Column(name = "tb_publicacao")
	private LocalDate dataPublicacao;
	
	@Column(name = "tb_exposicao")
	private LocalDate dataExposicao;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "obras", cascade=CascadeType.ALL)
	private List<Autor> autores = new ArrayList<>();
	
	public Obra() {
		
	}
	
	public Obra(Long id, String nome, String descricao, LocalDate dataPublicacao, LocalDate dataExposicao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataPublicacao = dataPublicacao;
		this.dataExposicao = dataExposicao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Obra other = (Obra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
