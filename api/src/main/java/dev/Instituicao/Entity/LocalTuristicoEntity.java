package dev.Instituicao.Entity;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;


@Data
public class LocalTuristicoEntity {
    
    //GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String CodigoNucleo;
    private String Longitude;
    private String Latitude;
    private LocalDate DataCriacao;
    private String NucleoNome;

    private List<VisitacaoEntity> Visitacoes;
}
