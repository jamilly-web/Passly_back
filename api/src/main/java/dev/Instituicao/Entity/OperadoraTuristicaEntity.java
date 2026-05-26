package dev.Instituicao.Entity;

import java.time.LocalDate;
import java.util.List;


public class OperadoraTuristicaEntity {

    private long id;

    private String NomeUser;
    private String NomeInstituicao;
    private String Cnpj;
    private String Senha;
    private String Login;
    private LocalDate DataCriacao;
    private List<LocalTuristicoEntity> PolosVisitacoes;

    public OperadoraTuristicaEntity(
        String _PnomeUser,
        String _PNomeInstituicao,
        String _PCnpj, 
        String _PSenha, 
        String _PLogin, 
        List<LocalTuristicoEntity> _PLocalTuristicoEntities
    ) {
        this.NomeUser =_PnomeUser;
        this.NomeInstituicao = _PNomeInstituicao;
        this.Cnpj = _PCnpj;
        this.Senha = _PSenha;
        this.Login = _PLogin;
        this.DataCriacao = LocalDate.now();
        this.PolosVisitacoes = _PLocalTuristicoEntities;
        
    }
    public String getNomeUser() {
        return NomeUser;
    }
    public String getNomeInstituicao() {
        return NomeInstituicao;
    }
    public String getCnpj() {
        return Cnpj;
    }
    public String getSenha() {
        return Senha;
    }
    public String getLogin() {
        return Login;
    }
    public LocalDate getDataCriacao() {
        return DataCriacao;
    }
    public List<LocalTuristicoEntity> getPolosVisitacoes() {
        return PolosVisitacoes;
    }
    public long getId() {
        return id;
    }

    
}