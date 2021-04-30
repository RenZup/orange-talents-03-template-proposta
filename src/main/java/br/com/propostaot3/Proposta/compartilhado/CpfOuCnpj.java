package br.com.propostaot3.Proposta.compartilhado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CpfOuCnpjValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfOuCnpj {

    String message() default "CPF ou CNPJ invalido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}