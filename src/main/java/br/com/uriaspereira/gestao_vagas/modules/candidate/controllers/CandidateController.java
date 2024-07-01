package br.com.uriaspereira.gestao_vagas.modules.candidate.controllers;

import br.com.uriaspereira.gestao_vagas.modules.candidate.Candidate;
import br.com.uriaspereira.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/")
    public Candidate create(@Valid @RequestBody Candidate candidateEntity) {
        return this.candidateRepository.save(candidateEntity);
    }
}
