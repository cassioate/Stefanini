package br.com.tessaro.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tessaro.app.dto.pais.VisualizarPaisDTO;
import br.com.tessaro.app.service.PaisService;

@RestController
@RequestMapping("/pais")
public class PaisController {
	
	@Autowired
	PaisService service;
	
	@GetMapping("/filtro")
	public ResponseEntity<Page<VisualizarPaisDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="50") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		return new ResponseEntity<Page<VisualizarPaisDTO>>(service.findAllPage(page, linesPerPage, orderBy, direction), HttpStatus.OK);
	}

}
