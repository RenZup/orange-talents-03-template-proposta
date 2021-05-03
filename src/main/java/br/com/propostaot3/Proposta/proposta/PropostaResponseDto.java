package br.com.propostaot3.Proposta.proposta;

import java.math.BigDecimal;

public class PropostaResponseDto {
    private final Long id;
    private final String documento;
    private final String email;
    private final String nome;
    private final String endereco;
    private final BigDecimal salario;
    private Status status = Status.NAO_AVALIADO;

    public PropostaResponseDto(Proposta proposta) {
        this.id = proposta.getId();
        this.documento = proposta.getDocumento();
        this.email= proposta.getEmail();
        this.nome= proposta.getNome();
        this.endereco= proposta.getEndereco();
        this.salario=proposta.getSalario();
    }

    public Long getId() {
        return id;
    }

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

    public Status getStatus() {   return status;    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
