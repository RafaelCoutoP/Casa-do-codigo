package com.rafaelcdev.casadocodigo.paisestado;

import javax.validation.constraints.NotBlank;

public class EstadoRequest {

    @NotBlank
    private String nome;
    private Long idPais;
   
    public EstadoRequest(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public String getNome() {
        return nome;
    }    

    public Long getIdPais() {
        return idPais;
    }

    public Estado toModel(PaisRepository paisRepository) {
        Pais pais = paisRepository.getById(this.idPais);
        return new Estado(this.nome, pais);
    }
}