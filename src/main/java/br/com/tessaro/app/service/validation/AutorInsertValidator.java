package br.com.tessaro.app.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.tessaro.app.controller.exceptions.FieldMessage;
import br.com.tessaro.app.model.Autor;

public class AutorInsertValidator implements ConstraintValidator<AutorInsert, Autor> {
	@Override
	public void initialize(AutorInsert ann) {
	}

	@Override
	public boolean isValid(Autor objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		// inclua os testes aqui, inserindo erros na lista

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

		
}