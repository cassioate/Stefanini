package br.com.tessaro.app.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_autor")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tb_nome")
	private String nome;
	
	@Column(name = "tb_sexo")
	private String sexo;
	
	@Column(name = "tb_email")
	private String email;
	
	private LocalDate dataNascimento;
	
	@Column(name = "tb_pais")
	private Pais pais;
	
	@Column(name = "tb_cpf")
	private String cpf;
	
	@ManyToMany
	@JoinTable(name = "AUTOR_OBRA", 
	joinColumns = @JoinColumn(name = "AUTOR_ID"),
	inverseJoinColumns =  @JoinColumn(name = "OBRA_ID"))
	private List<Obra> obras = new ArrayList<>();

	public Autor() {
		
	}
	
	public Autor(String nome, String sexo, String email, LocalDate dataNascimento, Pais pais, String cpf) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.pais = pais;
		this.cpf = cpf;
	}
	
	public Autor(String nome, String sexo, String email, LocalDate dataNascimento, Pais pais) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.pais = pais;
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

	public String getPais() {
		return pais.getNome();
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
		Autor other = (Autor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
