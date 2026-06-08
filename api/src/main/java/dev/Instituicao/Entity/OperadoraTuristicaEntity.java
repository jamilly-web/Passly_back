package dev.Instituicao.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "operadoraturistica", schema = "passly")
public class OperadoraTuristicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idadm")
    private Long id;

    @Column(name = "nomefunc", nullable = false, length = 100)
    private String nomeUser;

    @Column(name = "nomeinstituicao", nullable = false, length = 150)
    private String nomeInstituicao;

    @Column(name = "cnpj", nullable = false, unique = true, length = 18)
    private String cnpj;

    @Column(name = "senha", nullable = false, length = 255)
    private String senha;

    @Column(name = "login", nullable = false, unique = true, length = 100)
    private String login;

    @Column(name = "datacriacao", nullable = false, updatable = false)
    private LocalDate dataCriacao;

    @OneToMany(mappedBy = "operadoraTuristica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LocalTuristicoEntity> polosVisitacoes;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDate.now();
    }
}