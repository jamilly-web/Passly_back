package dev.Instituicao.Services.Interfaces;

import dev.Instituicao.Entity.OperadoraTuristicaEntity;

public interface IOperadoraTuristicaService {
    public String CreateOperadoraTuristica(OperadoraTuristicaEntity POperadoraTuristica);
    public OperadoraTuristicaEntity ReadOperadoraTuristicaById(String PId);
    public String UpdateOperadoraTuristicaById(OperadoraTuristicaEntity POperadoraTuristica, String PId);
    public String DeleteOperadoraTuristicaById(String PId);
}
