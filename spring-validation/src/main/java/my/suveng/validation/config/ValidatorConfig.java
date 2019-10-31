package my.suveng.validation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author suwenguang
 * @version 1.0.0
 **/
@Configuration
public class ValidatorConfig {

	@Bean
	public Validator validator(){
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		return validatorFactory.getValidator();
	}

}
