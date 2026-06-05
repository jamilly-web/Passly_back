import java.time.LocalDate;
import java.time.LocalDateTime;
import com.seu.pacote.model.Turista;    
import com.seu.pacote.model.Visitacao;  

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TuristaDTO {

    public static class Request {

        private String nome;
        private String cpf;
        private String email;
        private String telefone;
        private String passaporte;
        private LocalDate dataNascimento;

        public Request() {}

        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }

        public String getCpf() { return cpf; }
        public void setCpf(String cpf) { this.cpf = cpf; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getTelefone() { return telefone; }
        public void setTelefone(String telefone) { this.telefone = telefone; }

        public String getPassaporte() { return passaporte; }
        public void setPassaporte(String passaporte) { this.passaporte = passaporte; }

        public LocalDate getDataNascimento() { return dataNascimento; }
        public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    }

    public static class Response {

        private Long id;
        private String nome;
        private String cpf;
        private String email;
        private String telefone;
        private String passaporte;
        private LocalDate dataNascimento;

        public Response() {}

        public Response(Turista turista) {
            this.id             = turista.getId();
            this.nome           = turista.getNome();
            this.cpf            = turista.getCpf();
            this.email          = turista.getEmail();
            this.telefone       = turista.getTelefone();
            this.passaporte     = turista.getPassaporte();
            this.dataNascimento = turista.getDataNascimento();
        }

        public Long getId() { return id; }
        public String getNome() { return nome; }
        public String getCpf() { return cpf; }
        public String getEmail() { return email; }
        public String getTelefone() { return telefone; }
        public String getPassaporte() { return passaporte; }
        public LocalDate getDataNascimento() { return dataNascimento; }
    }

    public static class HistoricoResponse {

        private Long visitacaoId;
        private String localVisitado;
        private LocalDateTime dataVisita;

        public HistoricoResponse() {}

        public HistoricoResponse(Visitacao v) {
            this.visitacaoId   = v.getId();
            this.localVisitado = v.getLocalVisitado();
            this.dataVisita    = v.getDataVisita();
        }

        public Long getVisitacaoId() { return visitacaoId; }
        public String getLocalVisitado() { return localVisitado; }
        public LocalDateTime getDataVisita() { return dataVisita; }
    }
}