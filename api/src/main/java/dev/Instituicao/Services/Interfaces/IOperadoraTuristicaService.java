package dev.Instituicao.Services.Interfaces;

import dev.Instituicao.Entity.OperadoraTuristicaEntity;

public interface IOperadoraTuristicaService {
    public String CreateOperadoraTuristica(OperadoraTuristicaEntity POperadoraTuristica);
    public OperadoraTuristicaEntity ReadOperadoraTuristicaByLogin(String Login);
    public String UpdateOperadoraTuristicaById(OperadoraTuristicaEntity POperadoraTuristica, Long PId);
    public String DeleteOperadoraTuristicaById(Long PId);
}
