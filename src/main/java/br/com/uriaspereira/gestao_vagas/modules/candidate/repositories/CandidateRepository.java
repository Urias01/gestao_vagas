package br.com.uriaspereira.gestao_vagas.modules.candidate.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.uriaspereira.gestao_vagas.modules.candidate.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, UUID> {
  Optional<Candidate> findByUsernameOrEmail(String username, String email);
  Optional<Candidate> findByUsername(String username);
}
