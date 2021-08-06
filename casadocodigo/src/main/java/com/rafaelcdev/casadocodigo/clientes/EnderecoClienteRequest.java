package com.rafaelcdev.casadocodigo.clientes;

import javax.validation.constraints.NotBlank;

public class EnderecoClienteRequest {
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotBlank
    private String pais;
    private String estado;
    @NotBlank
    private String cep;

    /*public EnderecoClienteRequest(String endereco, String complemento, String cidade, String pais, String estado,
            String cep) {
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.cep = cep;
    }*/

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getPais() {
        return pais;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public EnderecoCliente paraEndereco() {
        return new EnderecoCliente(this.endereco, this.complemento, this.cidade, this.pais, this.estado, this.cep);
    }
}