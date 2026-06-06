package dev.Client.Entity;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data

public class TuristaEntity {
    private long id;
    private String nome;
    private String email;
    private String dataCriacao;
    private String cep;
    private String senha;
    private String telefone;
    private String cpf;
    private String passaporte;
    private LocalDate dataNascimento;
    
    private List<VisitacoesEntity> historico = new ArrayList<>();

    public TuristaEntity() {
    }

    public TuristaEntity(String nome, String cpf, String email, String telefone, String passaporte, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.passaporte = passaporte;
        this.dataNascimento = dataNascimento;
    }
}
