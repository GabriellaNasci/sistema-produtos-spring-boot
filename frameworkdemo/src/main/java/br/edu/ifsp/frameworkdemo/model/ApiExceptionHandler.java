package br.edu.ifsp.frameworkdemo.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroResposta> tratarRegraNegocio(IllegalArgumentException ex) {
        ErroResposta erro = new ErroResposta(400, "Bad Request", ex.getMessage());
        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResposta> tratarValidacao(MethodArgumentNotValidException ex) {
        String mensagem = "Dados invalidos.";
        if (!ex.getBindingResult().getFieldErrors().isEmpty()) {
            mensagem = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        }
        ErroResposta erro = new ErroResposta(400, "Bad Request", mensagem);
        return ResponseEntity.badRequest().body(erro);
    }

    //desafio 4
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResposta> tratarNaoEncontrado(Exception ex) {
        String mensagem = "Produto nao encontrado.";
        ErroResposta erro = new ErroResposta(404, "Not Found", mensagem);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}



