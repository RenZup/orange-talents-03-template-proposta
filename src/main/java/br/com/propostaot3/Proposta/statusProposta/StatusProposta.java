package br.com.propostaot3.Proposta.statusProposta;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "statusProposta",url ="http://localhost:9999/api/solicitacao")
public interface StatusProposta {

    @PostMapping
    StatusPropostaResponse consultar(@RequestBody StatusPropostaRequest request);
}
