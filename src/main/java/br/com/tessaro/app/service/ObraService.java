package br.com.tessaro.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.tessaro.app.dto.ObraDTO;
import br.com.tessaro.app.dto.ObraGetDTO;
import br.com.tessaro.app.model.Obra;
import br.com.tessaro.app.repository.ObraRepository;

@Service
public class ObraService {

	@Autowired
	private ObraRepository repository;
	
	public List<Obra> findAll(){
		return repository.findAll();
	}
	
	public Obra findById (Long id) {
		Optional<Obra> obj = repository.findById(id);
		return obj.get();
	}
	
	public Obra insert (Obra objeto) {
		return repository.save(objeto);
	}
	
	public Obra update (Obra obj, Long id) {
		Obra entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		
	}
	
	private void updateData(Obra entity, Obra obj) {
		if(obj.getNome() != null) {
		entity.setNome(obj.getNome());
		} if(obj.getDescricao() != null) {
		entity.setDescricao(obj.getDescricao());
		} if(obj.getDataPublicacao() != null) {
		entity.setDataPublicacao(obj.getDataPublicacao());
		} if(obj.getDataExposicao() != null) {
		entity.setDataExposicao(obj.getDataExposicao());
		}
	}
	
//	public void delete () {
//		repository.deleteAll();
//	}
	
	public void deleteId(Long id) {
		repository.deleteById(id);
	}

	public ObraGetDTO fromGetDTO(Obra obra) {
		ObraGetDTO obj = new ObraGetDTO(obra);
		return obj;
	}
	
	public Obra fromDTO(ObraDTO obj) {
		Obra obra = new Obra(null, obj.getNome(), obj.getDescricao(), obj.getDataPublicacao(), obj.getDataExposicao());
		return obra;
	}

	
	public Page<Obra> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

}
