package br.com.tessaro.app.service.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.tessaro.app.dto.autor.CadastrarAutorDTO;
import br.com.tessaro.app.model.Pais;
import br.com.tessaro.app.repository.PaisRepository;
import br.com.tessaro.app.service.annotations.PaisValido;

public class PaisValidator implements ConstraintValidator<PaisValido, CadastrarAutorDTO> {
	
	@Autowired 
	private PaisRepository repository;
	
	@Override
	public void initialize(PaisValido a) {
 	}
	
	@Override
	public boolean isValid(CadastrarAutorDTO autorDTO, ConstraintValidatorContext cvc) {
		boolean isValid = Boolean.FALSE;
			Pais exist = repository.findByNome(autorDTO.getPais());
			try {
				if (exist != null){
					isValid = Boolean.TRUE;
				} 
					
			} catch (Exception e) {
				// Continua retornando false
			}
		return isValid;
	}

}