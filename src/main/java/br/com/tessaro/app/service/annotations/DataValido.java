package br.com.tessaro.app.service.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.apache.commons.lang.StringUtils;

import br.com.tessaro.app.service.validators.DataValidator;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DataValidator.class})
public @interface DataValido {
	
	String message() default "A data deve ser anterior a data atual!";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
    
    String cpf() default StringUtils.EMPTY;

}
