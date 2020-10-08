package br.com.tessaro.app.service.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.apache.commons.lang.StringUtils;

import br.com.tessaro.app.service.validators.CpfValidator;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CpfValidator.class})
public @interface CpfValido {
	
	String message() default "CPF deve estar no seguinte formato: '11122233344'. Para brasileiro o CPF é obrigatorio. Estrangeiro deve deixar o campo CPF em branco. O Cpf não pode ser um ja existente.";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
    
    String cpf() default StringUtils.EMPTY;

}
