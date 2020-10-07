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

import br.com.tessaro.app.dto.ObraDTO;
import br.com.tessaro.app.dto.ObraGetDTO;
import br.com.tessaro.app.model.Obra;
import br.com.tessaro.app.service.ObraService;

@RestController
@RequestMapping(value = "/obras")
public class ObraController {
	
	@Autowired
	private ObraService service;
	
	@GetMapping
	public ResponseEntity<List<ObraGetDTO>> findAll(){
		List<Obra> list = service.findAll();
		List<ObraGetDTO> listDto = list.stream().map(obj -> new ObraGetDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ObraGetDTO> findById(@PathVariable Long id){
		Obra obj = service.findById(id);
		ObraGetDTO objDTO = service.fromGetDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}
	
	@PostMapping
	public ResponseEntity<Obra> insert(@RequestBody ObraDTO objeto) {
		Obra obj = service.fromDTO(objeto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Obra> put(@RequestBody ObraDTO user, @PathVariable Long id) {
		Obra userDTO = service.fromDTO(user);
		return ResponseEntity.ok().body(service.update(userDTO, id));
	}
	
//	@DeleteMapping
//	public ResponseEntity<Obra> delete() {
//		service.delete();
//		return new ResponseEntity<Obra>(HttpStatus.OK);
//	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteId(id);
		return ResponseEntity.noContent().build();
	}
	

	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<ObraDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Obra> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ObraDTO> listDto = list.map(obj -> new ObraDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
}

