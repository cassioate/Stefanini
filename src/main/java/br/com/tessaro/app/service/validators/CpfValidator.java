package br.com.tessaro.app.service.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.tessaro.app.dto.autor.CadastrarAutorDTO;
import br.com.tessaro.app.service.annotations.CpfValido;
import br.com.tessaro.app.service.util.CpfUtil;

public class CpfValidator implements ConstraintValidator<CpfValido, CadastrarAutorDTO> {
	
	@Override
	public void initialize(CpfValido a) {
 	}

	@Override
	public boolean isValid(CadastrarAutorDTO autorDTO, ConstraintValidatorContext cvc) {
		boolean isValid = Boolean.FALSE;
				try {
					if (!autorDTO.getPais().equalsIgnoreCase("Brasil") && autorDTO.getCpf().isBlank()){
						isValid = Boolean.TRUE;
					} 
					else if (autorDTO.getPais().equalsIgnoreCase("Brasil") 
							&& !autorDTO.getCpf().isBlank() 
							&& CpfUtil.validarRegraCpf(autorDTO.getCpf())
							&& autorDTO.getCpf().length() == 11
							) {
						
						isValid = Boolean.TRUE;
					} 
						
				} catch (Exception e) {
					// Continua retornando false
				}
		return isValid;
	}

}