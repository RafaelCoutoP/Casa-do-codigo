package com.rafaelcdev.casadocodigo.clientes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nome;
    private String sobrenome; 
    private String documento;
    @Embedded
    private EnderecoCliente endereco;
    private String telefone;
    
    public Cliente(String email, String nome, String sobrenome, String documento, EnderecoCliente endereco,
            String telefone) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.telefone = telefone;
    }
}