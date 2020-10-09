package br.com.tessaro.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tessaro.app.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{
	
	Autor findByNome(String nome);

	Autor findByEmail(String email);
	
	Autor findByCpf(String cpf);
	
}
