package br.com.propostaot3.Proposta.cartao;

import br.com.propostaot3.Proposta.compartilhado.ExistingId;
import br.com.propostaot3.Proposta.compartilhado.UniqueValue;
import br.com.propostaot3.Proposta.erros.ErrorDto;
import br.com.propostaot3.Proposta.proposta.Proposta;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class CartaoRequestForm {
    @JsonFormat(pattern = "dd/MM/yyyy")
    private @NotNull LocalDate emitidoEm;
    private @NotNull @NotBlank String titular;
    @ExistingId(domainClass = Proposta.class,fieldName = "id")
    private Long idProposta;
    private @NotBlank @UniqueValue(domainClass = Cartao.class,fieldName = "numeroCartao")
            @Pattern(regexp = "^([0-9]{16})$", message = "Deve conter 16 numeros")
    String numeroCartao;

    public LocalDate getEmitidoEm() {
        return emitidoEm;
    }

    public String getTitular() {
        return titular;
    }


    public String getNumeroCartao() {
        return numeroCartao;
    }

    public Long getIdProposta() {
        return idProposta;
    }

    @Override
    public String toString() {
        return "CartaoRequestForm{" +
                "emitidoEm=" + emitidoEm +
                ", titular='" + titular + '\'' +
                ", idProposta=" + idProposta +
                ", numeroCartao='" + numeroCartao + '\'' +
                 +
                '}';
    }

}
