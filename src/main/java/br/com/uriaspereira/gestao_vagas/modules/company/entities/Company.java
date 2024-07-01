package br.com.uriaspereira.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "companies")
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank
  @Pattern(regexp = "^(?!\\s*$).+", message = "O campo [username] não deve conter espaços")
  private String username;

  @Email(message = "O campo [email] deve ter um e-mail válido")
  private String email;

  @Length(min = 10, max = 100)
  private String password;

  private String website;
  private String name;
  private String description;
  @CreationTimestamp
  private LocalDateTime createdAt;

  public Company() {
    super();
  }

  public Company(
      String username,
      String email,
      String password,
      String website,
      String name,
      String description
  ) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.website = website;
    this.name = name;
    this.description = description;
  }
  
}
