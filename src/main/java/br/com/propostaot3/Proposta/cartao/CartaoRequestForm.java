package br.com.propostaot3.Proposta.cartao;

import br.com.propostaot3.Proposta.compartilhado.ExistingId;
import br.com.propostaot3.Proposta.proposta.Proposta;

import javax.validation.constraints.NotNull;

public class CartaoRequestForm {

    @ExistingId(domainClass = Proposta.class,fieldName = "id")
    @NotNull
    private Long idProposta;

    public CartaoRequestForm(@NotNull Long idProposta) {
        this.idProposta = idProposta;
    }

    public CartaoRequestForm() {
    }

    public Long getIdProposta() {
        return idProposta;
    }

}
