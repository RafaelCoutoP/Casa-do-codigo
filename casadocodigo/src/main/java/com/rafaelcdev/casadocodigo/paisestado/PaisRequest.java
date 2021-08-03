package com.rafaelcdev.casadocodigo.paisestado;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    private String nome;

    public PaisRequest(){
    }

    public PaisRequest(String nome) {
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }

    public String getNome() {
        return nome;
    }
}