package dev.Instituicao.Entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Nucleo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String CodigoNucleo;
    private String Longitude;
    private String Latitude;
    private LocalDate DataCriacao;
    private String NucleoNome;

    @ManyToOne
    @JoinColumn(name ="stack-holder-id")
    private SteckHolder steckHolder;

    @OneToMany(mappedBy = "nucleo")

    private List<Visitacao> Visitacoes;
}
