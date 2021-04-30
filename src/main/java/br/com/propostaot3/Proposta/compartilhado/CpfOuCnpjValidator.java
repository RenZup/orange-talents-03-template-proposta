package br.com.propostaot3.Proposta.compartilhado;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfOuCnpjValidator implements ConstraintValidator<CpfOuCnpj, Object> {

    public void initialize() {

    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value == null){
            return false;
        }

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return (cpfValidator.isValid(value.toString(), context) || cnpjValidator.isValid(value.toString(), context));
    }




}