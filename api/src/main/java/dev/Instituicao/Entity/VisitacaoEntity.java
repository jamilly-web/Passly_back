package dev.Instituicao.Entity;

import java.time.LocalDate;
import lombok.Data;

@Data
public class VisitacaoEntity {
    private LocalDate dataVisita;
    private int notaVisitacao;
}
