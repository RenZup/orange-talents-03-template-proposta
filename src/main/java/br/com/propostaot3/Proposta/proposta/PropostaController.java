package br.com.propostaot3.Proposta.proposta;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/propostas")
public class PropostaController {

    @Autowired
    PropostaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criar(@RequestBody @Valid PropostaRequestForm form, UriComponentsBuilder uriBuilder){
        if(repository.existsByDocumento(form.getDocumento())){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Erro: Já existe uma proposta com o documento " + form.getDocumento());
        }

        Proposta proposta = form.toModel();
        repository.save(proposta);

        PropostaResponseDto dto = new PropostaResponseDto(proposta);

        URI uri= uriBuilder.path("/propostas/{id}").buildAndExpand(proposta.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
