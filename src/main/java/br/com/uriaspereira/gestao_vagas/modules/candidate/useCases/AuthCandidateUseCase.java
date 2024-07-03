package br.com.uriaspereira.gestao_vagas.modules.candidate.useCases;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.uriaspereira.gestao_vagas.modules.candidate.dto.AuthCandidateRequestDTO;
import br.com.uriaspereira.gestao_vagas.modules.candidate.dto.AuthCandidateResponseDTO;
import br.com.uriaspereira.gestao_vagas.modules.candidate.repositories.CandidateRepository;

@Service
public class AuthCandidateUseCase {

  @Value("${security.token.secret.candidate}")
  private String secretKey;
  
  @Autowired
  private CandidateRepository candidateRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public AuthCandidateResponseDTO execute(
      AuthCandidateRequestDTO authCandidateDTO
    ) throws AuthenticationException {

    var candidate = this.candidateRepository.findByUsername(authCandidateDTO.username())
      .orElseThrow(() -> {
        throw new UsernameNotFoundException("Username/password incorrect");
      });

    var passwordMatches = passwordEncoder
      .matches(authCandidateDTO.password(), candidate.getPassword());

     if (!passwordMatches) {
      throw new AuthenticationException();
    }

    Algorithm algorithm = Algorithm.HMAC256(secretKey);

    String token = JWT.create()
      .withIssuer("javagas")
      .withExpiresAt(Instant.now().plus(Duration.ofMinutes(10)))
      .withClaim("roles", Arrays.asList("candidate"))
      .withSubject(candidate.getId().toString())
      .sign(algorithm);

    var authCandidateResponse = AuthCandidateResponseDTO.builder()
      .access_token(token)
      .build();

      return authCandidateResponse;
  }
}
