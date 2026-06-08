package dev.Instituicao.Repository.Interface;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.Instituicao.Entity.OperadoraTuristicaEntity;
import java.util.List;


public interface IOperadoraTuristicaRepository extends JpaRepository<OperadoraTuristicaEntity, Long>{
    // public boolean Save();
    // public boolean Update(String PId,OperadoraTuristicaEntity POperadoraTuristicaEntity);
    // public OperadoraTuristicaEntity Get(String PId);
    // public boolean Delete(String PId);
    Optional<OperadoraTuristicaEntity> findByLogin(String login);

}
