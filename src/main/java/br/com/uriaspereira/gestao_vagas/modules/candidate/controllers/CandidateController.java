package br.com.uriaspereira.gestao_vagas.modules.candidate.controllers;

import br.com.uriaspereira.gestao_vagas.modules.candidate.Candidate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping("/")
    public void create(@RequestBody Candidate candidate) {
        System.out.println("Candidato");
        System.out.println(candidate.getEmail());
    }
}
