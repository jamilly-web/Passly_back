package dev.Instituicao.Err;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import dev.Instituicao.Err.Response.ErroResponse;



@RestControllerAdvice
public class GlobalExceptionHandler {

    // 405 — Method Not Allowed
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErroResponse> methodNotAllowed(HttpRequestMethodNotSupportedException ex) {
        return ResponseEntity
            .status(HttpStatus.METHOD_NOT_ALLOWED)
            .body(new ErroResponse(405,"Método não permitido: " + ex.getMethod()));
    }

    // 404 — Rota não encontrada
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErroResponse> notFound(NoResourceFoundException ex) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(new ErroResponse(404, "Rota não encontrada"));
    }

    // 500 — Qualquer outro erro inesperado
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> erroGeral(Exception ex) {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ErroResponse(500, "Erro interno: " + ex.getMessage()));
    }
}
