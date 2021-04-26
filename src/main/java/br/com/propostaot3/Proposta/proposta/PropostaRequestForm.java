package br.com.propostaot3.Proposta.proposta;

import br.com.propostaot3.Proposta.compartilhado.CpfOuCnpj;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class PropostaRequestForm {
    @CpfOuCnpj @NotBlank
    private String documento;
    @Email(message = "Email invalido") @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @Positive @NotNull
    private BigDecimal salario;

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public Proposta toModel(){
        return new Proposta(documento,email,nome,endereco,salario);
    }

}
