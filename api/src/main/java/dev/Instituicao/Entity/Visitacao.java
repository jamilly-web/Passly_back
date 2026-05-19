package dev.Instituicao.Entity;

import java.time.LocalDate;

import org.springframework.cglib.core.Local;

import jakarta.persistence.Entity;

@Entity
public class Visitacao {
    private LocalDate DataVisita;
    private int NotaVisitacao;
    
}
