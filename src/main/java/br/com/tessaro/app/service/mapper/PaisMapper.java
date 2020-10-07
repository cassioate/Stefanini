package br.com.tessaro.app.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.tessaro.app.dto.pais.VisualizarPaisDTO;
import br.com.tessaro.app.model.Pais;

public class PaisMapper {


	public static Page<VisualizarPaisDTO> mapper(Page<Pais> paises) {
		List<VisualizarPaisDTO> visualizar = new ArrayList<>();
		for(Pais pais: paises) {
			VisualizarPaisDTO visua = new VisualizarPaisDTO();
			visua.setNome(pais.getNome());
			visualizar.add(visua);
		}
		Page<VisualizarPaisDTO> page = new PageImpl<>(visualizar);
		return page;
	}

}
