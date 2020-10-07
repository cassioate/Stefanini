package br.com.tessaro.app.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tessaro.app.dto.AutorDTO;
import br.com.tessaro.app.dto.AutorGetDTO;
import br.com.tessaro.app.model.Autor;
import br.com.tessaro.app.service.AutorService;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

	@Autowired
	private AutorService service;
	
	@GetMapping
	public ResponseEntity<List<AutorGetDTO>> findAll(){
		List<Autor> list = service.findAll();
		List<AutorGetDTO> listDto = list.stream().map(obj -> new AutorGetDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AutorGetDTO> findById(@PathVariable Long id){
		Autor obj = service.findById(id);
		AutorGetDTO objDTO = service.fromGetDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}
	
	@PostMapping
	public ResponseEntity<Autor> insert(@RequestBody AutorDTO objeto) {
		Autor obj = service.fromDTO(objeto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Autor> put(@RequestBody AutorDTO user, @PathVariable Long id) {
		Autor userDTO = service.fromDTOUpdate(user);
		return ResponseEntity.ok().body(service.update(userDTO, id));
	}
	
//	@DeleteMapping
//	public ResponseEntity<Autor> delete() {
//		service.delete();
//		return new ResponseEntity<Autor>(HttpStatus.OK);
//	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteId(id);
		return ResponseEntity.noContent().build();
	}
	

	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<AutorDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Autor> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<AutorDTO> listDto = list.map(obj -> new AutorDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
}
