package com.rafaelcdev.casadocodigo.clientes;

import javax.persistence.Embeddable;

@Embeddable
public class EnderecoCliente {

   private String endereco; 
   private String complemento;
   private String cidade;
   private String pais;
   private String estado;
   private String cep;

   @Deprecated
    public EnderecoCliente(){
    }

    public EnderecoCliente(String endereco, String complemento, String cidade, String pais, String estado, String cep) {
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.cep = cep;
    }
}