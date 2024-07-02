package br.com.uriaspereira.gestao_vagas.modules.candidate.controllers;

import br.com.uriaspereira.gestao_vagas.modules.candidate.Candidate;
import br.com.uriaspereira.gestao_vagas.modules.candidate.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase candidateUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody Candidate candidateEntity) {
        try {
            var result = this.candidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
