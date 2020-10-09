package br.com.tessaro.app.service.mapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.util.Strings;

import br.com.tessaro.app.dto.VisualizarNomeDTO;
import br.com.tessaro.app.dto.obra.CadastrarEditarObraDTO;
import br.com.tessaro.app.dto.obra.VisualizarObraDTO;
import br.com.tessaro.app.model.Autor;
import br.com.tessaro.app.model.Obra;
import br.com.tessaro.app.service.util.TimeUtil;

public class ObraMapper implements Serializable{
	private static final long serialVersionUID = 1L;

	public static Obra mapper(CadastrarEditarObraDTO cadastrarDTO) {
		Obra obra = new Obra();
		obra.setNome(cadastrarDTO.getNome());
		obra.setDescricao(cadastrarDTO.getDescricao());
		obra.setDataPublicacao(Strings.isNotBlank(cadastrarDTO.getDataPublicacao()) ? TimeUtil.toLocalDate(cadastrarDTO.getDataPublicacao()) : null);
		obra.setDataExposicao(Strings.isNotBlank(cadastrarDTO.getDataExposicao()) ? TimeUtil.toLocalDate(cadastrarDTO.getDataExposicao()) : null);
		return obra;
		
	}

	public static void mapperVisualizar(List<VisualizarObraDTO> visualizar, List<Obra> obras) {
		for(Obra obra: obras) {
			VisualizarObraDTO visua = new VisualizarObraDTO(obra);
			visua.setId(obra.getId());
			visua.setNome(obra.getNome());
			visua.setDataExposicao(obra.getDataExposicao());
			visua.setDataPublicacao(obra.getDataPublicacao());
			visua.setDescricao(obra.getDescricao());
			visua.setAutores(mapearAutores(obra.getAutores()));
			visualizar.add(visua);
		}
	}
	
	public static void mapperVisualizarID(VisualizarObraDTO visua, Obra obra) {
			visua.setId(obra.getId());
			visua.setNome(obra.getNome());
			visua.setDataExposicao(obra.getDataExposicao());
			visua.setDataPublicacao(obra.getDataPublicacao());
			visua.setDescricao(obra.getDescricao());
			visua.setAutores(mapearAutores(obra.getAutores()));
		}
	
	private static List<VisualizarNomeDTO> mapearAutores(List<Autor> autores) {
		List<VisualizarNomeDTO> visualizar = new ArrayList<>();
		for(Autor autor: autores) {
			VisualizarNomeDTO visualizarNome = new VisualizarNomeDTO();
			visualizarNome.setNome(autor.getNome());
			visualizar.add(visualizarNome);
		}
		return visualizar;
	}

	public static void mapperEditar (Obra entity, CadastrarEditarObraDTO obj) {
			if(obj.getNome() != null) {
				entity.setNome(obj.getNome());
			} if(obj.getDescricao() != null) {
				entity.setDescricao(obj.getDescricao());
			} if(obj.getDataPublicacao() != null) {
				entity.setDataPublicacao(TimeUtil.toLocalDate(obj.getDataPublicacao()));
			} if(obj.getDataExposicao() != null) {
				entity.setDataExposicao(TimeUtil.toLocalDate(obj.getDataExposicao()));
			}
	}
	
}
	

