package br.com.uriaspereira.gestao_vagas.modules.company.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uriaspereira.gestao_vagas.modules.company.dto.CreateJobDTO;
import br.com.uriaspereira.gestao_vagas.modules.company.entities.Job;
import br.com.uriaspereira.gestao_vagas.modules.company.useCases.CreateJobUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/jobs")
public class JobController {
  
  @Autowired
  private CreateJobUseCase createJobUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> createJob(
      @Valid @RequestBody CreateJobDTO jobEntity,
      HttpServletRequest request
    ) {
      var companyId = request.getAttribute("company_id");

      Job job = Job.builder()
        .benefits(jobEntity.getBenefits())
        .companyId(UUID.fromString(companyId.toString()))
        .description(jobEntity.getDescription())
        .level(jobEntity.getLevel())
        .build();

      this.createJobUseCase.execute(job);

      return ResponseEntity.ok().body(job);
  }
  
}
