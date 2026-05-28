package dev.Instituicao.Repository.Interface;

import dev.Instituicao.Entity.OperadoraTuristicaEntity;

public interface IOperadoraTuristicaRepository {
    public boolean Save();
    public boolean Update(String PId,OperadoraTuristicaEntity POperadoraTuristicaEntity);
    public OperadoraTuristicaEntity Get(String PId);
    public boolean Delete(String PId);
}
