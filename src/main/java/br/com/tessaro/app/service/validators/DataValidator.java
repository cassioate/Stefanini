package br.com.tessaro.app.service.validators;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.tessaro.app.dto.autor.CadastrarAutorDTO;
import br.com.tessaro.app.service.annotations.DataValido;
import br.com.tessaro.app.service.util.TimeUtil;

public class DataValidator implements ConstraintValidator<DataValido, CadastrarAutorDTO> {
	
	@Override
	public void initialize(DataValido a) {
 	}

	@Override
	public boolean isValid(CadastrarAutorDTO autorDTO, ConstraintValidatorContext cvc) {
		boolean isValid = Boolean.FALSE;
		LocalDate dataAutor = TimeUtil.toLocalDate(autorDTO.getDataNascimento());
				try {
					if (dataAutor.isBefore(LocalDate.now())){
						isValid = Boolean.TRUE;
					} 
						
				} catch (Exception e) {
					// Continua retornando false
				}
		return isValid;
	}


}