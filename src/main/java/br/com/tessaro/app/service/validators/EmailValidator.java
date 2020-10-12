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
		Autor exist = null;
		exist = repository.findByEmail(email.getEmail());
		
		
				try {
					
					if(email.getEmail() == null) {
						isValid = Boolean.TRUE; 
					}
					
					else if (exist == null) {
						isValid = Boolean.TRUE; 
					} 
					
					if (exist != null && exist.getNome().equals(email.getNome())) {
						isValid = Boolean.TRUE; 
						}
					
					if (email.getEmail().isBlank()) {
						isValid = Boolean.TRUE; 
						}
					
				} catch (Exception e) {
					// Continua retornando false
				}

		return isValid;
	}
}