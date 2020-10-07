package br.com.tessaro.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.tessaro.app.dto.AutorDTO;
import br.com.tessaro.app.dto.AutorGetDTO;
import br.com.tessaro.app.model.Autor;
import br.com.tessaro.app.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repository;
	
	public List<Autor> findAll(){
		return repository.findAll();
	}
	
	public Autor findById (Long id) {
		Optional<Autor> obj = repository.findById(id);
		return obj.get();
	}
	
	public Autor insert (Autor objeto) {
		return repository.save(objeto);
	}
	
	public Autor update (Autor obj, Long id) {
		Autor entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Autor entity, Autor obj) {
		if(obj.getNome() != null) {
		entity.setNome(obj.getNome());
		} if(obj.getEmail() != null) {
		entity.setEmail(obj.getEmail());
		} if(obj.getPais() != null) {
		entity.setPais(obj.getPais());
		} if(obj.getSexo() != null) {
		entity.setSexo(obj.getSexo());
		}
	}
	
//	public void delete () {
//		repository.deleteAll();
//	}
	
	public void deleteId(Long id) {
		if (repository.findById(id).get().getObras().isEmpty()) {
		repository.deleteById(id);
		}
	} 

	public AutorGetDTO fromGetDTO(Autor autor) {
		AutorGetDTO obj = new AutorGetDTO(autor);
		return obj;
	}
	
	public Autor fromDTO(AutorDTO obj) {
		Autor autor = new Autor(null, obj.getNome(), obj.getSexo(), obj.getCpf(), obj.getDataNascimento(), obj.getPais(), obj.getCpf());
		return autor;
	}
	
	public Autor fromDTOUpdate(AutorDTO obj) {
		Autor autor = new Autor(obj.getNome(), obj.getSexo(), obj.getEmail(), obj.getDataNascimento(), obj.getPais());
		return autor;
	}
	
	public Page<Autor> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

}
