package br.com.tessaro.app.service.validators;

import java.util.ArrayList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.tessaro.app.dto.VisualizarNomeDTO;
import br.com.tessaro.app.dto.obra.CadastrarEditarObraDTO;
import br.com.tessaro.app.model.Autor;
import br.com.tessaro.app.repository.AutorRepository;
import br.com.tessaro.app.service.annotations.ObraValido;

public class ObraValidator implements ConstraintValidator<ObraValido, CadastrarEditarObraDTO> {
	
	@Autowired 
	private AutorRepository repository;
	
	@Override
	public void initialize(ObraValido a) {
 	}

	@Override
	public boolean isValid(CadastrarEditarObraDTO autores, ConstraintValidatorContext cvc) {
		boolean isValid = Boolean.FALSE;
		ArrayList<Autor> existAutores = new ArrayList<>();
		if (!autores.getAutores().isEmpty()) {
			for(VisualizarNomeDTO autor: autores.getAutores()) {
				Autor exist = repository.findByNome(autor.getNome());
				if (exist != null) {
					existAutores.add(exist);
				}
			}		
		}
				try {
					if (existAutores.size() == autores.getAutores().size() && autores.getAutores().size() != 0) {
						isValid = Boolean.TRUE; 
					} 
					
				} catch (Exception e) {
					// Continua retornando false
				}
				
		return isValid;
	}
}