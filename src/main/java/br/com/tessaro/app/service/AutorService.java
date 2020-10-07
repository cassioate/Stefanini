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
import br.com.tessaro.app.service.mapper.AutorMapper;
import br.com.tessaro.app.service.util.TimeUtil;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repository;
	
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

//	public List<VisualizarAutorDTO> findPublicacao(String dataInicial, String dataFinal) {
//		List<VisualizarAutorDTO> visualizar = new ArrayList<>();
//		List<Autor> autores = repository.findByData(TimeUtil.toLocalDate(dataInicial),TimeUtil.toLocalDate(dataFinal));
//		AutorMapper.mapperVisualizar(visualizar, autores);
//		return visualizar;
//	}
	
	public VisualizarAutorDTO fromGetDTO(Autor autor) {
		VisualizarAutorDTO obj = new VisualizarAutorDTO(autor);
		return obj;
	}
	
	public Autor fromDTO(CadastrarAutorDTO obj) {
		Autor autor = new Autor(
				obj.getNome(), 
				obj.getSexo(),
				obj.getEmail(),
				TimeUtil.toLocalDate(obj.getDataNascimento()),
				obj.getPais(),
				obj.getCpf());
		return autor;
	}

}
