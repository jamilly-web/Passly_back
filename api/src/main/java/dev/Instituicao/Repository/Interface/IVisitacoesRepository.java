package dev.Instituicao.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.Instituicao.Entity.VisitacaoEntity;

public interface IVisitacoesRepository extends JpaRepository<VisitacaoEntity, Long>{
    
}
