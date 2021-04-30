package br.com.propostaot3.Proposta.cartao.consultaCartao;

import br.com.propostaot3.Proposta.cartao.CartaoRequestForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "consultaCartao",url = "http://localhost:8888/api/cartoes")
public interface ConsultaCartao {
    @GetMapping
    ConsultaCartaoResponse consultar(@RequestBody CartaoRequestForm request);
}
