package com.rafaelcdev.casadocodigo.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
   
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<TratamentoErroPadrao> validacao (MethodArgumentNotValidException e, HttpServletRequest request){
            TratamentoErroPadrao err = new TratamentoErroPadrao();
            HttpStatus status = HttpStatus.BAD_REQUEST;
            err.setTimestamp(Instant.now());
            err.setStatus(status.value());
            err.setError("Erro de validação");
            err.setMessage(e.getMessage());
            err.setPath(request.getRequestURI());
            return ResponseEntity.status(status).body(err);
    }
}
