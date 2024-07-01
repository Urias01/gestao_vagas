package br.com.uriaspereira.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uriaspereira.gestao_vagas.modules.company.entities.Job;
import br.com.uriaspereira.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {

  @Autowired
  private JobRepository jobRepository;
  
  public Job execute(Job jobEntity) {
    return this.jobRepository.save(jobEntity);
  }
}
