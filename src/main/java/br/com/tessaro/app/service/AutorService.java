package br.com.tessaro.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.tessaro.app.dto.autor.CadastrarAutorDTO;
import br.com.tessaro.app.dto.autor.VisualizarAutorDTO;
import br.com.tessaro.app.model.Autor;
import br.com.tessaro.app.repository.AutorRepository;
import br.com.tessaro.app.repository.PaisRepository;
import br.com.tessaro.app.service.mapper.AutorMapper;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	public List<VisualizarAutorDTO> findAll(){
		List<VisualizarAutorDTO> visualizar = new ArrayList<>();
		List<Autor> autores = repository.findAll();
		AutorMapper.mapperVisualizar(visualizar, autores);
		return visualizar;
	}
	
	public VisualizarAutorDTO findById (Long id) {
		VisualizarAutorDTO visualizar = new VisualizarAutorDTO();
		Optional<Autor> obj = repository.findById(id);
		AutorMapper.mapperVisualizarID(visualizar, obj.get());
		return visualizar;
	}
	
	public VisualizarAutorDTO insert(CadastrarAutorDTO cadastrarDTO) {
		VisualizarAutorDTO visualizar = new VisualizarAutorDTO();
		Autor autor = AutorMapper.mapper(cadastrarDTO);
		autor.setPais(paisRepository.findByNome(cadastrarDTO.getPais()));
		repository.save(autor);
		AutorMapper.mapperVisualizarID(visualizar, autor);
		return visualizar;
	}
	
	public Autor update (CadastrarAutorDTO obj, Long id) {
		Autor entity = repository.getOne(id);
		AutorMapper.mapperEditar(entity, obj);
		return repository.save(entity);
	}
	
	public void deleteId(Long id) {
		repository.deleteById(id);
	}
	
	public Page<Autor> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public VisualizarAutorDTO findAutor(String nome) {
		VisualizarAutorDTO visualizar = new VisualizarAutorDTO();
		Autor autor = repository.findByNome(nome);
		AutorMapper.mapperVisualizarID(visualizar, autor);
		return visualizar;
	}

}