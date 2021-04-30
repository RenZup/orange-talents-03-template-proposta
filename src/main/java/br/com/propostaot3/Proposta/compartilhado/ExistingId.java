package br.com.propostaot3.Proposta.compartilhado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ExistingIdValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistingId {

		String message() default "Id inexistente";
		
		Class<?>[] groups() default {};
		
		Class<? extends Payload>[] payload() default {};
		
		String fieldName();
		
		Class<?> domainClass();

}
