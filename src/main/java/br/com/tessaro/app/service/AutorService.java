package br.com.tessaro.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
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
import br.com.tessaro.app.service.exception.NegocioException;
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
		if(Strings.isNotBlank(cadastrarDTO.getCpf())) {
			Autor autorCpf = repository.findByCpf(AutorMapper.foramtarCpf(cadastrarDTO.getCpf()));
			existeCadastroCpf(autorCpf);			
		}
		Autor autor = AutorMapper.mapper(cadastrarDTO);
		jaExiste(repository.findByNome(cadastrarDTO.getNome()));
		autor.setPais(paisRepository.findByNome(cadastrarDTO.getPais()));
		repository.save(autor);
		AutorMapper.mapperVisualizarID(visualizar, autor);
		return visualizar;
	}
	
	private void existeCadastroCpf(Autor autorCpf) {
		if(autorCpf != null) {
			throw new NegocioException("Cpf já cadastrado, por favor utilize outro cpf");
		}
		
	}
	
	private void jaExiste (Autor autor) {
		if(autor != null) {
			throw new NegocioException("Já exsite um autor com esse nome, insira algo para diferenciar os autores");
		}
		
	}
	
	private void confirmaDiferenteObjeto (Autor autorCpf, Long id) {
		if (autorCpf != null && autorCpf.getId() != id) {
			throw new NegocioException("Cpf já cadastrado, por favor utilize outro cpf");
		}
	}
	
	
	public Autor update (CadastrarAutorDTO obj, Long id) {
		if(Strings.isNotBlank(obj.getCpf())) {
			String cpf = AutorMapper.foramtarCpf(obj.getCpf());
			Autor autorCpf = repository.findByCpf(cpf);
			confirmaDiferenteObjeto(autorCpf, id);
		}
		
		Autor entity = repository.getOne(id);
		AutorMapper.mapperEditar(entity, obj);
		entity.setPais(paisRepository.findByNome(obj.getPais()));
		return repository.save(entity);
	}
	
	
	public void deleteId(Long id) {
		Autor autor = repository.findById(id).get();
		if(!autor.getObras().isEmpty()) {
			throw new NegocioException("Não pode excluir autor associado a uma obra");
		}
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