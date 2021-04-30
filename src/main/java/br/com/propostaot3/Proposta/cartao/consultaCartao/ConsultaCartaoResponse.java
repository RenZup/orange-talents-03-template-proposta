package br.com.propostaot3.Proposta.cartao.consultaCartao;

import br.com.propostaot3.Proposta.cartao.Cartao;
import br.com.propostaot3.Proposta.proposta.Proposta;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class ConsultaCartaoResponse {
    private  String id ;
    private LocalDate emitidoEm;
    private String titular;
    private String idProposta;

    public String getId() {
        return id;
    }

    public LocalDate getEmitidoEm() {
        return emitidoEm;
    }

    public String getTitular() {
        return titular;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public Cartao toModel(EntityManager em){
        Assert.notNull(idProposta,"IdProposta nao deve ser nulo");

        String docTitular = em.find(Proposta.class,Long.decode(idProposta)).getDocumento();
        Cartao cartao = new Cartao(emitidoEm,docTitular,id);
        cartao.setProposta(em.find(Proposta.class,Long.decode(idProposta)));


        return cartao;
    }

    @Override
    public String toString() {
        return "ConsultaCartaoResponse{" +
                "id='" + id + '\'' +
                ", emitidoEm=" + emitidoEm +
                ", titular='" + titular + '\'' +
                ", idProposta='" + idProposta + '\'' +
                '}';
    }
}
