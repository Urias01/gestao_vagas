package br.com.uriaspereira.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uriaspereira.gestao_vagas.exceptions.UserFoundException;
import br.com.uriaspereira.gestao_vagas.modules.candidate.Candidate;
import br.com.uriaspereira.gestao_vagas.modules.candidate.repositories.CandidateRepository;

@Service
public class CreateCandidateUseCase {
  @Autowired
  private CandidateRepository candidateRepository;

  public Candidate execute(Candidate candidateEntity) {
    this.candidateRepository.findByUsernameOrEmail(
        candidateEntity.getUsername(), candidateEntity.getEmail()
    ).ifPresent((user) -> {
        throw new UserFoundException();
    });

    return this.candidateRepository.save(candidateEntity);
  }
}
