package br.com.propostaot3.Proposta.statusProposta;

import br.com.propostaot3.Proposta.proposta.Proposta;

public class StatusPropostaRequest {
    private String documento;
    private String nome;
    private Long idProposta;

    public StatusPropostaRequest(Proposta proposta) {
        this.documento = proposta.getDocumento();
        this.nome = proposta.getNome();
        this.idProposta = proposta.getId();
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdProposta() {
        return idProposta;
    }
}

