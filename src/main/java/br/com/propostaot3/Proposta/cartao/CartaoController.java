package br.com.propostaot3.Proposta.cartao;

import br.com.propostaot3.Proposta.cartao.consultaCartao.ConsultaCartao;
import br.com.propostaot3.Proposta.cartao.consultaCartao.ConsultaCartaoResponse;
import br.com.propostaot3.Proposta.erros.ErrorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @PersistenceContext
    EntityManager em;

    @Autowired
    ConsultaCartao consultaCartao;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criar(@RequestBody @Valid CartaoRequestForm form, UriComponentsBuilder uriBuilder){
        ConsultaCartaoResponse cartaoResponse = consultaCartao.consultar(form);
        System.out.println(cartaoResponse.toString());

        Cartao cartao = cartaoResponse.toModel(em);

        Assert.notNull(cartao.getProposta(),"Proposta nao deveria ser nula");

        em.persist(cartao);

        if(cartao.getProposta().getCartao() != null){
            return ResponseEntity.badRequest().body(new ErrorDto("idProposta", "Proposta já possui um cartao associado"));
        }
        em.merge(cartao.getProposta());
        cartao.getProposta().setCartao(cartao);


        CartaoResponseDto dto = new CartaoResponseDto(cartao);
        URI uri = uriBuilder.path("/cartoes/{id}").buildAndExpand(cartao.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

}
