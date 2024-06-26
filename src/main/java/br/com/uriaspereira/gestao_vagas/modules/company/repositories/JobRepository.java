package br.com.uriaspereira.gestao_vagas.modules.company.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uriaspereira.gestao_vagas.modules.company.entities.Job;

public interface JobRepository extends JpaRepository<Job, UUID>{
  
}
