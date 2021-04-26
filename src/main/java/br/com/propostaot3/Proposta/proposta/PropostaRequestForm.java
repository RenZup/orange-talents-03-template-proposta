package br.com.propostaot3.Proposta.proposta;

import br.com.propostaot3.Proposta.compartilhado.CpfOuCnpj;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class PropostaRequestForm {
    @CpfOuCnpj @NotBlank
    @Pattern(regexp = "^([0-9]{11}|[0-9]{14})$",message = "Digite um CPF ou CNPJ valido, sem caracteres especiais")
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
