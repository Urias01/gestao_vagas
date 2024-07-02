package br.com.uriaspereira.gestao_vagas.modules.company.useCases;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.uriaspereira.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import br.com.uriaspereira.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class AuthCompanyUseCase {

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public void execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {

    var company = companyRepository.findByUserName(authCompanyDTO.getUsername())
      .orElseThrow(() -> {
        throw new UsernameNotFoundException("Company not found");
      });

    // Verificar a senha
    var passwordMatches = passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());
      
    if (!passwordMatches) {
      throw new AuthenticationException();
    }
  }
  
}
