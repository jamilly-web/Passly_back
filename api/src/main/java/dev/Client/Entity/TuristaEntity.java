package dev.Client.Entity;

import java.util.List;

public class TuristaEntity {
    private long id;

    private String nome;
    private String email;
    private String dataCriacao;
    private String cep;
    private String senha;
    private String telefone;
    private String cpf;

    
    
    private List<VisitacoesEntity> visitacoesList; 
}
