package br.com.propostaot3.Proposta.cartao;

import br.com.propostaot3.Proposta.cartao.consultaCartao.ConsultaCartao;
import br.com.propostaot3.Proposta.cartao.consultaCartao.ConsultaCartaoResponse;
import br.com.propostaot3.Proposta.proposta.Proposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class ConsultaCartaoPeriodicamente {

    @PersistenceContext
    EntityManager em;

    @Autowired
    ConsultaCartao consultaCartao;

    @Autowired
    CartaoController controller;

    @Scheduled(fixedDelay = 30000)
    public void consulta(){
        TypedQuery<Proposta> query = em.createQuery("select p from Proposta p where cartao = null", Proposta.class);
        List<Proposta> resultList = query.getResultList();

        for (Proposta p :
                resultList) {
            ConsultaCartaoResponse response = consultaCartao.consultar(new CartaoRequestForm());
            controller.criar(new CartaoRequestForm(p.getId()), UriComponentsBuilder.newInstance());
        }

        System.out.println(resultList.toString());

    }
}
