package dev.Client.Entity;

import java.time.LocalDate;
import lombok.Data;

@Data
public class VisitacoesEntity {
    private long id;
    private String codigoLugar;
    private boolean isFavorito;
    private int avaliacaoClient;
    private LocalDate dataCheckIn;
    private String nomeLocal;
    private String latitude;
    private String longitude;
}
