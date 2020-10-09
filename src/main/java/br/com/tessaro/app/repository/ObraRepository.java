package br.com.tessaro.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tessaro.app.model.Obra;

@Repository
public interface ObraRepository extends JpaRepository<Obra, Long>{

	@Query("select obra from Obra obra where obra.dataPublicacao between :dataInicial and :dataFinal")
	List<Obra> findByData(@Param("dataInicial")LocalDate dataInicial, @Param("dataFinal")LocalDate dataFinal);
	
	Obra findByDescricao(String descricao);
	
	Obra findByNome (String nome);
}
