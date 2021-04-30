package br.com.propostaot3.Proposta.cartao.consultaCartao;

public class ConsultaCartaoRequest {
     private String idProposta;

    public String getIdProposta() {
        return idProposta;
    }

    public ConsultaCartaoRequest(String idProposta) {
        this.idProposta = idProposta;
    }
}
