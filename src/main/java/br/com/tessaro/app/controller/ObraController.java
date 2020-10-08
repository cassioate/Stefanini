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

import br.com.tessaro.app.dto.obra.CadastrarEditarObraDTO;
import br.com.tessaro.app.dto.obra.VisualizarObraDTO;
import br.com.tessaro.app.model.Obra;
import br.com.tessaro.app.service.ObraService;

@RestController
@RequestMapping(value = "/obras")
public class ObraController {
	
	@Autowired
	private ObraService service;
	
	@GetMapping
	public ResponseEntity<List<VisualizarObraDTO>> findAll() {
		return new ResponseEntity<List<VisualizarObraDTO>>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/filtro-publicacao")
	public ResponseEntity<List<VisualizarObraDTO>> findPublicacao(
			@RequestParam(value="dataInicial") String dataInicial, 
			@RequestParam(value="dataFinal") String dataFinal){
		return new ResponseEntity<List<VisualizarObraDTO>>(service.findPublicacao(dataInicial, dataFinal), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<VisualizarObraDTO> findById(@PathVariable Long id) {
		return new ResponseEntity<VisualizarObraDTO>(service.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<VisualizarObraDTO> insert(@RequestBody @Valid CadastrarEditarObraDTO cadastrarDTO) {
		return new ResponseEntity<VisualizarObraDTO>(service.insert(cadastrarDTO), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Obra> put(@RequestBody CadastrarEditarObraDTO user, @PathVariable Long id) {
		return new ResponseEntity<Obra>(service.update(user, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		service.deleteId(id);
		return ResponseEntity.ok("Deletado com sucesso!");
	}

	@GetMapping("/obraNome")
	public ResponseEntity<VisualizarObraDTO> obraNome (@RequestParam String nome) {
		return new ResponseEntity<VisualizarObraDTO>(service.findObraNome(nome), HttpStatus.OK);
	}
	
	@GetMapping("/obraDescricao")
	public ResponseEntity<VisualizarObraDTO> obraDescricao (@RequestParam String descricao) {
		return new ResponseEntity<VisualizarObraDTO>(service.findObraDescricao(descricao), HttpStatus.OK);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<VisualizarObraDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Obra> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<VisualizarObraDTO> listDto = list.map(obj -> new VisualizarObraDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
}

