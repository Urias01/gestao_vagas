package br.com.uriaspereira.gestao_vagas.modules.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class Candidate {

    private UUID id;
    private String name;

    @Pattern(regexp = "^(?!\\s*$).+", message = "O campo [username] não deve conter espaços")
    private String username;

    @Email(message = "O campo [email] deve ter um e-mail válido")
    private String email;

    @Length(min = 10, max = 100)
    private String password;
    private String description;
    private String curriculum;

    public Candidate(
            String name,
            String username,
            String email,
            String password,
            String description,
            String curriculum
    ) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.description = description;
        this.curriculum = curriculum;
    }

}
