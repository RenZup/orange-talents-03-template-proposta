package br.com.propostaot3.Proposta.cartao;

import br.com.propostaot3.Proposta.compartilhado.UniqueValue;
import br.com.propostaot3.Proposta.proposta.Proposta;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class CartaoResponseDto {

    private  Long id ;
    private String numeroCartao;
    private @NotNull LocalDate emitidoEm;
    private @NotNull @NotBlank String titular;
    private Long idProposta;


    public CartaoResponseDto(Cartao cartao) {
        this.id = cartao.getId();
        this.numeroCartao= cartao.getNumeroCartao();
        this.titular= cartao.getTitular();
        this.emitidoEm=cartao.getEmitidoEm();
        if(cartao.getProposta() != null)
            this.idProposta=cartao.getProposta().getId();
    }

    public Long getId() {
        return id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public LocalDate getEmitidoEm() {
        return emitidoEm;
    }

    public String getTitular() {
        return titular;
    }

    public Long getIdProposta() {
        return idProposta;
    }

}
