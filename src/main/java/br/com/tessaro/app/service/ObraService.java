package br.com.tessaro.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.tessaro.app.dto.obra.CadastrarEditarObraDTO;
import br.com.tessaro.app.dto.obra.VisualizarObraDTO;
import br.com.tessaro.app.model.Obra;
import br.com.tessaro.app.repository.ObraRepository;
import br.com.tessaro.app.service.mapper.ObraMapper;
import br.com.tessaro.app.service.util.TimeUtil;

@Service
public class ObraService {

	@Autowired
	private ObraRepository repository;
	
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
		repository.save(obra);
		ObraMapper.mapperVisualizarID(visualizar, obra);
		return visualizar;
	}
	
	public Obra update (CadastrarEditarObraDTO obj, Long id) {
		Obra entity = repository.getOne(id);
		ObraMapper.mapperEditar(entity, obj);
		return repository.save(entity);
	}
	
	public void deleteId(Long id) {
		repository.deleteById(id);
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
	
	public VisualizarObraDTO fromGetDTO(Obra obra) {
		VisualizarObraDTO obj = new VisualizarObraDTO(obra);
		return obj;
	}
	
	public Obra fromDTO(CadastrarEditarObraDTO obj) {
		Obra obra = new Obra(
				obj.getNome(), 
				obj.getDescricao(), 
				TimeUtil.toLocalDate(obj.getDataPublicacao()), 
				TimeUtil.toLocalDate(obj.getDataExposicao()));
		return obra;
	}
}
