package com.rafaelcdev.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CategoriaRequest {
    
    @NotNull 
    @NotBlank 
    private String name;

    public CategoriaRequest(){

    }

    public CategoriaRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Categoria toModel() {
        return new Categoria(this.name);
    }
}