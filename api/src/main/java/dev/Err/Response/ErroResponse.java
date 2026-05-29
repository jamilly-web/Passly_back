package dev.Err.Response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class ErroResponse {
    private int status;
    private String mensagem;
    private LocalDateTime timestamp = LocalDateTime.now();

    public ErroResponse(int status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
        this.timestamp = LocalDateTime.now();
    }
}