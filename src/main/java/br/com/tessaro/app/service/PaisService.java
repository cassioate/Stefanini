package br.com.tessaro.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.tessaro.app.dto.pais.VisualizarPaisDTO;
import br.com.tessaro.app.model.Pais;
import br.com.tessaro.app.repository.PaisRepository;
import br.com.tessaro.app.service.mapper.PaisMapper;

@Service
public class PaisService {
	
	@Autowired
	PaisRepository repository;
	
	public Page<VisualizarPaisDTO> findAllPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Pais> paises = repository.findAll(pageRequest);
		Page<VisualizarPaisDTO> paisesDTO = PaisMapper.mapper(paises);
		return paisesDTO;
	}

}
