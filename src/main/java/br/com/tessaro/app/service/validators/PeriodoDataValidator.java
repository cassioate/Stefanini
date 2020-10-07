package br.com.tessaro.app.service.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.util.Strings;

import br.com.tessaro.app.dto.obra.CadastrarEditarObraDTO;
import br.com.tessaro.app.service.annotations.PeriodoDataValido;

public class PeriodoDataValidator implements ConstraintValidator<PeriodoDataValido, CadastrarEditarObraDTO> {

	private String dataPublicacao;
	private String dataExposicao;
	
	@Override
	public void initialize(PeriodoDataValido a) {
		this.dataPublicacao = a.dataPublicacao();
		this.dataExposicao = a.dataExposicao();
 	}

	@Override
	public boolean isValid(CadastrarEditarObraDTO obraDTO, ConstraintValidatorContext cvc) {
		boolean isValid = Boolean.FALSE;

		final String dataPublicacaoValor;
		final String dataExposicaoValor;

		try {
			
			dataPublicacaoValor = BeanUtils.getProperty(obraDTO, this.dataPublicacao);
			dataExposicaoValor = BeanUtils.getProperty(obraDTO , this.dataExposicao);
			if(!Strings.isBlank(dataPublicacaoValor) || !Strings.isBlank(dataExposicaoValor)) {
				isValid = Boolean.TRUE;
			}
			
		} catch (Exception e) {
			// Continua retornando false
		}

		return isValid;
	}

}