package br.com.uriaspereira.gestao_vagas.modules.company.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uriaspereira.gestao_vagas.modules.company.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, UUID>{
   Optional<Company> findByUsernameOrEmail(String username, String email);
   Optional<Company> findByUserName(String username);
}
