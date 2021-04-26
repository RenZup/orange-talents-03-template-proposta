package br.com.propostaot3.Proposta.compartilhado;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {CpfOuCnpjValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfOuCnpj {

    String message() default "CPF ou CNPJ invalido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}