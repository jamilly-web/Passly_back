package dev.Client.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.Client.Entity.VisitacoesEntityByTurista;


public interface IVisitacoesRepositoryByTurist extends JpaRepository<VisitacoesEntityByTurista, Long> {

    
}