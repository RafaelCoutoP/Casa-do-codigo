package com.rafaelcdev.casadocodigo.clientes;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.rafaelcdev.casadocodigo.validacao.CPFouCNPJ;

public class ClienteRequest {

    private long id;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @CPFouCNPJ
    private String documento;
    @Valid
    private EnderecoClienteRequest enderecoCliente;
    @NotBlank
    private String telefone1;
    private String telefone2;
    private String telefone3;


    public long getId() {
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

    public EnderecoClienteRequest getEnderecoCliente() {
        return enderecoCliente;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }

    public Cliente toModel() {
        EnderecoCliente novoEndereco = enderecoCliente.paraEndereco();
        Cliente cli = new Cliente(this.id, this.email, this.nome, this.sobrenome, this.documento, novoEndereco);
        cli.getTelefones().add(telefone1);
        if (telefone2 != null) {
            cli.getTelefones().add(telefone2);
        }
        if (telefone3 != null) {
            cli.getTelefones().add(telefone3);
        }
        return cli;
    }
}