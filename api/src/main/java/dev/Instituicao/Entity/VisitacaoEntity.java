package dev.Instituicao.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visitacao", schema = "passly")
public class VisitacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvisita")
    private Long id;

    @Column(name = "datavisita", nullable = false)
    private LocalDate dataVisita;

    @Column(name = "notaavaliacao", nullable = false)
    private Short notaVisitacao;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private LocalTuristicoEntity localTuristico;

    @PrePersist
    public void prePersist() {
        this.dataVisita = LocalDate.now();
    }
}