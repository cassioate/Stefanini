package br.com.tessaro.app.service.mapper;

import java.util.List;

import br.com.tessaro.app.dto.autor.CadastrarAutorDTO;
import br.com.tessaro.app.dto.autor.VisualizarAutorDTO;
import br.com.tessaro.app.model.Autor;
import br.com.tessaro.app.service.util.TimeUtil;

public class AutorMapper {

	public static Autor mapper(CadastrarAutorDTO cadastrarDTO) {
		Autor autor = new Autor();
		autor.setNome(cadastrarDTO.getNome());
		autor.setEmail(cadastrarDTO.getEmail());
		autor.setSexo(cadastrarDTO.getSexo());
		autor.setDataNascimento(TimeUtil.toLocalDate(cadastrarDTO.getDataNascimento()));
		autor.setPais(cadastrarDTO.getPais());
		autor.setCpf(cadastrarDTO.getCpf());
		return autor;
	}

	public static void mapperVisualizar(List<VisualizarAutorDTO> visualizar, List<Autor> autors) {
		for(Autor autor: autors) {
			VisualizarAutorDTO visua = new VisualizarAutorDTO(autor);
			visua.setNome(autor.getNome());
			visua.setEmail(autor.getEmail());
			visua.setDataNascimento(autor.getDataNascimento());
			visua.setPais(autor.getPais());
		}
	}
	
	public static void mapperVisualizarID(VisualizarAutorDTO visua, Autor autor) {
			visua.setNome(autor.getNome());
			visua.setEmail(autor.getEmail());
			visua.setDataNascimento(autor.getDataNascimento());
			visua.setPais(autor.getPais());
		}
	
	public static void mapperEditar (Autor entity, CadastrarAutorDTO obj) {
			if(obj.getNome() != null) {
				entity.setNome(obj.getNome());
			} if(obj.getEmail() != null) {
				entity.setEmail(obj.getEmail());
			} if(obj.getDataNascimento()!= null) {
				entity.setDataNascimento(TimeUtil.toLocalDate(obj.getDataNascimento()));
			} if(obj.getPais() != null) {
				entity.setPais(obj.getPais());
			}
	}
	
}
	

