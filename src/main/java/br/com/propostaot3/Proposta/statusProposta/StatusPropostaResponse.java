package br.com.propostaot3.Proposta.statusProposta;

public class StatusPropostaResponse {
    private String documento;
    private String nome;
    private Long idProposta;
    private String resultadoSolicitacao;

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdProposta() {
        return idProposta;
    }

    public String getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }
}
