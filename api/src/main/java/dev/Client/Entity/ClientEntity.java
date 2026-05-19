package dev.Client.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String email;
    private LocalDate dataCriacao;
    private String cep;
    private String senha;
    private String telefone;
    private String cpf;

    
    @OneToMany(mappedBy = "client")
    private List<Visitacoes> visitacoesList; 
}
