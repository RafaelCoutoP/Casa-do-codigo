package com.rafaelcdev.casadocodigo.clientes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
    @Column(unique = true)
    private String email;
    private String nome;
    private String sobrenome;
    @Column(unique = true)
    private String documento;
    @Embedded
    private EnderecoCliente endereco;
    @ElementCollection // Anotação necessaria para o JPA criar uma tabela no banco de dados como uma
                       // entidade fraca
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();

    @Deprecated
    public Cliente() {
    }

    public Cliente(Long id, String email, String nome, String sobrenome, String documento, EnderecoCliente endereco) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public EnderecoCliente getEndereco() {
        return endereco;
    }

    public Set<String> getTelefones() {
        return telefones;
    }
}