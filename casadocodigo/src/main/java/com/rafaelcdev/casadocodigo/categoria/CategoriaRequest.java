package com.rafaelcdev.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CategoriaRequest {
    
    @NotNull 
    @NotBlank 
    private String nome;

    public CategoriaRequest(){

    }

    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}