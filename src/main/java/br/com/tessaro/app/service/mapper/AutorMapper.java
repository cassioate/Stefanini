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
		String newCpf = AutorMapper.foramtarCpf(cadastrarDTO.getCpf());
		autor.setCpf(newCpf);
		return autor;
	}

	public static void mapperVisualizar(List<VisualizarAutorDTO> visualizar, List<Autor> autors) {
		for(Autor autor: autors) {
			VisualizarAutorDTO visua = new VisualizarAutorDTO(autor);
			visua.setId(autor.getId());
			visua.setNome(autor.getNome());
			visua.setEmail(autor.getEmail());
			visua.setDataNascimento(autor.getDataNascimento());
			visua.setPais(autor.getPais());
			visualizar.add(visua);
		}
	}
	
	public static void mapperVisualizarID(VisualizarAutorDTO visua, Autor autor) {
			visua.setCpf(autor.getCpf());
			visua.setId(autor.getId());
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
			}
	}
	
	public static String foramtarCpf (String cpf) {
		if (cpf.length() == 11) {
		String parte1 = cpf.substring(0, 3);
		String parte2 = cpf.substring(3, 6);
		String parte3 = cpf.substring(6, 9);
		String parte4 = cpf.substring(9, 11);
		String novoCpf = parte1+"."+parte2+"."+parte3+"-"+parte4;
		return novoCpf;
		} else {
			return cpf;
		}
	}
}
	

