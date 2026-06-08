package dev.Client.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "turista", schema = "turista")
public class TuristaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idturista")
    private Long id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "datanascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "login", nullable = false, unique = true, length = 100)
    private String login;

    @Column(name = "senha", nullable = false, length = 255)
    private String senha;

    @Column(name = "datacriacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "turista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VisitacoesEntityByTurista> visitacoes;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
    }
}
