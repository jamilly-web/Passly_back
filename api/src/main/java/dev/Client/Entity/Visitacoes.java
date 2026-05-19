package dev.Client.Entity;
import java.sql.Date;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Visitacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codigoLugar;
    private boolean isFavorito;
    private int avaliacaoClient;
    private LocalDate dataCheckIn;
    private String nomeLocal;
    private String latitude;
    private String longitude;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private  ClientEntity client;
}
