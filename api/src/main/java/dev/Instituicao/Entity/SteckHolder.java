package dev.Instituicao.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
class SteckHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String NomeUser;
    private String NomeInstituicao;
    private String Cnpj;
    private String Senha;
    private String Login;
    private LocalDate DataCriacao;

    @OneToMany(mappedBy = "stack-holder")
    private List<Nucleo> PolosVisitacoes;
    
}