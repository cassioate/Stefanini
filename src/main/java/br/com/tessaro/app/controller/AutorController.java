package br.com.tessaro.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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

import br.com.tessaro.app.dto.autor.CadastrarAutorDTO;
import br.com.tessaro.app.dto.autor.VisualizarAutorDTO;
import br.com.tessaro.app.model.Autor;
import br.com.tessaro.app.service.AutorService;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {
		
	@Autowired
	private AutorService service;
	
	@GetMapping
	public ResponseEntity<List<VisualizarAutorDTO>> findAll() {
		return new ResponseEntity<List<VisualizarAutorDTO>>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<VisualizarAutorDTO> findById(@PathVariable Long id) {
		return new ResponseEntity<VisualizarAutorDTO>(service.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<VisualizarAutorDTO> insert(@RequestBody @Valid CadastrarAutorDTO cadastrarDTO) {
		return new ResponseEntity<VisualizarAutorDTO>(service.insert(cadastrarDTO), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Autor> put(@RequestBody CadastrarAutorDTO user, @PathVariable Long id) {
		return new ResponseEntity<Autor>(service.update(user, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		service.deleteId(id);
		return ResponseEntity.ok("Deletado com sucesso!");
	}

	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<VisualizarAutorDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Autor> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<VisualizarAutorDTO> listDto = list.map(obj -> new VisualizarAutorDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
}
