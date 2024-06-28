package br.com.uriaspereira.gestao_vagas.modules.candidate;

import lombok.Data;

import java.util.UUID;

@Data
public class Candidate {

    private UUID id;
    private String name;
    private String username;
    private String email;
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
