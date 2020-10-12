package br.com.tessaro.app.service.mapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.tessaro.app.dto.VisualizarNomeDTO;
import br.com.tessaro.app.dto.autor.CadastrarAutorDTO;
import br.com.tessaro.app.dto.autor.VisualizarAutorDTO;
import br.com.tessaro.app.model.Autor;
import br.com.tessaro.app.model.Obra;
import br.com.tessaro.app.service.util.TimeUtil;

public class AutorMapper implements Serializable {
	private static final long serialVersionUID = 1L;

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
		for (Autor autor : autors) {
			VisualizarAutorDTO visua = new VisualizarAutorDTO(autor);
			visua.setId(autor.getId());
			visua.setCpf(autor.getCpf());
			visua.setSexo(autor.getSexo());
			visua.setNome(autor.getNome());
			visua.setEmail(autor.getEmail());
			visua.setDataNascimento(autor.getDataNascimento());
			visua.setPais(autor.getPais());
			visua.setObras(mapearObras(autor.getObras()));
			visualizar.add(visua);
		}
	}

	public static void mapperVisualizarID(VisualizarAutorDTO visua, Autor autor) {
		visua.setCpf(autor.getCpf());
		visua.setId(autor.getId());
		visua.setSexo(autor.getSexo());
		visua.setNome(autor.getNome());
		visua.setEmail(autor.getEmail());
		visua.setDataNascimento(autor.getDataNascimento());
		visua.setPais(autor.getPais());
		visua.setObras(mapearObras(autor.getObras()));
	}

	private static List<VisualizarNomeDTO> mapearObras(List<Obra> obras) {
		List<VisualizarNomeDTO> visualizar = new ArrayList<>();
		for (Obra obra : obras) {
			VisualizarNomeDTO visualizarNome = new VisualizarNomeDTO();
			visualizarNome.setNome(obra.getNome());
			visualizar.add(visualizarNome);
		}
		return visualizar;
	}

	public static void mapperEditar(Autor entity, CadastrarAutorDTO obj) {
		if (obj.getNome() != null && !obj.getNome().isBlank() && entity.getNome() != obj.getNome()) {
			entity.setNome(obj.getNome());
		}
		if (entity.getEmail() != obj.getEmail() && obj.getEmail() != null && !obj.getEmail().isBlank()) {
			entity.setEmail(obj.getEmail());
		}
		if (obj.getDataNascimento() != null && !obj.getDataNascimento().isBlank()
				&& entity.getDataNascimento() != TimeUtil.toLocalDate(obj.getDataNascimento())) {
			entity.setDataNascimento(TimeUtil.toLocalDate(obj.getDataNascimento()));
		}
		
		if (obj.getCpf() != null && !obj.getCpf().isBlank() && entity.getCpf() != obj.getCpf()) {
			entity.setCpf(obj.getCpf());
		}

	}

	public static String foramtarCpf(String cpf) {
		if (cpf.length() == 11) {
			String parte1 = cpf.substring(0, 3);
			String parte2 = cpf.substring(3, 6);
			String parte3 = cpf.substring(6, 9);
			String parte4 = cpf.substring(9, 11);
			String novoCpf = parte1 + "." + parte2 + "." + parte3 + "-" + parte4;
			return novoCpf;
		} else {
			return cpf;
		}
	}
}
