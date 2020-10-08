package br.com.tessaro.app.service.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.tessaro.app.dto.autor.CadastrarAutorDTO;
import br.com.tessaro.app.model.Autor;
import br.com.tessaro.app.repository.AutorRepository;
import br.com.tessaro.app.service.annotations.CpfValido;
import br.com.tessaro.app.service.mapper.AutorMapper;
import br.com.tessaro.app.service.util.CpfUtil;

public class CpfValidator implements ConstraintValidator<CpfValido, CadastrarAutorDTO> {
	
	@Autowired 
	private AutorRepository repository;
	
	@Override
	public void initialize(CpfValido a) {
 	}

	@Override
	public boolean isValid(CadastrarAutorDTO autorDTO, ConstraintValidatorContext cvc) {
		boolean isValid = Boolean.FALSE;
			String formatado = AutorMapper.foramtarCpf(autorDTO.getCpf());
			Autor exist = repository.findByCpf(formatado);
				try {
					if (!autorDTO.getPais().equalsIgnoreCase("Brasil") && autorDTO.getCpf().isBlank()){
						isValid = Boolean.TRUE;
					} 
					else if (autorDTO.getPais().equalsIgnoreCase("Brasil") 
							&& !autorDTO.getCpf().isBlank() 
							&& exist == null
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