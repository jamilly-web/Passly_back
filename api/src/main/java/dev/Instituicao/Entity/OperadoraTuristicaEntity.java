package dev.Instituicao.Entity;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import lombok.Data;
// ENTITY OPERADORA TURISTICA
public class OperadoraTuristicaEntity {

    private long id;

    private String NomeUser;
    private String NomeInstituicao;
    private String Cnpj;
    private String Senha;
    private String Login;
    private LocalDate DataCriacao;
    private List<LocalTuristicoEntity> PolosVisitacoes;

    
}
