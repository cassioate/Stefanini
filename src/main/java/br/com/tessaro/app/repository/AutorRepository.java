package br.com.tessaro.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tessaro.app.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
	
	Autor findByEmail(String email);
	
	
}
