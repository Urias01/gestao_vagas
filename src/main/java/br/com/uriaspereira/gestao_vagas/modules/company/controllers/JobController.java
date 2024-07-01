package br.com.uriaspereira.gestao_vagas.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uriaspereira.gestao_vagas.modules.company.entities.Job;
import br.com.uriaspereira.gestao_vagas.modules.company.useCases.CreateJobUseCase;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/jobs")
public class JobController {
  
  @Autowired
  private CreateJobUseCase createJobUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> createJob(@Valid @RequestBody Job jobEntity) {
    var job = this.createJobUseCase.execute(jobEntity);

    return ResponseEntity.ok().body(job);
  }
  
}
