package dev.Instituicao.Entity;

import java.time.LocalDate;
import java.util.List;


class OperadoraTuristicaEntity {

    private long id;

    private String NomeUser;
    private String NomeInstituicao;
    private String Cnpj;
    private String Senha;
    private String Login;
    private LocalDate DataCriacao;

    
    private List<LocalTuristicoEntity> PolosVisitacoes;
    
}