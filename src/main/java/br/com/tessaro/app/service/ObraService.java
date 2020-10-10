package br.com.tessaro.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.tessaro.app.dto.VisualizarNomeDTO;
import br.com.tessaro.app.dto.obra.CadastrarEditarObraDTO;
import br.com.tessaro.app.dto.obra.VisualizarObraDTO;
import br.com.tessaro.app.model.Autor;
import br.com.tessaro.app.model.Obra;
import br.com.tessaro.app.repository.AutorRepository;
import br.com.tessaro.app.repository.ObraRepository;
import br.com.tessaro.app.service.mapper.ObraMapper;
import br.com.tessaro.app.service.util.TimeUtil;

@Service
public class ObraService {

	@Autowired
	private ObraRepository repository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	public List<VisualizarObraDTO> findAll(){
		List<VisualizarObraDTO> visualizar = new ArrayList<>();
		List<Obra> obras = repository.findAll();
		ObraMapper.mapperVisualizar(visualizar, obras);
		return visualizar;
	}
	
	public VisualizarObraDTO findById (Long id) {
		VisualizarObraDTO visualizar = new VisualizarObraDTO();
		Optional<Obra> obj = repository.findById(id);
		ObraMapper.mapperVisualizarID(visualizar, obj.get());
		return visualizar;
	}
	
	public VisualizarObraDTO insert(CadastrarEditarObraDTO cadastrarDTO) {
		VisualizarObraDTO visualizar = new VisualizarObraDTO();
		Obra obra = ObraMapper.mapper(cadastrarDTO);
		List<Autor> autores = mapearAutores(cadastrarDTO.getAutores(), obra);
		for (Autor a: autores) {
			obra.getAutores().add(a);
		}
		repository.save(obra);
		ObraMapper.mapperVisualizarID(visualizar, obra);
		return visualizar;
	}
	
	private List<Autor> mapearAutores(List<VisualizarNomeDTO> autores, Obra obra) {
		List<Autor> autoress = new ArrayList<>();
		for (VisualizarNomeDTO nomeAutor: autores) {
			Autor autor = autorRepository.findByNome(nomeAutor.getNome());
			if(autor != null) {
				autoress.add(autor);
				autor.getObras().add(obra);
			}
		}
		return autoress;
	}
	
	public Obra update (CadastrarEditarObraDTO obj, Long id) {
		Obra entity = repository.getOne(id);
		ObraMapper.mapperEditar(entity, obj);
		return repository.save(entity);
	}
	
	public void deleteId(Long id) {
		Optional<Obra> obra = repository.findById(id);
//		removerAutores(obra);
		repository.deleteById(id);
	}
	public void removerAutores (Optional<Obra> obra) {
	for(Autor a: obra.get().getAutores()) {
		obra.get().getAutores().remove(a);
		}
	}
	public Page<Obra> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public List<VisualizarObraDTO> findPublicacao(String dataInicial, String dataFinal) {
		List<VisualizarObraDTO> visualizar = new ArrayList<>();
		List<Obra> obras = repository.findByData(TimeUtil.toLocalDate(dataInicial),TimeUtil.toLocalDate(dataFinal));
		ObraMapper.mapperVisualizar(visualizar, obras);
		return visualizar;
	}
	
	public VisualizarObraDTO findObraNome (String nome) {
		VisualizarObraDTO visualizar = new VisualizarObraDTO();
		Obra obra = repository.findByNome(nome);
		ObraMapper.mapperVisualizarID(visualizar, obra);
		return visualizar;
	}
	
	public VisualizarObraDTO findObraDescricao (String descricao) {
		VisualizarObraDTO visualizar = new VisualizarObraDTO();
		Obra obra = repository.findByDescricao(descricao);
		ObraMapper.mapperVisualizarID(visualizar, obra);
		return visualizar;
	}
	
}
