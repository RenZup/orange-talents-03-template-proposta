package br.com.propostaot3.Proposta.cartao;

import br.com.propostaot3.Proposta.proposta.Proposta;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private @NotNull LocalDate emitidoEm;
    @Column(nullable = false)
    private @NotNull @NotBlank String titular;
    @OneToOne(cascade = CascadeType.ALL)
    private Proposta proposta;
    @Column(nullable = false, unique = true)
    private @NotBlank @Valid String numeroCartao;

    @Deprecated
    public Cartao() {
    }

    public Cartao(@NotNull LocalDate emitidoEm, @NotNull @NotBlank String titular, @NotBlank @Valid String numeroCartao) {
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.numeroCartao = numeroCartao;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getEmitidoEm() {
        return emitidoEm;
    }

    public String getTitular() {
        return titular;
    }

    public Proposta getProposta() {
        return proposta;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setProposta(Proposta proposta) {
        this.proposta = proposta;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "id=" + id +
                ", emitidoEm=" + emitidoEm +
                ", titular='" + titular + '\'' +
                ", proposta=" + proposta +
                ", numeroCartao='" + numeroCartao + '\'' +
                '}';
    }



}
