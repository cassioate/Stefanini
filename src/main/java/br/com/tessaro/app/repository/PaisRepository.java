package br.com.tessaro.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tessaro.app.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

	Pais findByNome(String nome);
	
}
