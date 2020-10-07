package br.com.tessaro.app.service.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.apache.commons.lang.StringUtils;

import br.com.tessaro.app.service.validators.PeriodoDataValidator;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PeriodoDataValidator.class})
public @interface PeriodoDataValido {
	
	String message() default "A data de publicação e a data de exposição não podem ser nulas ao mesmo tempo, devendo sempre uma ou outra ser informada.";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
    
    String dataExposicao() default StringUtils.EMPTY;
    
    String dataPublicacao() default StringUtils.EMPTY;

}
