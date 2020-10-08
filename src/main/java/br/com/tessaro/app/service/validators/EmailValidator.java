package br.com.tessaro.app.service.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.tessaro.app.dto.autor.CadastrarAutorDTO;
import br.com.tessaro.app.model.Autor;
import br.com.tessaro.app.repository.AutorRepository;
import br.com.tessaro.app.service.annotations.EmailValido;

public class EmailValidator implements ConstraintValidator<EmailValido, CadastrarAutorDTO> {
	
	@Autowired 
	private AutorRepository repository;
	
	@Override
	public void initialize(EmailValido a) {
 	}

	@Override
	public boolean isValid(CadastrarAutorDTO email, ConstraintValidatorContext cvc) {
		boolean isValid = Boolean.FALSE;
		Autor exist = repository.findByEmail(email.getEmail());
				try {
					if (exist == null) {
						isValid = Boolean.TRUE; 
					}
				} catch (Exception e) {
					// Continua retornando false
				}
		return isValid;
	}
}