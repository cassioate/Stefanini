package br.com.tessaro.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tessaro.app.model.Obra;

public interface ObraRepository extends JpaRepository<Obra, Long>{

}
