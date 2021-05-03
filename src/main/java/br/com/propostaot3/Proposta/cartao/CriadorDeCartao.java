 package br.com.propostaot3.Proposta.cartao;

 import br.com.propostaot3.Proposta.cartao.consultaCartao.ConsultaCartao;
 import br.com.propostaot3.Proposta.cartao.consultaCartao.ConsultaCartaoResponse;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.stereotype.Service;
 import org.springframework.util.Assert;
 import org.springframework.web.server.ResponseStatusException;

 import javax.persistence.EntityManager;
 import javax.persistence.PersistenceContext;
 import javax.transaction.Transactional;

 @Service
 public class CriadorDeCartao {

    @PersistenceContext
    private EntityManager em;

     @Autowired
     private ConsultaCartao consultaCartao;

     @Transactional
    public Cartao criaCartao(Long idProposta){
        ConsultaCartaoResponse cartaoResponse = consultaCartao.consultar(new CartaoRequestForm(idProposta));
        System.out.println(cartaoResponse.toString());

        Cartao cartao = cartaoResponse.toModel(em);

        Assert.notNull(cartao.getProposta(),"Proposta nao deveria ser nula");

        if(cartao.getProposta().getCartao() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        em.persist(cartao);
        em.merge(cartao.getProposta());
        cartao.getProposta().setCartao(cartao);

        return cartao;
    }
}