package br.com.tessaro.app.service.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.apache.commons.lang.StringUtils;

import br.com.tessaro.app.service.validators.PaisValidator;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PaisValidator.class})
public @interface PaisValido {
	
	String message() default "O país deve existir e começar coma letra maiuscula";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
    
    String cpf() default StringUtils.EMPTY;

}
