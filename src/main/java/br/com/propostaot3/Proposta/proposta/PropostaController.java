package br.com.propostaot3.Proposta.proposta;

import br.com.propostaot3.Proposta.statusProposta.StatusProposta;
import br.com.propostaot3.Proposta.statusProposta.StatusPropostaRequest;
import br.com.propostaot3.Proposta.statusProposta.StatusPropostaResponse;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

    @Autowired
    PropostaRepository repository;

    @Autowired
    StatusProposta statusProposta;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criar(@RequestBody @Valid PropostaRequestForm form, UriComponentsBuilder uriBuilder){
        if(repository.existsByDocumento(form.getDocumento())){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Erro: Já existe uma proposta com o documento " + form.getDocumento());
        }

        Proposta proposta = form.toModel();
        repository.save(proposta);

        Status statusAvaliado = verificarStatus(proposta);
        proposta.setStatus(statusAvaliado);
        PropostaResponseDto dto = new PropostaResponseDto(proposta);
        URI uri= uriBuilder.path("/propostas/{id}").buildAndExpand(proposta.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropostaResponseDto> listarPorId(@PathVariable Long id){
        Optional<Proposta> proposta = repository.findById(id);
        if(proposta.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        PropostaResponseDto dto = new PropostaResponseDto(proposta.get());
        dto.setStatus(proposta.get().getStatus());
        return ResponseEntity.ok().body(dto);
    }


    private Status verificarStatus(Proposta proposta) {
        try {
            StatusPropostaResponse response = statusProposta.consultar(new StatusPropostaRequest(proposta));
            return Status.definirStatusPorRestricao(response.getResultadoSolicitacao());
        }catch (FeignException.UnprocessableEntity e){
            return Status.NAO_ELEGIVEL;
        }
    }
}
