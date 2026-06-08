package dev.Client.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visitacao", schema = "turista")
public class VisitacoesEntityByTurista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvisita")
    private Long id;

    @Column(name = "datavisita", nullable = false)
    private LocalDateTime dataVisita;

    @Column(name = "notaavaliacao", nullable = false)
    private Short notaAvaliacao;

    @Column(name = "localvisitado", nullable = false, length = 200)
    private String localVisitado;

    @Column(name = "duracaovisita", nullable = false)
    private Duration duracaoVisita;

    @Column(name = "comentario", columnDefinition = "TEXT")
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "idturista", nullable = false)
    private TuristaEntity turista;

    @PrePersist
    public void prePersist() {
        this.dataVisita = LocalDateTime.now();
    }
}