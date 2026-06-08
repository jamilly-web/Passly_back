package dev.Instituicao.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "localturistico", schema = "passly")
public class LocalTuristicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "publickey", nullable = false, unique = true)
    private UUID codigoNucleo;

    @Column(name = "longitude", nullable = false, precision = 9, scale = 6)
    private BigDecimal longitude;

    @Column(name = "latitude", nullable = false, precision = 9, scale = 6)
    private BigDecimal latitude;

    @Column(name = "datacriacao", nullable = false, updatable = false)
    private LocalDate dataCriacao;

    @Column(name = "nucleonome", length = 200)
    private String nucleoNome;

    @ManyToOne
    @JoinColumn(name = "idadm", nullable = false)
    private OperadoraTuristicaEntity operadoraTuristica;

    @OneToMany(mappedBy = "localTuristico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VisitacaoEntity> visitacoes;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDate.now();
    }
}