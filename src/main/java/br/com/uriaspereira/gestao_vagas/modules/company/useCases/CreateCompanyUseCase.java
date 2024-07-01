package br.com.uriaspereira.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uriaspereira.gestao_vagas.exceptions.UserFoundException;
import br.com.uriaspereira.gestao_vagas.modules.company.entities.Company;
import br.com.uriaspereira.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {
  
  @Autowired
  private CompanyRepository companyRepository;

  public Company execute(Company companyEntity) {
    this.companyRepository.findByUsernameOrEmail(
      companyEntity.getUsername(), companyEntity.getEmail()
    ).ifPresent((company) -> {
      throw new UserFoundException();
    });

    return this.companyRepository.save(companyEntity);
  }
}
